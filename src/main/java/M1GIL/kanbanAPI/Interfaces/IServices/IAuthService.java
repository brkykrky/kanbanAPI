package M1GIL.kanbanAPI.Interfaces.IServices;

import M1GIL.kanbanAPI.Implementations.Dto.LoginDto;
import M1GIL.kanbanAPI.Implementations.Dto.SignupDto;
import M1GIL.kanbanAPI.Implementations.Models.LoginModel;
import M1GIL.kanbanAPI.Implementations.Models.SignupModel;

public interface IAuthService
{
    LoginDto Login(LoginModel loginModel);
    SignupDto Signup(SignupModel signupModel);
}
