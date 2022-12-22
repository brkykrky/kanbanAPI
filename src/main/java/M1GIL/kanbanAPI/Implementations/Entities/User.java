package M1GIL.kanbanAPI.Implementations.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class User
{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date creationDate;
    private String firstName;
    private String lastName;
    @Column(unique=true)
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "creator")
    private List<Kanban> createdKanbanList = new ArrayList<>();

    @OneToMany(mappedBy= "responsible")
    private List<Task> responsibleTaskList = new ArrayList<>();

    @OneToMany(mappedBy = "creator")
    private List<Task> createdTaskList = new ArrayList<>();

    @OneToMany(mappedBy = "receiver")
    private List<Invitation> invitationList = new ArrayList<>();

    @ManyToMany
    private List<Kanban> kanbans = new ArrayList<>();
}
