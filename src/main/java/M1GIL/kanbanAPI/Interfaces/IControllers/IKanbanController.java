package M1GIL.kanbanAPI.Interfaces.IControllers;

import M1GIL.kanbanAPI.Implementations.Dto.BaseResponseDto;
import M1GIL.kanbanAPI.Implementations.Dto.KanbanDto;
import M1GIL.kanbanAPI.Implementations.Dto.TaskDto;
import M1GIL.kanbanAPI.Implementations.Dto.TaskListDto;
import M1GIL.kanbanAPI.Implementations.Entities.TaskList;
import M1GIL.kanbanAPI.Implementations.Models.CreateTaskListModel;
import M1GIL.kanbanAPI.Implementations.Models.OrderKanbansModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IKanbanController
{
    ResponseEntity<KanbanDto> create(KanbanDto createDto);
    ResponseEntity<List<KanbanDto>> getPublicList();
    ResponseEntity<KanbanDto> modify(KanbanDto kanbanDto);
    ResponseEntity<BaseResponseDto> delete(Long kanbanId);
    ResponseEntity<List<KanbanDto>> orderKanbans(OrderKanbansModel orderKanbansModel);
    ResponseEntity<List<KanbanDto>> getUserKanbans(Long userId);
    ResponseEntity<List<KanbanDto>> getParticipedKanbans(Long userId);
    ResponseEntity<BaseResponseDto> inviteUser(Long senderId, Long invitedId, Long kanbanId);
    ResponseEntity<BaseResponseDto> createTaskList(CreateTaskListModel createTaskListModel);
}