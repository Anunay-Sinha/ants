package com.deeaae.of.ants.persistence.mongo;

import com.deeaae.of.ants.core.Task;
import com.deeaae.of.ants.core.TaskLogger;
import com.deeaae.of.ants.persistence.mongo.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("MongoTaskLogger")
public class MongoTaskLogger implements TaskLogger {

  @Autowired
  private TaskRepo taskRepo;

  @Override
  public Task save(Task task) {
     taskRepo.save(Mapper.taskToTaskDaoMapper(task));
     return task;
  }

}
