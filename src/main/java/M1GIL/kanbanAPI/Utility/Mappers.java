package M1GIL.kanbanAPI.Utility;

import M1GIL.kanbanAPI.Implementations.Dto.KanbanDto;
import M1GIL.kanbanAPI.Implementations.Dto.TaskDto;
import M1GIL.kanbanAPI.Implementations.Dto.TaskListDto;
import M1GIL.kanbanAPI.Implementations.Dto.UserDto;
import M1GIL.kanbanAPI.Implementations.Entities.Kanban;
import M1GIL.kanbanAPI.Implementations.Entities.Task;
import M1GIL.kanbanAPI.Implementations.Entities.TaskList;
import M1GIL.kanbanAPI.Implementations.Entities.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mappers
{
    public static KanbanDto KanbanToKanbanDto(Kanban kanban)
    {
        KanbanDto kanbanDto = new KanbanDto();
        kanbanDto.setDate(new Date(System.currentTimeMillis()));
        kanbanDto.setId(kanban.getId());
        kanbanDto.setCreationDate(kanban.getCreationDate());
        kanbanDto.setName(kanban.getName());
        kanbanDto.setDescription(kanban.getDescription());
        kanbanDto.setDateLimit(kanban.getDateLimit());
        kanbanDto.setCreatorId(kanban.getCreator().getId());

        for(TaskList t : kanban.getTaskList())
            kanbanDto.getTaskLists().add(TaskListToTaskListDto(t));

        for(User u : kanban.getUserList())
            kanbanDto.getUserIds().add(u.getId());

        return kanbanDto;
    }

    public static TaskListDto TaskListToTaskListDto(TaskList taskList)
    {
        TaskListDto taskListDto = new TaskListDto();
        taskListDto.setDate(new Date(System.currentTimeMillis()));
        taskListDto.setId(taskList.getId());
        taskListDto.setCreationDate(taskList.getCreationDate());
        taskListDto.setTitle(taskList.getTitle());

        for(Task t : taskList.getTasks())
            taskListDto.getTasks().add(TaskToTaskDto(t));

        return taskListDto;
    }
    public static TaskDto TaskToTaskDto(Task task)
    {
        TaskDto taskDto = new TaskDto();
        taskDto.setDate(new Date(System.currentTimeMillis()));
        taskDto.setId(task.getId());
        taskDto.setName(task.getName());
        taskDto.setDateLimit(task.getDateLimit());
        taskDto.setDescription(task.getDescription());
        taskDto.setCreatorId(task.getCreator().getId());
        taskDto.setCreationDate(task.getCreationDate());
        return taskDto;
    }
    public static UserDto UserToUserDto(User user)
    {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setUsername(user.getUsername());
        userDto.setLastName(user.getLastName());
        userDto.setId(user.getId());
        userDto.setDate(new Date(System.currentTimeMillis()));
        return userDto;
    }
}
