package com.deeaae.of.ants.external;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class ActivityDTO {

  private String id;
  private String data;

  private String timestamp;

  private String userId;

  private String taskId;

}
