package com.deeaae.of.ants.persistence.mongo.utils;

import com.deeaae.of.ants.core.Activity;
import com.deeaae.of.ants.core.Status;
import com.deeaae.of.ants.core.Task;
import com.deeaae.of.ants.external.ActivityDTO;
import com.deeaae.of.ants.external.TaskDTO;
import com.deeaae.of.ants.persistence.mongo.ActivityDAO;
import com.deeaae.of.ants.persistence.mongo.TaskDAO;
import com.deeaae.of.ants.persistence.mongo.TaskMeta;
import java.time.LocalDateTime;
import java.util.UUID;

public class Mapper {

  public static Activity<String> activityDtoToActivity(ActivityDTO activityDTO) {
    Activity<String> activity = new Activity<>();
    activity.setUserId(activityDTO.getUserId());
    activity.setTaskId(activityDTO.getUserId());
    activity.setData(activityDTO.getData());
    activity.setTimestamp(LocalDateTime.now());
    activity.setId(activityDTO.getId());
    return activity;
  }

  public static ActivityDTO activityToActivityDto(Activity<String> activity) {
    ActivityDTO activityDTO = new ActivityDTO();
    activityDTO.setUserId(activity.getUserId());
    activityDTO.setId(activity.getId());
    activityDTO.setTimestamp(activity.getTimestamp().toString());
    activityDTO.setData(activity.getData());
    activityDTO.setTaskId(activity.getTaskId());
    return activityDTO;
  }

  public static ActivityDAO activityToActivityDAOMapper(Activity<String> activity) {
    ActivityDAO activityDAO = new ActivityDAO();
    activityDAO.setData(activity.getData());
    activityDAO.setId(activity.getId());
    activityDAO.setTaskId(activity.getTaskId());
    activityDAO.setUserId(activity.getUserId());
    activityDAO.setTimestamp(activity.getTimestamp());
    return activityDAO;
  }

  public static Activity<String> activityDAOToActivityMapper(ActivityDAO activityDAO) {
    Activity<String> activity = new Activity<>();
    activity.setData(activityDAO.getData());
    activity.setId(activityDAO.getId());
    activity.setTaskId(activityDAO.getTaskId());
    activity.setTimestamp(activityDAO.getTimestamp());
    activity.setUserId(activityDAO.getUserId());
    return activity;
  }

  public static Task taskDtoToTaskMapper(TaskDTO taskDTO) {
    Task task = new Task();
    task.setTaskId(taskDTO.getTaskId()== null? UUID.randomUUID().toString(): taskDTO.getTaskId());
    task.setSubject(taskDTO.getSubject());
    task.setDescription(taskDTO.getDescription());
    task.setStatus(Status.CREATED);
    task.setUserId(taskDTO.getUserId());
    Task.Meta meta = task.new Meta();
    meta.setActivityLoggerRef("activityLogger");
    meta.setActivityFetcherRef("activityFetcher");
    meta.setActivityManager(taskDTO.getActivityManagerRef());
    task.setMeta(meta);
    return task;
  }

  public static TaskDTO taskToTaskDtoMapper(Task task) {
    TaskDTO taskDTO = TaskDTO.builder().build();
    taskDTO.setUserId(task.getUserId());
    taskDTO.setTaskId(task.getTaskId());
    taskDTO.setSubject(task.getSubject());
    taskDTO.setDescription(task.getDescription());
    taskDTO.setStatus(task.getStatus().toString());
    taskDTO.setActivityManagerRef(task.getMeta().getActivityManager());
    return taskDTO;

  }

  public static Task taskDAOToTaskMapper(TaskDAO taskDAO) {
    Task task = new Task();
    task.setUserId(taskDAO.getUserId());
    task.setTaskId(taskDAO.getTaskId());
    task.setStatus(taskDAO.getStatus());
    task.setDescription(taskDAO.getDescription());
    task.setSubject(taskDAO.getSubject());
    task.setRagStatus(taskDAO.getRagStatus());
    task.setRagStatusLastUpdate(taskDAO.getRagStatusModifiedDate());
    Task.Meta meta = task.new Meta();
    meta.setActivityManager(taskDAO.getTaskMeta().getActivityManager());
    meta.setActivityFetcherRef(taskDAO.getTaskMeta().getActivityFetcherRef());
    meta.setActivityLoggerRef(taskDAO.getTaskMeta().getActivityLoggerRef());
    meta.setRagStatusComputerRef(taskDAO.getTaskMeta().getRagStatusComputerRef());
    task.setMeta(meta);
    return task;
  }

  public static TaskDAO taskToTaskDaoMapper(Task task) {
    TaskDAO taskDAO = new TaskDAO();
    taskDAO.setTaskId(task.getTaskId());
    taskDAO.setUserId(task.getUserId());
    taskDAO.setStatus(task.getStatus());
    taskDAO.setSubject(task.getSubject());
    taskDAO.setDescription(task.getDescription());
    taskDAO.setRagStatus(task.getRagStatus());
    taskDAO.setRagStatusModifiedDate(task.getRagStatusLastUpdate());
    taskDAO.setRating(task.getRating());

    TaskMeta taskMeta = new TaskMeta();
    taskMeta.setRagStatusComputerRef(task.getMeta().getRagStatusComputerRef());
    taskMeta.setActivityFetcherRef(task.getMeta().getActivityFetcherRef());
    taskMeta.setActivityLoggerRef(task.getMeta().getActivityLoggerRef());
    taskMeta.setActivityManager(task.getMeta().getActivityManager());

    taskDAO.setTaskMeta(taskMeta);
    return taskDAO;
  }

}
