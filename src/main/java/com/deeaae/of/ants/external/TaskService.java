package com.deeaae.of.ants.external;

import com.deeaae.of.ants.core.Activity;
import com.deeaae.of.ants.core.InstanceProvider;
import com.deeaae.of.ants.core.Status;
import com.deeaae.of.ants.core.Task;
import com.deeaae.of.ants.core.TaskHandler;
import com.deeaae.of.ants.core.defaultimpl.DefaultTaskHandler;
import com.deeaae.of.ants.persistence.mongo.TaskDAO;
import com.deeaae.of.ants.persistence.mongo.utils.Mapper;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.omg.PortableInterceptor.ACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  @Autowired
  @Qualifier("SpringInstanceProvider")
  private InstanceProvider instanceProvider;

  private TaskHandler getTaskHandler(InstanceProvider ip, Task task) {
    TaskHandler taskHandler = new DefaultTaskHandler();
    taskHandler.setInstanceProvider(ip);
    if(task != null) {
      taskHandler.setTask(task);
    }
    return taskHandler;
  }

  public TaskDTO getTask(String id) {
    TaskHandler taskHandler = getTaskHandler(instanceProvider, null);
    Task task  =taskHandler.setAndGetTask(id);
    return Mapper.taskToTaskDtoMapper(task);

  }

  public TaskDTO createTask(TaskDTO taskDTO) {
    Task task = Mapper.taskDtoToTaskMapper(taskDTO);
    TaskHandler taskHandler = getTaskHandler(instanceProvider, task);
    taskHandler.createTask(task);
    return taskDTO;
  }

  public ActivityDTO addActivity(ActivityDTO activityDTO, String taskId) {
    TaskHandler taskHandler = getTaskHandler(instanceProvider, null);
    Task task  =taskHandler.setAndGetTask(taskId);
    Activity<String> activity = Mapper.activityDtoToActivity(activityDTO);
    return Mapper.activityToActivityDto(taskHandler.addActivity(activity));
  }

  public List<ActivityDTO> getLastNActivities(String taskId, int n) {
    TaskHandler taskHandler = getTaskHandler(instanceProvider, null);
    Task task  =taskHandler.setAndGetTask(taskId);
    List<Activity<String>> activityList = taskHandler.getLastNActivites(n, null);
    return activityList.stream().map(Mapper::activityToActivityDto).collect(Collectors.toList());


  }



}
