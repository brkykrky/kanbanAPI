package M1GIL.kanbanAPI.Implementations.Models;

import M1GIL.kanbanAPI.Implementations.Dto.TaskDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class ModifyTaskListModel
{
    private Long id;
    private String title;
}
