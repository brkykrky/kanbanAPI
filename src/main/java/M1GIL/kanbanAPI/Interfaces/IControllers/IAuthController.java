package M1GIL.kanbanAPI.Interfaces.IControllers;

import M1GIL.kanbanAPI.Implementations.Dto.LoginDto;
import M1GIL.kanbanAPI.Implementations.Dto.SignupDto;
import M1GIL.kanbanAPI.Implementations.Models.LoginModel;
import M1GIL.kanbanAPI.Implementations.Models.SignupModel;
import org.springframework.http.ResponseEntity;

public interface IAuthController
{
    ResponseEntity<LoginDto>login(LoginModel loginModel);
    ResponseEntity<SignupDto>signup(SignupModel signupModel);
}
