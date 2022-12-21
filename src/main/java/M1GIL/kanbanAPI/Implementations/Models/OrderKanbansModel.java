package M1GIL.kanbanAPI.Implementations.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class OrderKanbansModel
{
    private Date realisationDate = null;
    private Date limitDate = null;
    private Boolean orderByAlph = null;
    private Long userId = null;
    private Boolean myProjects = null;
    private Boolean privateProjects = null;
}
