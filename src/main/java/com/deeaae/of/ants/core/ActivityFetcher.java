package com.deeaae.of.ants.core;

import java.util.List;

public interface ActivityFetcher {
  public Activity getActivity(String id);
  public List<Activity> getLastNActivities(Task task, int n, Page page);
  public List<Activity> getLastNDaysActivities(Task task, int nDays, Page page);
  public List<Activity> getLastNWeeksActivities(Task task, int nWeeks, Page page);

}
