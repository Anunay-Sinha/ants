package com.deeaae.of.ants.external;

import com.deeaae.of.ants.core.Activity;
import com.deeaae.of.ants.core.Task;
import com.deeaae.of.ants.persistence.mongo.TaskDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {
  @Autowired
  TaskService taskService;

  @RequestMapping(value = "", method = RequestMethod.POST)
  public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
    return ResponseEntity.ok(taskService.createTask(taskDTO));
  }

  @RequestMapping(value = "/{taskId}", method = RequestMethod.GET)
  public ResponseEntity<TaskDTO> getTask(@PathVariable String taskId) {
    return ResponseEntity.ok(taskService.getTask(taskId));

  }

  @RequestMapping(value = "/{taskId}/activity", method = RequestMethod.POST)
  public ResponseEntity<ActivityDTO> addActivity(@RequestBody ActivityDTO activityDTO, @PathVariable String taskId) {
    return ResponseEntity.ok(taskService.addActivity(activityDTO, taskId));
  }

  @RequestMapping(value = "/{taskId}/activity", method = RequestMethod.GET)
  public ResponseEntity<List<ActivityDTO>> getNActivity(@PathVariable String taskId, @RequestParam(required = false, defaultValue = "10") int n) {
    return ResponseEntity.ok(taskService.getLastNActivities(taskId, n));
  }


}
