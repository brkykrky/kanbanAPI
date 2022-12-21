package M1GIL.kanbanAPI.Implementations.Models;


import M1GIL.kanbanAPI.Implementations.Dto.TaskDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CreateTaskModel
{
    private TaskDto task;
    private Long taskListId;
}
