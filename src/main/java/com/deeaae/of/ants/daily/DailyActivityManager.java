package com.deeaae.of.ants.daily;

import com.deeaae.of.ants.core.Activity;
import com.deeaae.of.ants.core.ActivityFetcher;
import com.deeaae.of.ants.core.ActivityLogger;
import com.deeaae.of.ants.core.ActivityManager;
import com.deeaae.of.ants.core.ActivityRegistry;
import com.deeaae.of.ants.core.Page;
import com.deeaae.of.ants.core.RAGStatus;
import com.deeaae.of.ants.core.RagStatusComputer;
import com.deeaae.of.ants.core.Task;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.util.List;

public class DailyActivityManager<T> implements ActivityManager {

  private ActivityLogger activityLogger;
  private ActivityFetcher activityFetcher;
  private RagStatusComputer ragStatusComputer;

  @Override
  public String getActivityType() {
    return ActivityRegistry.dailyActivity;
  }

  @Override
  public Activity addActivity(Activity activity) {
    if(activityLogger == null) {
      throw new RuntimeException("activity logger not defined");
    }
    return activityLogger.save(activity);
  }

  @Override
  public void setActivityLogger(ActivityLogger activityLogger) {
    this.activityLogger = activityLogger;
  }

  @Override
  public boolean isActivityDue(Task task, LocalDateTime currentTime) {
    if(activityFetcher == null) {
      throw new RuntimeException("activity fetcher not defined.");
    }
    List<Activity> activityList = activityFetcher.getLastNActivities(task, 1, null);
    if(activityList == null || activityList.size() == 0) {
      return true;
    }
    return isActivityRecordedToday(activityList.get(0), currentTime);
  }

  private boolean isActivityRecordedToday(Activity activity, LocalDateTime currentDateTime) {
    LocalDate dateOfLastActivity = activity.getTimestamp().toLocalDate();
    LocalDate currentDate = currentDateTime.toLocalDate();
    if(dateOfLastActivity.toEpochDay() == currentDate.toEpochDay()) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public LocalDate nextActivityDueOn(Task task) {
    if(activityFetcher == null) {
      throw new RuntimeException("activity fetcher not defined.");
    }
    List<Activity> activityList = activityFetcher.getLastNActivities(task,1, null);
    if(activityList == null || activityList.size() == 0) {
      return LocalDate.now();
    }
    if(isActivityRecordedToday(activityList.get(0), LocalDateTime.now())) {
      return LocalDate.now();
    } else {
      return LocalDate.now().plusDays(1);
    }
  }

  @Override
  public List<Activity> getLastNActivities(Task task, int n, Page page) {
    return activityFetcher.getLastNActivities(task, n, page);
  }

  @Override
  public void setActivityFetcher(ActivityFetcher activityFetcher) {
    this.activityFetcher = activityFetcher;
  }

  @Override
  public void setRAGStatusComputer(RagStatusComputer ragStatusComputer) {
    this.ragStatusComputer = ragStatusComputer;
  }

  @Override
  public RAGStatus getRAGStatus() {
    if(ragStatusComputer == null) {
      throw new RuntimeException("RAG status computer is not defined");
    }
    return ragStatusComputer.getRagStatus(this.getActivityType(), activityFetcher);
  }
}
