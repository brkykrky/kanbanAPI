package M1GIL.kanbanAPI.Implementations.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class User
{
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    private Date creationDate;
    private String firstName;
    private String lastName;
    @Column(unique=true)
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
}
