package com.deeaae.of.ants.persistence.mongo;

import com.deeaae.of.ants.core.Task;
import com.deeaae.of.ants.core.TaskFetcher;
import com.deeaae.of.ants.persistence.mongo.utils.Mapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("MongoTaskFetcher")
public class MongoTaskFetcher implements TaskFetcher {

  @Autowired
  TaskRepo taskRepo;


  @Override
  public Task getTask(String id) {
    TaskDAO taskDAO =  taskRepo.findById(id).orElse(null);
    return Mapper.taskDAOToTaskMapper(taskDAO);
  }

  @Override
  public List<Task> getTaskByUser(String userId) {
    return null;
  }
}
