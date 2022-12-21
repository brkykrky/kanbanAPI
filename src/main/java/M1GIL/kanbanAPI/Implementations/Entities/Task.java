package M1GIL.kanbanAPI.Implementations.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date creationDate;
    private Date dateLimit;
    @Column(unique = true)
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "task_list_id")
    private TaskList taskList;

    @ManyToOne
    @JoinColumn(name ="responsible_id")
    private User responsible;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;
}
