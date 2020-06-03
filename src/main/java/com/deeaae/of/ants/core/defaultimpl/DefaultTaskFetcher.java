package com.deeaae.of.ants.core.defaultimpl;

import com.deeaae.of.ants.core.Task;
import com.deeaae.of.ants.core.TaskFetcher;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultTaskFetcher implements TaskFetcher {

  @Override
  public Task getTask(String id) {
    log.info("getting task for id {}", id);
    return null;

  }

  @Override
  public List<Task> getTaskByUser(String userId) {
    log.info("getting task for userId {}", userId);
    return null;
  }
}
