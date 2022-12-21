package M1GIL.kanbanAPI.Implementations.Models;

import M1GIL.kanbanAPI.Implementations.Dto.TaskListDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreateTaskListModel
{
    private TaskListDto taskList;
    private Long kanbanId;
}
