package com.deeaae.of.ants.core;

public class ActivityManagerBuilder {
  private ActivityFetcher activityFetcher;
  private ActivityLogger activityLogger;
  private ActivityManager activityManager;
  private RagStatusComputer ragStatusComputer;


  public ActivityManagerBuilder setActivityFetcher(ActivityFetcher activityFetcher) {
    this.activityFetcher = activityFetcher;
    return this;
  }


  public ActivityManagerBuilder setActivityManager(ActivityManager activityManager) {
    this.activityManager = activityManager;
    return this;
  }

  public ActivityManagerBuilder setRAGStatusComputer(RagStatusComputer ragStatusComputer) {
    this.ragStatusComputer = ragStatusComputer;
    return this;
  }

  public ActivityManagerBuilder setActivityLogger(ActivityLogger activityLogger) {
    this.activityLogger =activityLogger;
    return this;
  }

  public ActivityManager build() {
    if(activityManager == null) {
      throw new RuntimeException("activity manager not defined");
    }
    activityManager.setActivityFetcher(activityFetcher);
    activityManager.setActivityLogger(activityLogger);
    activityManager.setRAGStatusComputer(ragStatusComputer);
    return activityManager;
  }



}

