package M1GIL.kanbanAPI.Implementations.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class KanbanDto
{
    private Long id;
    private Date creationDate;
    private String name;
    private String description;
    private Date dateLimit;
    private Long creatorId;
    private Boolean isPrivate;
}
