package com.deeaae.of.ants.core;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class Activity<T> {
  private String id;
  private T data;
  private LocalDateTime timestamp;
  private String userId;
  private String taskId;

  public Activity record(LocalDateTime time, T entry, Task task) {
    this.id = UUID.randomUUID().toString();
    this.timestamp = time;
    this.data = entry;
    userId = task.getUserId();
    taskId = task.getTaskId();
    return this;
  }

  public static <T> Activity create(LocalDateTime time, T entry, Task task) {
    Activity activity = new Activity();
    activity.record(time, entry, task);
    return activity;
  }


}
