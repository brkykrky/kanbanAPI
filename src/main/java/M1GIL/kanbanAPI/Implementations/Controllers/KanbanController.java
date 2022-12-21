package M1GIL.kanbanAPI.Implementations.Controllers;

import M1GIL.kanbanAPI.Interfaces.IControllers.IKanbanController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/api") @RequiredArgsConstructor
public class KanbanController implements IKanbanController
{

}
