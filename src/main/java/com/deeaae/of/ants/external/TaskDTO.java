package com.deeaae.of.ants.external;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class TaskDTO {
  private String taskId;
  private String userId;
  private String subject;
  private String description;
  private String datatype;
  private String status;
  private String activityManagerRef;
}
