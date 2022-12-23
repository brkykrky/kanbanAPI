package M1GIL.kanbanAPI.Implementations.Services;

import M1GIL.kanbanAPI.Implementations.Dto.*;
import M1GIL.kanbanAPI.Implementations.Entities.*;
import M1GIL.kanbanAPI.Implementations.Models.*;
import M1GIL.kanbanAPI.Interfaces.IRepositories.*;
import M1GIL.kanbanAPI.Interfaces.IServices.IKanbanService;
import M1GIL.kanbanAPI.Utility.Mappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service @Transactional @Slf4j
public class KanbanService implements IKanbanService
{
    @Autowired
    IUserRepo userRepo;
    @Autowired
    IKanbanRepo kanbanRepo;
    @Autowired
    ITaskListRepo taskListRepo;
    @Autowired
    ITaskRepo taskRepo;
    @Autowired
    IInvitationRepo invitationRepo;
    @Override
    public KanbanDto create(KanbanDto createDto)
    {
        User creator = userRepo.getById(createDto.getCreatorId());
        Kanban kanban = new Kanban();
        kanban.setCreationDate(new Date(System.currentTimeMillis()));
        kanban.setDescription(createDto.getDescription());
        kanban.setDateLimit(createDto.getDateLimit());
        kanban.setName(createDto.getName());
        kanban.setCreator(creator);
        kanban.setIsPrivate(createDto.getIsPrivate());
        for(Long i : createDto.getUserIds())
        {
            User u = userRepo.getById(i);
            kanban.getUserList().add(u);
            u.getKanbans().add(kanban);
        }

        for(TaskListDto taskListDto : createDto.getTaskLists())
        {
            TaskList taskList = new TaskList();
            taskList.setTitle(taskListDto.getTitle());
            taskList.setKanban(kanban);
            taskList.setCreationDate(taskListDto.getCreationDate());
            for(TaskDto taskDto : taskListDto.getTasks())
            {
                Task task = new Task();
                task.setCreationDate(taskDto.getCreationDate());
                task.setCreator(creator);
                task.setName(taskDto.getName());
                task.setDescription(taskDto.getDescription());
                if(taskDto.getResponsibleId() != null)
                    task.setResponsible(userRepo.getById(taskDto.getResponsibleId()));
                task.setTaskList(taskList);
                taskRepo.save(task);
                userRepo.getById(taskDto.getResponsibleId()).getResponsibleTaskList().add(task);
                taskList.getTasks().add(task);
            }
            taskListRepo.save(taskList);
            kanban.getTaskList().add(taskList);
        }
        creator.getCreatedKanbanList().add(kanban);
        kanbanRepo.save(kanban);
        return Mappers.KanbanToKanbanDto(kanban);
    }

    @Override
    public List<KanbanDto> getPublicList()
    {
        List<KanbanDto> kanbanList = new ArrayList<>();

        for(Kanban k : kanbanRepo.findByIsPrivateFalse())
            kanbanList.add(Mappers.KanbanToKanbanDto(k));

        return kanbanList;
    }

    @Override
    public KanbanDto modify(ModifyKanbanModel modifyKanbanModel)
    {
        Kanban kanban = kanbanRepo.getById(modifyKanbanModel.getId());
        kanban.setName(modifyKanbanModel.getName());
        kanban.setDescription(modifyKanbanModel.getDescription());
        kanban.setDateLimit(modifyKanbanModel.getDateLimit());
        kanban.setIsPrivate(modifyKanbanModel.getIsPrivate());
        return Mappers.KanbanToKanbanDto(kanban);
    }

    @Override
    public BaseResponseDto delete(IdModel idModel)
    {
        Kanban kanban = kanbanRepo.getById(idModel.getId());

        for(TaskList tl : kanban.getTaskList())
        {
            for(Task t : tl.getTasks())
                taskRepo.delete(t);

            taskListRepo.delete(tl);
        }

        kanbanRepo.delete(kanban);
        return new BaseResponseDto(new Date(System.currentTimeMillis()),new ArrayList<>());
    }

    @Override
    public List<KanbanDto> orderKanbans(OrderKanbansModel orderKanbansModel)
    {
        return null;
    }

    @Override
    public List<KanbanDto> getUserKanbans(IdModel idModel)
    {
        User user = userRepo.getById(idModel.getId());

        List<KanbanDto> kanbanDtos = new ArrayList<>();
        for(Kanban k : user.getCreatedKanbanList())
            kanbanDtos.add(Mappers.KanbanToKanbanDto(k));

        return kanbanDtos;
    }

    @Override
    public List<KanbanDto> getParticipedKanbans(IdModel idModel)
    {
        User user = userRepo.getById(idModel.getId());
        List<KanbanDto> kanbanDtos = new ArrayList<>();
        for(Kanban k : user.getKanbans())
            kanbanDtos.add(Mappers.KanbanToKanbanDto(k));

        return kanbanDtos;
    }

    @Override
    public BaseResponseDto inviteUser(InvitationModel invitationModel)
    {
        User receiver = userRepo.getById(invitationModel.getInvitedId());
        User sender = userRepo.getById(invitationModel.getSenderId());
        Kanban kanban = kanbanRepo.getById(invitationModel.getKanbanId());
        Invitation invitation = new Invitation();

        invitation.setKanban(kanban);
        invitation.setSender(sender);
        invitation.setReceiver(receiver);
        invitation.setCreationDate(new Date(System.currentTimeMillis()));
        invitation.setExpirationDate(new Date(System.currentTimeMillis()));
        receiver.getInvitationList().add(invitation);
        invitationRepo.save(invitation);

        return new BaseResponseDto(new Date(System.currentTimeMillis()),new ArrayList<>());
    }

    @Override
    public BaseResponseDto addTaskList(CreateTaskListModel createTaskListModel)
    {
        Kanban kanban = kanbanRepo.getById(createTaskListModel.getKanbanId());
        TaskListDto taskListDto = createTaskListModel.getTaskList();
        TaskList taskList = new TaskList();
        taskList.setCreationDate(new Date(System.currentTimeMillis()));
        taskList.setTitle(taskListDto.getTitle());
        taskList.setKanban(kanban);
        taskListRepo.save(taskList);
        kanban.getTaskList().add(taskList);
        return Mappers.TaskListToTaskListDto(taskList);
    }

    @Override
    public TaskDto addTask(CreateTaskModel createTaskModel)
    {
        TaskList taskList = taskListRepo.getById(createTaskModel.getTaskListId());
        TaskDto taskDto = createTaskModel.getTask();
        Task task = new Task();
        task.setTaskList(taskList);
        task.setDateLimit(taskDto.getDateLimit());
        task.setName(taskDto.getName());
        task.setCreator(userRepo.getById(taskDto.getCreatorId()));
        task.setCreationDate(new Date(System.currentTimeMillis()));
        task.setDescription(taskDto.getDescription());
        task.setResponsible(userRepo.getById(taskDto.getResponsibleId()));
        taskRepo.save(task);
        taskList.getTasks().add(task);
        userRepo.getById(taskDto.getResponsibleId()).getResponsibleTaskList().add(task);
        return Mappers.TaskToTaskDto(task);
    }

    @Override
    public BaseResponseDto deleteTaskList(IdModel idModel)
    {
        TaskList taskList = taskListRepo.getById(idModel.getId());

        for(Task t : taskList.getTasks())
            taskRepo.delete(t);

        taskListRepo.delete(taskList);
        return new BaseResponseDto(new Date(System.currentTimeMillis()),new ArrayList<>());
    }

    @Override
    public BaseResponseDto deleteTask(IdModel idModel)
    {
        taskRepo.deleteById(idModel.getId());
        return new BaseResponseDto(new Date(System.currentTimeMillis()),new ArrayList<>());
    }

    @Override
    public List<InvitationDto> getUserInvitations(IdModel idModel)
    {
        User user = userRepo.getById(idModel.getId());
        List<InvitationDto> invitationDtos = new ArrayList<>();
        for(Invitation i : user.getInvitationList())
        {
            InvitationDto idto = new InvitationDto();
            UserDto receiver = Mappers.UserToUserDto(i.getReceiver());
            UserDto sender = Mappers.UserToUserDto(i.getSender());
            KanbanDto kanban = Mappers.KanbanToKanbanDto(i.getKanban());
            idto.setReceiver(receiver);
            idto.setSender(sender);
            idto.setKanban(kanban);
            invitationDtos.add(idto);
        }
        return invitationDtos;
    }

    @Override
    public BaseResponseDto acceptInvitation(IdModel idModel)
    {
        Invitation invitation = invitationRepo.getById(idModel.getId());
        Kanban kanban = invitation.getKanban();
        User receiver = invitation.getReceiver();
        kanban.getUserList().add(receiver);
        receiver.getKanbans().add(kanban);
        receiver.getInvitationList().remove(invitation);
        invitationRepo.delete(invitation);
        return new BaseResponseDto(new Date(System.currentTimeMillis()),new ArrayList<>());
    }

    @Override
    public BaseResponseDto refuseInvitation(IdModel idModel)
    {
        Invitation invitation = invitationRepo.getById(idModel.getId());
        User receiver = invitation.getReceiver();
        receiver.getInvitationList().remove(invitation);
        invitationRepo.delete(invitation);
        return new BaseResponseDto(new Date(System.currentTimeMillis()),new ArrayList<>());
    }
    @Override
    public TaskDto modifyTask(ModifyTaskModel modifyTaskModel)
    {
        Task task = taskRepo.getById(modifyTaskModel.getId());
        if(modifyTaskModel.getResponsibleId() != null)
        {
            User responsible = task.getResponsible();
            responsible.getResponsibleTaskList().remove(task);
            User newResponsible = userRepo.getById(modifyTaskModel.getResponsibleId());
            task.setResponsible(newResponsible);
            newResponsible.getResponsibleTaskList().add(task);
        }
        if(modifyTaskModel.getTaskListId() != null)
        {
            TaskList taskList = task.getTaskList();
            taskList.getTasks().remove(task);
            TaskList newTaskList = taskListRepo.getById(modifyTaskModel.getTaskListId());
            task.setTaskList(newTaskList);
            newTaskList.getTasks().add(task);
        }
        task.setName(modifyTaskModel.getName());
        task.setDescription(modifyTaskModel.getDescription());

        return Mappers.TaskToTaskDto(task);
    }
    @Override
    public TaskListDto modifyTaskList(ModifyTaskListModel modifyTaskListModel)
    {
        TaskList taskList = taskListRepo.getById(modifyTaskListModel.getId());
        taskList.setTitle(modifyTaskListModel.getTitle());
        return Mappers.TaskListToTaskListDto(taskList);
    }
    @Override
    public KanbanDto getKanban(IdModel idModel)
    {
        return Mappers.KanbanToKanbanDto(kanbanRepo.getById(idModel.getId()));
    }
}