package M1GIL.kanbanAPI.Implementations.Controllers;

import M1GIL.kanbanAPI.Implementations.Dto.BaseResponseDto;
import M1GIL.kanbanAPI.Implementations.Dto.KanbanDto;
import M1GIL.kanbanAPI.Implementations.Models.CreateTaskListModel;
import M1GIL.kanbanAPI.Implementations.Models.OrderKanbansModel;
import M1GIL.kanbanAPI.Interfaces.IControllers.IKanbanController;
import M1GIL.kanbanAPI.Interfaces.IServices.IKanbanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("/api") @RequiredArgsConstructor
public class KanbanController implements IKanbanController
{
    private final IKanbanService kanbanService;

    @Override
    @PostMapping(path = "/kanban/create")
    public ResponseEntity<KanbanDto> create(KanbanDto createDto)
    {
        return ResponseEntity.ok().body(kanbanService.create(createDto));
    }

    @Override
    @GetMapping(path = "/kanban/public")
    public ResponseEntity<List<KanbanDto>> getPublicList()
    {
        return ResponseEntity.ok().body(kanbanService.getPublicList());
    }

    @Override
    public ResponseEntity<KanbanDto> modify(KanbanDto kanbanDto)
    {
        return null;
    }

    @Override
    public ResponseEntity<BaseResponseDto> delete(Long kanbanId)
    {
        return null;
    }

    @Override
    public ResponseEntity<List<KanbanDto>> orderKanbans(OrderKanbansModel orderKanbansModel)
    {
        return null;
    }

    @Override
    public ResponseEntity<List<KanbanDto>> getUserKanbans(Long userId)
    {
        return null;
    }

    @Override
    public ResponseEntity<List<KanbanDto>> getParticipedKanbans(Long userId)
    {
        return null;
    }

    @Override
    public ResponseEntity<BaseResponseDto> inviteUser(Long senderId, Long invitedId, Long kanbanId)
    {
        return null;
    }

    @Override
    public ResponseEntity<BaseResponseDto> createTaskList(CreateTaskListModel createTaskListModel)
    {
        return null;
    }
}
