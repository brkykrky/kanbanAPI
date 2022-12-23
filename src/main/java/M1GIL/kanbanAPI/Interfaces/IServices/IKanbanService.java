package M1GIL.kanbanAPI.Interfaces.IServices;

import M1GIL.kanbanAPI.Implementations.Dto.*;
import M1GIL.kanbanAPI.Implementations.Models.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IKanbanService
{
    KanbanDto create(KanbanDto createDto);
    List<KanbanDto> getPublicList();
    KanbanDto modify(ModifyKanbanModel modifyKanbanModel);
    BaseResponseDto delete(IdModel idModel);
    List<KanbanDto> orderKanbans(OrderKanbansModel orderKanbansModel);
    List<KanbanDto> getUserKanbans(IdModel idModel);
    List<KanbanDto> getParticipedKanbans(IdModel idModel);
    BaseResponseDto inviteUser(InvitationModel invitationModel);
    BaseResponseDto addTaskList(CreateTaskListModel createTaskListModel);
    TaskDto addTask(CreateTaskModel createTaskModel);
    BaseResponseDto deleteTaskList(IdModel idModel);
    BaseResponseDto deleteTask(IdModel idModel);
    List<InvitationDto> getUserInvitations(IdModel idModel);
    BaseResponseDto acceptInvitation(IdModel idModel);
    BaseResponseDto refuseInvitation(IdModel idModel);
    TaskDto modifyTask(ModifyTaskModel modifyTaskModel);
    TaskListDto modifyTaskList(ModifyTaskListModel modifyTaskListModel);
    KanbanDto getKanban(IdModel idModel);
}