package M1GIL.kanbanAPI.Interfaces.IRepositories;

import M1GIL.kanbanAPI.Implementations.Entities.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskListRepo extends JpaRepository<TaskList,Long>
{

}
