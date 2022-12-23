package M1GIL.kanbanAPI.Implementations.Controllers;

import M1GIL.kanbanAPI.Implementations.Dto.*;
import M1GIL.kanbanAPI.Implementations.Models.*;
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
    @PostMapping(path = "/kanban/modify")
    public ResponseEntity<KanbanDto> modify(@RequestBody ModifyKanbanModel modifyKanbanModel)
    {
        return ResponseEntity.ok().body(kanbanService.modify(modifyKanbanModel));
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
    @PostMapping(path =  "/kanban/getUserKanbans")
    public ResponseEntity<List<KanbanDto>> getUserKanbans(@RequestBody IdModel idModel)
    {
        return ResponseEntity.ok().body(kanbanService.getUserKanbans(idModel));
    }

    @Override
    @PostMapping(path = "/kanban/getParticipedKanbans")
    public ResponseEntity<List<KanbanDto>> getParticipedKanbans(@RequestBody IdModel idModel)
    {
        return ResponseEntity.ok().body(kanbanService.getParticipedKanbans(idModel));
    }

    @Override
    @PostMapping(path = "/kanban/invite")
    public ResponseEntity<BaseResponseDto> inviteUser(@RequestBody InvitationModel invitationModel)
    {
        return ResponseEntity.ok().body(kanbanService.inviteUser(invitationModel));
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

    @Override
    @PostMapping(path = "/kanban/getUserInvitations")
    public ResponseEntity<List<InvitationDto>> getUserInvitations(@RequestBody IdModel idModel)
    {
        return ResponseEntity.ok().body(kanbanService.getUserInvitations(idModel));
    }

    @Override
    @PostMapping(path = "/kanban/acceptInvitation")
    public ResponseEntity<BaseResponseDto> acceptInvitation(@RequestBody IdModel idModel)
    {
        return ResponseEntity.ok().body(kanbanService.acceptInvitation(idModel));
    }

    @Override
    @PostMapping(path = "/kanban/refuseInvitation")
    public ResponseEntity<BaseResponseDto> refuseInvitation(@RequestBody IdModel idModel)
    {
        return ResponseEntity.ok().body(kanbanService.refuseInvitation(idModel));
    }

    @Override
    @PostMapping(path = "/kanban/modifyTask")
    public ResponseEntity<TaskDto> modifyTask(@RequestBody ModifyTaskModel modifyTaskModel)
    {
        return ResponseEntity.ok().body(kanbanService.modifyTask(modifyTaskModel));
    }

    @Override
    @PostMapping(path = "/kanban/modifyTaskList")
    public ResponseEntity<TaskListDto> modifyTaskList(@RequestBody ModifyTaskListModel modifyTaskListModel)
    {
        return ResponseEntity.ok().body(kanbanService.modifyTaskList(modifyTaskListModel));
    }

    @Override
    @PostMapping(path = "/kanban/getKanban")
    public ResponseEntity<KanbanDto> getKanban(IdModel idModel)
    {
        return ResponseEntity.ok().body(kanbanService.getKanban(idModel));
    }
}