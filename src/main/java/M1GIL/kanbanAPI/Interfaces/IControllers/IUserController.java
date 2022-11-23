package M1GIL.kanbanAPI.Interfaces.IControllers;

import M1GIL.kanbanAPI.Implementations.Entities.Role;
import M1GIL.kanbanAPI.Implementations.Entities.User;
import M1GIL.kanbanAPI.Implementations.Models.UserRoleModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserController
{
    ResponseEntity<List<User>> getUsers();
    ResponseEntity<User>saveUser(User user);
    ResponseEntity<Role>saveRole(Role role);
    ResponseEntity<?>addRoleToUser(UserRoleModel userRole);
}
