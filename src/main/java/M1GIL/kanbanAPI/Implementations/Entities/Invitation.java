package M1GIL.kanbanAPI.Implementations.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Invitation
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date creationDate;
    private Date expirationDate;

    @OneToOne
    @JoinColumn(name = "sender_id")
    private User sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;
    @OneToOne
    @JoinColumn(name = "kanban_id" )
    private Kanban kanban;
}
