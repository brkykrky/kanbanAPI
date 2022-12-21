package M1GIL.kanbanAPI.Interfaces.IServices;

import M1GIL.kanbanAPI.Implementations.Dto.BaseResponseDto;
import M1GIL.kanbanAPI.Implementations.Dto.KanbanDto;
import M1GIL.kanbanAPI.Implementations.Models.CreateTaskListModel;
import M1GIL.kanbanAPI.Implementations.Models.OrderKanbansModel;

import java.util.List;

public interface IKanbanService
{
    KanbanDto create(KanbanDto createDto);
    List<KanbanDto> getPublicList();
    KanbanDto modify(KanbanDto kanbanDto);
    BaseResponseDto delete(Long kanbanId);
    List<KanbanDto> orderKanbans(OrderKanbansModel orderKanbansModel);
    List<KanbanDto> getUserKanbans(Long userId);
    List<KanbanDto> getParticipedKanbans(Long userId);
    BaseResponseDto inviteUser(Long senderId, Long invitedId, Long kanbanId);
    BaseResponseDto createTaskList(CreateTaskListModel createTaskListModel);
}
