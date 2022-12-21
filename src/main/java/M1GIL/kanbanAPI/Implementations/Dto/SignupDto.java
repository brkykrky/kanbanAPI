package M1GIL.kanbanAPI.Implementations.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class SignupDto extends BaseResponseDto
{
    private Long id;
    private Date creationDate;
    private String username;
    private String firstName;
    private String lastName;
}
