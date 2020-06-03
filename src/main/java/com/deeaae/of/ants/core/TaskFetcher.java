package com.deeaae.of.ants.core;

import java.util.List;

public interface TaskFetcher {
  public Task getTask(String id);
  List<Task> getTaskByUser(String userId);
}
