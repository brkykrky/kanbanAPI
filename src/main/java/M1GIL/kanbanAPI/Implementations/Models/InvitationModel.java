package M1GIL.kanbanAPI.Implementations.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class InvitationModel
{
    private Long senderId;
    private Long invitedId;
    private Long kanbanId;
}