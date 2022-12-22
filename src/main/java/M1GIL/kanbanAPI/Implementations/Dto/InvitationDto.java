package M1GIL.kanbanAPI.Implementations.Dto;

import M1GIL.kanbanAPI.Implementations.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class InvitationDto extends BaseResponseDto
{
    private UserDto sender;
    private UserDto receiver;
    private KanbanDto kanban;
}
