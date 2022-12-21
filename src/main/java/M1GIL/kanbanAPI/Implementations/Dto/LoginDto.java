package M1GIL.kanbanAPI.Implementations.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class LoginDto extends BaseResponseDto
{
    private Long id;
    private Date creationDate;
    private String username;
    private String authToken;
    private String firstName;
    private String lastName;
    private String refreshToken;
}
