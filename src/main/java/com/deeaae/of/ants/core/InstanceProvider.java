package com.deeaae.of.ants.core;

public abstract class InstanceProvider {
  public static final String ACTIVITY_FETCHER_REF = "ActivityFetcher";
  public static final String ACTIVITY_LOGGER_REF = "ActivityLogger";
  public static final String ACTIVITY_MANAGER_REF = "ActivityManager";
  public static final String DAILY_ACTIVITY_MANAGER_REF = "DailyActivityManager";
  public static final String TASK_LOGGER = "TaskLogger";
  public static final String TASK_FETCHER = "TaskFetcher";

  public abstract TaskLogger getTaskLogger(String ref);
  public abstract TaskFetcher getTaskFetcher(String ref);

  public abstract ActivityManager getActivityManager(String ref);
  public abstract ActivityFetcher getActivityFetcher(String ref);
  public abstract ActivityLogger getActivityLogger(String ref);

}
