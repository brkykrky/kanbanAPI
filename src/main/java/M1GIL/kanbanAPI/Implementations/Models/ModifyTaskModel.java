package M1GIL.kanbanAPI.Implementations.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class ModifyTaskModel
{
    private Long id;
    private Date dateLimit;
    private String name;
    private String description;
    private Long responsibleId;
    private Long taskListId;
}
