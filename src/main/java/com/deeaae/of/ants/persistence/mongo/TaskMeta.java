package com.deeaae.of.ants.persistence.mongo;

import lombok.Data;

@Data
public class TaskMeta {
  private String activityManager;
  private String activityLoggerRef;
  private String activityFetcherRef;
  private String ragStatusComputerRef;

}