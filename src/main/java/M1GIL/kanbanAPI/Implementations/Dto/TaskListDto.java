package M1GIL.kanbanAPI.Implementations.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class TaskListDto extends BaseResponseDto
{
    private Long id;
    private Date creationDate;
    private String title;
    private List<TaskDto> tasks = new ArrayList<>();
}
