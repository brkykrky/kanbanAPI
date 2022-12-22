package M1GIL.kanbanAPI.Interfaces.IControllers;

import M1GIL.kanbanAPI.Implementations.Dto.BaseResponseDto;
import M1GIL.kanbanAPI.Implementations.Dto.KanbanDto;
import M1GIL.kanbanAPI.Implementations.Dto.TaskDto;
import M1GIL.kanbanAPI.Implementations.Models.CreateTaskListModel;
import M1GIL.kanbanAPI.Implementations.Models.CreateTaskModel;
import M1GIL.kanbanAPI.Implementations.Models.IdModel;
import M1GIL.kanbanAPI.Implementations.Models.OrderKanbansModel;
import org.springframework.http.ResponseEntity;

import javax.persistence.Id;
import java.util.List;

public interface IKanbanController
{
    ResponseEntity<KanbanDto> create(KanbanDto createDto);
    ResponseEntity<List<KanbanDto>> getPublicList();
    ResponseEntity<KanbanDto> modify(KanbanDto kanbanDto);
    ResponseEntity<TaskDto> addTask(CreateTaskModel createTaskModel);
    ResponseEntity<BaseResponseDto> deleteTask (IdModel idModel);
    ResponseEntity<BaseResponseDto> delete(IdModel idModel);
    ResponseEntity<List<KanbanDto>> orderKanbans(OrderKanbansModel orderKanbansModel);
    ResponseEntity<List<KanbanDto>> getUserKanbans(IdModel idModel);
    ResponseEntity<List<KanbanDto>> getParticipedKanbans(IdModel idModel);
    ResponseEntity<BaseResponseDto> inviteUser(Long senderId, Long invitedId, Long kanbanId);
    ResponseEntity<BaseResponseDto> addTaskList(CreateTaskListModel addTaskListModel);
    ResponseEntity<BaseResponseDto> deleteTaskList (IdModel idModel);
}