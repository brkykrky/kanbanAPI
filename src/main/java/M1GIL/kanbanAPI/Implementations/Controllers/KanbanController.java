package M1GIL.kanbanAPI.Implementations.Controllers;

import M1GIL.kanbanAPI.Implementations.Dto.BaseResponseDto;
import M1GIL.kanbanAPI.Implementations.Dto.KanbanDto;
import M1GIL.kanbanAPI.Implementations.Dto.TaskDto;
import M1GIL.kanbanAPI.Implementations.Models.CreateTaskListModel;
import M1GIL.kanbanAPI.Implementations.Models.CreateTaskModel;
import M1GIL.kanbanAPI.Implementations.Models.IdModel;
import M1GIL.kanbanAPI.Implementations.Models.OrderKanbansModel;
import M1GIL.kanbanAPI.Interfaces.IControllers.IKanbanController;
import M1GIL.kanbanAPI.Interfaces.IServices.IKanbanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api") @RequiredArgsConstructor
public class KanbanController implements IKanbanController
{
    private final IKanbanService kanbanService;

    @Override
    @PostMapping(path = "/kanban/create")
    public ResponseEntity<KanbanDto> create(@RequestBody KanbanDto createDto)
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
    @PostMapping(path = "/kanban/addTask")
    public ResponseEntity<TaskDto> addTask(@RequestBody CreateTaskModel createTaskModel)
    {
        return ResponseEntity.ok().body(kanbanService.addTask(createTaskModel));
    }

    @Override
    @PostMapping(path = "/kanban/deleteTask")
    public ResponseEntity<BaseResponseDto> deleteTask(@RequestBody IdModel idModel)
    {
        return ResponseEntity.ok().body(kanbanService.deleteTask(idModel));
    }

    @Override
    @PostMapping(path = "/kanban/delete")
    public ResponseEntity<BaseResponseDto> delete(@RequestBody IdModel idModel)
    {
        return ResponseEntity.ok().body(kanbanService.delete(idModel));
    }

    @Override
    public ResponseEntity<List<KanbanDto>> orderKanbans(OrderKanbansModel orderKanbansModel)
    {
        return null;
    }

    @Override
    public ResponseEntity<List<KanbanDto>> getUserKanbans(IdModel idModel)
    {
        return null;
    }

    @Override
    public ResponseEntity<List<KanbanDto>> getParticipedKanbans(IdModel idModel)
    {
        return null;
    }

    @Override
    public ResponseEntity<BaseResponseDto> inviteUser(Long senderId, Long invitedId, Long kanbanId)
    {
        return null;
    }

    @Override
    @PostMapping(path = "/kanban/addTaskList")
    public ResponseEntity<BaseResponseDto> addTaskList(@RequestBody CreateTaskListModel createTaskListModel)
    {
        return ResponseEntity.ok().body(kanbanService.addTaskList(createTaskListModel));
    }

    @Override
    @PostMapping(path = "/kanban/deleteTaskList")
    public ResponseEntity<BaseResponseDto> deleteTaskList(@RequestBody IdModel idModel)
    {
        return ResponseEntity.ok().body(kanbanService.deleteTaskList(idModel));
    }
}
