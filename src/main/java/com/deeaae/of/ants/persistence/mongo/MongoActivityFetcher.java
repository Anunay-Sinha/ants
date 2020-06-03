package com.deeaae.of.ants.persistence.mongo;

import com.deeaae.of.ants.core.Activity;
import com.deeaae.of.ants.core.ActivityFetcher;
import com.deeaae.of.ants.core.Page;
import com.deeaae.of.ants.core.Task;
import com.deeaae.of.ants.persistence.mongo.ActivityRepo;
import com.deeaae.of.ants.persistence.mongo.utils.Mapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("MongoActivityFetcher")
public class MongoActivityFetcher implements ActivityFetcher {


  @Autowired
  private ActivityRepo activityRepo;

  @Override
  public Activity getActivity(String id) {
    ActivityDAO activityDAO =  activityRepo.findById(id).orElse(null);
    return Mapper.activityDAOToActivityMapper(activityDAO);
  }

  @Override
  public List<Activity> getLastNActivities(Task task, int n, Page page) {
    if(page == null) {
      page = new Page();
      page.setOffset(0);
      page.setPageSize(n);
    } else {
      if(page.getPageSize()>n) {
        page.setOffset(0);
        page.setPageSize(n);
      }
    }
    Pageable pageable = PageRequest.of(page.getOffset(), page.getPageSize());
    org.springframework.data.domain.Page<ActivityDAO> activityDAOPage =
        activityRepo.findByUserIdAndTaskIdOrderByTimestamp (task.getUserId(), task.getTaskId(), pageable);
    return activityDAOPage.stream().map(Mapper::activityDAOToActivityMapper).collect(Collectors.toList());
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
