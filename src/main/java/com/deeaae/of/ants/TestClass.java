package com.deeaae.of.ants;

import com.deeaae.of.ants.core.Status;
import com.deeaae.of.ants.core.Task;

public class TestClass {
  public Task createWeightTask() {
    Task task = new Task();
    Task.Meta meta = task.new Meta();
    task.setSubject("Control weight and maintain it to 75 for 4 weeks");
    task.setDescription(task.getSubject());
    task.setStatus(Status.CREATED);

    return task;


  }

}
