package M1GIL.kanbanAPI.Interfaces.IRepositories;

import M1GIL.kanbanAPI.Implementations.Entities.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvitationRepo extends JpaRepository<Invitation,Long>
{

}
