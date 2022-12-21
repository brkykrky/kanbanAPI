package M1GIL.kanbanAPI;

import M1GIL.kanbanAPI.Implementations.Dto.KanbanDto;
import M1GIL.kanbanAPI.Implementations.Dto.TaskDto;
import M1GIL.kanbanAPI.Implementations.Dto.TaskListDto;
import M1GIL.kanbanAPI.Implementations.Entities.Role;
import M1GIL.kanbanAPI.Implementations.Entities.Task;
import M1GIL.kanbanAPI.Implementations.Entities.User;
import M1GIL.kanbanAPI.Interfaces.IServices.IKanbanService;
import M1GIL.kanbanAPI.Interfaces.IServices.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class KanbanApiApplication
{
	public static void main(String[] args) {
		SpringApplication.run(KanbanApiApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(IUserService userService, IKanbanService kanbanService)
	{
		return args ->
		{
			userService.saveRole(new Role(null,"ADMIN"));
			userService.saveRole(new Role(null,"USER"));

			userService.saveUser(new User(null,new Date(System.currentTimeMillis()) ,"john","lastName1","user1","12345",new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
			userService.saveUser(new User(null,new Date(System.currentTimeMillis()),"emily","lastName2","user2","12345",new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));

			userService.addRoleToUser("user1","ADMIN");
			userService.addRoleToUser("user1","USER");
			userService.addRoleToUser("user2","USER");

			TaskDto task = new TaskDto(null,new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),"task1","description task 1",3L,3L);
			List<TaskDto> tasks = new ArrayList<>();
			tasks.add(task);
			TaskListDto taskList = new TaskListDto(null,new Date(System.currentTimeMillis()),"title 1",tasks);
			List<TaskListDto> taskLists = new ArrayList<>();
			taskLists.add(taskList);

			List<Long> userIds = new ArrayList<>();
			userIds.add(3L);
			kanbanService.create(new KanbanDto(null,new Date(System.currentTimeMillis()),"kanban1","description kanban",new Date(System.currentTimeMillis()),3L,true,taskLists,userIds));
		};
	}
}
