package com.deeaae.of.ants.spring;

import com.deeaae.of.ants.core.ActivityFetcher;
import com.deeaae.of.ants.core.ActivityLogger;
import com.deeaae.of.ants.core.ActivityManager;
import com.deeaae.of.ants.core.InstanceProvider;
import com.deeaae.of.ants.core.RagStatusComputer;
import com.deeaae.of.ants.core.TaskFetcher;
import com.deeaae.of.ants.core.TaskLogger;
import com.deeaae.of.ants.core.defaultimpl.DefaultActivityFetcher;
import com.deeaae.of.ants.core.defaultimpl.DefaultActivityLogger;
import com.deeaae.of.ants.core.defaultimpl.DefaultRagStatusComputer;
import com.deeaae.of.ants.daily.DailyActivityManager;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("SpringInstanceProvider")
public class SpringInstanceProvider extends InstanceProvider {

  private static Map<String, String> refClassNameMap;

  public Map getRefClassNameMap() {
    if(refClassNameMap == null) {
      refClassNameMap = new HashMap<>();
      refClassNameMap.put(DAILY_ACTIVITY_MANAGER_REF,"com.deeaae.of.ants.daily.DailyActivityManager");
    }
    return refClassNameMap;
  }

  private <T> T getClass(String className, Class<T> clazz) {
    Object object = null;
    try {
      Class klass = Class.forName(className);
      object = klass.newInstance();
    } catch (Exception ex) {
      throw new RuntimeException("class with class name "+ className + " not found");
    }
    if(clazz.isInstance(object)) {
      return (T)object;
    } else {
      throw new RuntimeException("cannot cast to the class");
    }
  }

  @Autowired
  @Qualifier("MongoTaskLogger")
  private TaskLogger taskLogger;

  @Autowired
  @Qualifier("MongoTaskFetcher")
  private TaskFetcher taskFetcher;

  @Autowired
  @Qualifier("MongoActivityFetcher")
  private ActivityFetcher activityFetcher;

  @Autowired
  @Qualifier("MongoActivityLogger")
  private ActivityLogger activityLogger;

  RagStatusComputer ragStatusComputer = new DefaultRagStatusComputer();


  @Override
  public TaskLogger getTaskLogger(String ref) {
    return taskLogger;
  }

  @Override
  public TaskFetcher getTaskFetcher(String ref) {
    return taskFetcher;
  }

  @Override
  public ActivityManager getActivityManager(String ref) {
    Map<String,String> refMap = getRefClassNameMap();
    return getClass(refMap.get(ref), ActivityManager.class);
  }

  @Override
  public ActivityFetcher getActivityFetcher(String ref) {
    return activityFetcher;
  }

  @Override
  public ActivityLogger getActivityLogger(String ref) {
    return activityLogger;
  }
}
