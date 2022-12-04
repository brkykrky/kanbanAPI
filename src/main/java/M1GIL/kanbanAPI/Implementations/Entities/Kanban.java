package M1GIL.kanbanAPI.Implementations.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Kanban
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date creationDate;
    private String name;
    private String description;
    private Date dateLimit;

    @ManyToOne
    @JoinColumn(name="creator_id")
    private User creator;
    private Boolean isPrivate;

    @OneToMany(mappedBy = "kanban")
    private List<TaskList> taskList = new ArrayList<>();

    @ManyToMany
    private List<User> userList = new ArrayList<>();
}
