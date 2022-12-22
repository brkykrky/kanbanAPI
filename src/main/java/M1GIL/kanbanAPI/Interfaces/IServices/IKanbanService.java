package M1GIL.kanbanAPI.Interfaces.IServices;

import M1GIL.kanbanAPI.Implementations.Dto.BaseResponseDto;
import M1GIL.kanbanAPI.Implementations.Dto.KanbanDto;
import M1GIL.kanbanAPI.Implementations.Dto.TaskDto;
import M1GIL.kanbanAPI.Implementations.Models.CreateTaskListModel;
import M1GIL.kanbanAPI.Implementations.Models.CreateTaskModel;
import M1GIL.kanbanAPI.Implementations.Models.IdModel;
import M1GIL.kanbanAPI.Implementations.Models.OrderKanbansModel;

import java.util.List;

public interface IKanbanService
{
    KanbanDto create(KanbanDto createDto);
    List<KanbanDto> getPublicList();
    KanbanDto modify(KanbanDto kanbanDto);
    BaseResponseDto delete(IdModel idModel);
    List<KanbanDto> orderKanbans(OrderKanbansModel orderKanbansModel);
    List<KanbanDto> getUserKanbans(IdModel idModel);
    List<KanbanDto> getParticipedKanbans(IdModel idModel);
    BaseResponseDto inviteUser(Long senderId, Long invitedId, Long kanbanId);
    BaseResponseDto addTaskList(CreateTaskListModel createTaskListModel);
    TaskDto addTask(CreateTaskModel createTaskModel);
    BaseResponseDto deleteTaskList(IdModel idModel);
    BaseResponseDto deleteTask(IdModel idModel);
}
