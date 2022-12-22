package M1GIL.kanbanAPI.Implementations.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserDto extends BaseResponseDto
{
    private Long id;
    private String username;
    private String lastName;
    private String firstName;
}
