package M1GIL.kanbanAPI.Implementations.Services;

import M1GIL.kanbanAPI.Implementations.Dto.BaseResponseDto;
import M1GIL.kanbanAPI.Implementations.Dto.KanbanDto;
import M1GIL.kanbanAPI.Implementations.Dto.TaskDto;
import M1GIL.kanbanAPI.Implementations.Dto.TaskListDto;
import M1GIL.kanbanAPI.Implementations.Entities.Kanban;
import M1GIL.kanbanAPI.Implementations.Entities.Task;
import M1GIL.kanbanAPI.Implementations.Entities.TaskList;
import M1GIL.kanbanAPI.Implementations.Entities.User;
import M1GIL.kanbanAPI.Implementations.Models.CreateTaskListModel;
import M1GIL.kanbanAPI.Implementations.Models.OrderKanbansModel;
import M1GIL.kanbanAPI.Interfaces.IRepositories.IKanbanRepo;
import M1GIL.kanbanAPI.Interfaces.IRepositories.ITaskListRepo;
import M1GIL.kanbanAPI.Interfaces.IRepositories.ITaskRepo;
import M1GIL.kanbanAPI.Interfaces.IRepositories.IUserRepo;
import M1GIL.kanbanAPI.Interfaces.IServices.IKanbanService;
import M1GIL.kanbanAPI.Utility.Mappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
            kanban.getUserList().add(userRepo.getById(i));

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
                taskList.getTasks().add(task);
            }
            taskListRepo.save(taskList);
            kanban.getTaskList().add(taskList);
        }
        System.out.println("HEREEEEE 333333333");
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
    public KanbanDto modify(KanbanDto kanbanDto)
    {
        return null;
    }

    @Override
    public BaseResponseDto delete(Long kanbanId)
    {
        return null;
    }

    @Override
    public List<KanbanDto> orderKanbans(OrderKanbansModel orderKanbansModel)
    {
        return null;
    }

    @Override
    public List<KanbanDto> getUserKanbans(Long userId)
    {
        return null;
    }

    @Override
    public List<KanbanDto> getParticipedKanbans(Long userId)
    {
        return null;
    }

    @Override
    public BaseResponseDto inviteUser(Long senderId, Long invitedId, Long kanbanId)
    {
        return null;
    }

    @Override
    public BaseResponseDto createTaskList(CreateTaskListModel createTaskListModel)
    {
        return null;
    }
}