package com.deeaae.of.ants.spring;

import com.deeaae.of.ants.core.ActivityManagerBuilder;
import com.deeaae.of.ants.core.Task;
import com.deeaae.of.ants.core.TaskHandler;
import com.deeaae.of.ants.core.defaultimpl.DefaultTaskHandler;
import org.springframework.stereotype.Component;

@Component
public class SpringTaskBuilder {

  public TaskHandler getTaskHandler(Task task) {
    TaskHandler taskHandler = new DefaultTaskHandler();
    taskHandler.setTask(task);
    return taskHandler;

  }




}
