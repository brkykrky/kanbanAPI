package M1GIL.kanbanAPI.Implementations.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class TaskDto extends BaseResponseDto
{
    private Long id;
    private Date creationDate;
    private Date dateLimit;
    private String name;
    private String description;
    private Long responsibleId;
    private Long creatorId;
}
