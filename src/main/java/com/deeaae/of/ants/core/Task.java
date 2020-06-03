package com.deeaae.of.ants.core;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Task {
  private String taskId;
  private String userId;
  private String subject;
  private String description;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;
  private LocalDateTime lastActivity;
  private String rating;
  private Status status;
  private Meta meta;
  private RAGStatus ragStatus;
  private LocalDateTime ragStatusLastUpdate;

  @Data
  public class Meta {
    private String activityManager;
    private String activityLoggerRef;
    private String activityFetcherRef;
    private String ragStatusComputerRef;

  }
}

