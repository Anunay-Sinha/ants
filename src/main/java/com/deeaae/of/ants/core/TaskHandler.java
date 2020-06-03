package com.deeaae.of.ants.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskHandler {
  public void setTask(Task task);
  public Task setAndGetTask(String taskId);
  public Activity addActivity(Activity activity);
  public RAGStatus getRAGStatus();
  public Status getStatus();
  public LocalDate nextActivityDueOn();
  public boolean isActivityDue();
  public DataProvider getDataProvider();
  public List<Activity<String>> getLastNActivites(int n, Page page);
  public Task createTask(Task task);
  public void setInstanceProvider(InstanceProvider instanceProvider);

}
