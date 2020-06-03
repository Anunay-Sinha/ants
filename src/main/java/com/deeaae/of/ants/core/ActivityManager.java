package com.deeaae.of.ants.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ActivityManager<T> {

  public String getActivityType();
  public Activity<T> addActivity(Activity<T> activity);
  public boolean isActivityDue(Task task, LocalDateTime currentTime);
  public LocalDate nextActivityDueOn(Task task);
  public List<Activity<T>> getLastNActivities(Task task, int n, Page page);
  public void setActivityFetcher(ActivityFetcher activityFetcher);
  public void setActivityLogger(ActivityLogger activityLogger);
  public void setRAGStatusComputer(RagStatusComputer ragStatusComputer);
  public RAGStatus getRAGStatus();

}