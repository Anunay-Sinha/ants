package com.deeaae.of.ants.test;

import com.deeaae.of.ants.core.Activity;
import com.deeaae.of.ants.core.ActivityFetcher;
import com.deeaae.of.ants.core.ActivityLogger;
import com.deeaae.of.ants.core.ActivityManager;
import com.deeaae.of.ants.core.ActivityManagerBuilder;
import com.deeaae.of.ants.core.RagStatusComputer;
import com.deeaae.of.ants.core.Status;
import com.deeaae.of.ants.core.Task;
import com.deeaae.of.ants.core.TaskHandler;
import com.deeaae.of.ants.core.TaskLogger;
import com.deeaae.of.ants.core.defaultimpl.DefaultActivityFetcher;
import com.deeaae.of.ants.core.defaultimpl.DefaultActivityLogger;
import com.deeaae.of.ants.core.defaultimpl.DefaultRagStatusComputer;
import com.deeaae.of.ants.core.defaultimpl.DefaultTaskHandler;
import com.deeaae.of.ants.daily.DailyActivityManager;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DailyTaskTester {

  ActivityManager activityManager =new DailyActivityManager<>();
  RagStatusComputer ragStatusComputer = new DefaultRagStatusComputer();
  ActivityLogger activityLogger = new DefaultActivityLogger();
  ActivityFetcher activityFetcher = new DefaultActivityFetcher();

  @Autowired
  @Qualifier("MongoTaskLogger")
  private TaskLogger taskLogger;




  /*public void test() {
    Task task = new Task();
    task.setStatus(Status.CREATED);
    task.setDescription("Weight Monitoring on daily basis");
    task.setSubject("Weight under 75");
    task.setCreatedDate(LocalDateTime.now());
    task.setTaskId("radomTesting");
    task.setUserId("anunay");
    Task.Meta meta = task.new Meta();
    meta.setActivityManager("com.deeaae.of.ants.daily.DailyActivityManager");
    meta.setActivityFetcherRef("com.deeaae.of.ants.core.defaultimpl.DefaultActivityFetcher");
    meta.setActivityLoggerRef("com.deeaae.of.ants.core.defaultimpl.DefaultActivityLogger");
    task.setMeta(meta);
    TaskHandler taskHandler = new DefaultTaskHandler();
    taskHandler.setActivityManagerBuilder(getActivityManagerBuilder());
    taskHandler.setTask(task);
    taskHandler.setTaskLogger(taskLogger);
    taskHandler.createTask(task);
    taskHandler.addActivity(Activity.create(LocalDateTime.now(),"75", task));
    System.out.println("hello");


  }*/

  ActivityManagerBuilder getActivityManagerBuilder(){
    ActivityManagerBuilder activityManagerBuilder = new ActivityManagerBuilder();
    activityManagerBuilder.setActivityManager(activityManager);
    activityManagerBuilder.setRAGStatusComputer(ragStatusComputer);
    activityManagerBuilder.setActivityLogger(activityLogger);
    activityManagerBuilder.setActivityFetcher(activityFetcher);
    return activityManagerBuilder;
  }

}
