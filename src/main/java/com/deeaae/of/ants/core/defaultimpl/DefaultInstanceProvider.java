package com.deeaae.of.ants.core.defaultimpl;

import com.deeaae.of.ants.core.ActivityFetcher;
import com.deeaae.of.ants.core.ActivityLogger;
import com.deeaae.of.ants.core.ActivityManager;
import com.deeaae.of.ants.core.InstanceProvider;
import com.deeaae.of.ants.core.TaskFetcher;
import com.deeaae.of.ants.core.TaskLogger;
import java.util.HashMap;
import java.util.Map;

public class DefaultInstanceProvider extends InstanceProvider {
  private static Map<String, String> refClassNameMap;
  public Map getRefClassNameMap() {
    if(refClassNameMap == null) {
      refClassNameMap = new HashMap<>();
      refClassNameMap.put(ACTIVITY_FETCHER_REF,"com.deeaae.of.ants.core.defaultimpl.DefaultActivityFetcher");
      refClassNameMap.put(ACTIVITY_LOGGER_REF,"com.deeaae.of.ants.core.defaultimpl.DefaultActivityLogger");
      refClassNameMap.put(ACTIVITY_MANAGER_REF,"com.deeaae.of.ants.daily.DailyActivityManager");
      refClassNameMap.put(DAILY_ACTIVITY_MANAGER_REF,"com.deeaae.of.ants.daily.DailyActivityManager");
      refClassNameMap.put(TASK_LOGGER, "com.deeaae.of.ants.core.defaultimpl.DefaultTaskHandler");

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

  @Override
  public TaskLogger getTaskLogger(String ref) {
    Map<String,String> refMap = getRefClassNameMap();
    return getClass(refMap.get(ref), TaskLogger.class);
  }

  @Override
  public TaskFetcher getTaskFetcher(String ref) {
    return null;
  }

  @Override
  public ActivityManager getActivityManager(String ref) {
    Map<String,String> refMap = getRefClassNameMap();
    return getClass(refMap.get(ref), ActivityManager.class);
  }

  @Override
  public ActivityFetcher getActivityFetcher(String ref) {
    Map<String,String> refMap = getRefClassNameMap();
    return getClass(refMap.get(ref), ActivityFetcher.class);
  }

  @Override
  public ActivityLogger getActivityLogger(String ref) {
    Map<String,String> refMap = getRefClassNameMap();
    return getClass(refMap.get(ref), ActivityLogger.class);
  }
}
