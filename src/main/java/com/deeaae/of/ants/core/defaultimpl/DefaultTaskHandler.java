package com.deeaae.of.ants.core.defaultimpl;

import com.deeaae.of.ants.core.Activity;
import com.deeaae.of.ants.core.ActivityManager;
import com.deeaae.of.ants.core.ActivityManagerBuilder;
import com.deeaae.of.ants.core.DataProvider;
import com.deeaae.of.ants.core.InstanceProvider;
import com.deeaae.of.ants.core.Page;
import com.deeaae.of.ants.core.RAGStatus;
import com.deeaae.of.ants.core.Status;
import com.deeaae.of.ants.core.Task;
import com.deeaae.of.ants.core.TaskFetcher;
import com.deeaae.of.ants.core.TaskHandler;
import com.deeaae.of.ants.core.TaskLogger;
import com.deeaae.of.ants.core.TaskValidator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class DefaultTaskHandler implements TaskHandler {
  private Task task ;

  private ActivityManagerBuilder activityManagerBuilder = new ActivityManagerBuilder();
  private ActivityManager activityManager;
  private TaskLogger taskLogger;
  private InstanceProvider instanceProvider;
  private TaskFetcher taskFetcher;
  private TaskValidator taskValidator = new TaskValidator();

  @Override
  public void setInstanceProvider(InstanceProvider instanceProvider) {
    this.instanceProvider = instanceProvider;
    onInstanceProviderAddition(instanceProvider);
  }

  private void onInstanceProviderAddition(InstanceProvider ip) {
    taskLogger = ip.getTaskLogger("default");
    taskFetcher = ip.getTaskFetcher("default");
  }


  @Override
  public void setTask(Task task) {
    this.task = task;
    onTaskAddition(task);
  }

  @Override
  public Task setAndGetTask(String taskId) {
    task = taskFetcher.getTask(taskId);
    onTaskAddition(task);
    return task;
  }


  private void onTaskAddition(Task task) {
    Task.Meta meta = task.getMeta();
    activityManagerBuilder.setActivityFetcher(instanceProvider.getActivityFetcher(task.getMeta().getActivityFetcherRef()));
    activityManagerBuilder.setActivityManager(instanceProvider.getActivityManager(task.getMeta().getActivityManager()));
    activityManagerBuilder.setActivityLogger(instanceProvider.getActivityLogger(task.getMeta().getActivityLoggerRef()));
    activityManager = activityManagerBuilder.build();
  }

  @Override
  public Task createTask(Task task) {
    if(taskValidator.validate(task, null)) {
      this.task = taskLogger.save(task);
      onTaskAddition(task);
      return task;
    } else {
      throw new RuntimeException("invalid task");
    }
  }

  @Override
  public Activity addActivity(Activity activity) {
    activity.setTaskId(task.getTaskId());
    activity.setUserId(task.getUserId());
    return activityManager.addActivity(activity);
  }

  @Override
  public RAGStatus getRAGStatus() {
    return null;
  }

  @Override
  public Status getStatus() {
    return null;
  }

  @Override
  public LocalDate nextActivityDueOn() {
    return activityManager.nextActivityDueOn(task);
  }

  @Override
  public boolean isActivityDue() {
    return false;
  }

  @Override
  public DataProvider getDataProvider() {
    return null;
  }

  @Override
  public List<Activity<String>> getLastNActivites(int n, Page page) {
    return activityManager.getLastNActivities(task,n,page);
  }
}
