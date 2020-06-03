package com.deeaae.of.ants.core.defaultimpl;

import com.deeaae.of.ants.core.Activity;
import com.deeaae.of.ants.core.ActivityFetcher;
import com.deeaae.of.ants.core.Page;
import com.deeaae.of.ants.core.Task;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultActivityFetcher implements ActivityFetcher {


  @Override
  public Activity getActivity(String id) {
    log.info("fetching activity for id {}", id);
    return null;
  }

  @Override
  public List<Activity> getLastNActivities(Task task, int n, Page page) {
    return null;
  }

  @Override
  public List<Activity> getLastNDaysActivities(Task task, int nDays, Page page) {
    return null;
  }

  @Override
  public List<Activity> getLastNWeeksActivities(Task task, int nWeeks, Page page) {
    return null;
  }
}
