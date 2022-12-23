package M1GIL.kanbanAPI.Interfaces.IControllers;

import M1GIL.kanbanAPI.Implementations.Dto.*;
import M1GIL.kanbanAPI.Implementations.Models.*;
import org.springframework.http.ResponseEntity;

import javax.persistence.Id;
import java.util.List;

public interface IKanbanController
{
    ResponseEntity<KanbanDto> create(KanbanDto createDto);
    ResponseEntity<List<KanbanDto>> getPublicList();
    ResponseEntity<KanbanDto> modify(ModifyKanbanModel modifyKanbanModel);
    ResponseEntity<TaskDto> addTask(CreateTaskModel createTaskModel);
    ResponseEntity<BaseResponseDto> deleteTask (IdModel idModel);
    ResponseEntity<BaseResponseDto> delete(IdModel idModel);
    ResponseEntity<List<KanbanDto>> orderKanbans(OrderKanbansModel orderKanbansModel);
    ResponseEntity<List<KanbanDto>> getUserKanbans(IdModel idModel);
    ResponseEntity<List<KanbanDto>> getParticipedKanbans(IdModel idModel);
    ResponseEntity<BaseResponseDto> inviteUser(InvitationModel invitationModel);
    ResponseEntity<BaseResponseDto> addTaskList(CreateTaskListModel addTaskListModel);
    ResponseEntity<BaseResponseDto> deleteTaskList (IdModel idModel);
    ResponseEntity<List<InvitationDto>> getUserInvitations(IdModel idModel);
    ResponseEntity<BaseResponseDto> acceptInvitation(IdModel idModel);
    ResponseEntity<BaseResponseDto> refuseInvitation(IdModel idModel);
    ResponseEntity<TaskDto> modifyTask(ModifyTaskModel modifyTaskModel);
    ResponseEntity<TaskListDto> modifyTaskList(ModifyTaskListModel modifyTaskListModel);
    ResponseEntity<KanbanDto> getKanban(IdModel idModel);
}