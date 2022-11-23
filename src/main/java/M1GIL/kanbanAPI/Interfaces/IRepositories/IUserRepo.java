package M1GIL.kanbanAPI.Interfaces.IRepositories;

import M1GIL.kanbanAPI.Implementations.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Long>
{
    User findByusername(String username);
}
