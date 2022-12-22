package M1GIL.kanbanAPI.Implementations.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class ModifyKanbanModel
{
    private Long id;
    private String name;
    private String description;
    private Date dateLimit;
    private Boolean isPrivate;
}