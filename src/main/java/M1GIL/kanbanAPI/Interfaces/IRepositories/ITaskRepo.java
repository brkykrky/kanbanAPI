package M1GIL.kanbanAPI.Interfaces.IRepositories;

import M1GIL.kanbanAPI.Implementations.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepo extends JpaRepository<Task,Long>
{

}
