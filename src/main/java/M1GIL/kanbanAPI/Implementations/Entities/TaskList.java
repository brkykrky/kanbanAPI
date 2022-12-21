package M1GIL.kanbanAPI.Implementations.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class TaskList
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date creationDate;
    private String title;

    @ManyToOne
    @JoinColumn(name="kanban_id")
    private Kanban kanban;

    @OneToMany(mappedBy = "taskList")
    private List<Task> tasks = new ArrayList<>();
}
