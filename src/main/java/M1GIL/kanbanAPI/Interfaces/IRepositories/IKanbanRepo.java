package M1GIL.kanbanAPI.Interfaces.IRepositories;

import M1GIL.kanbanAPI.Implementations.Entities.Kanban;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IKanbanRepo extends JpaRepository<Kanban,Long>
{
    Iterable<Kanban> findByIsPrivateFalse();
}
