package com.deeaae.of.ants.persistence.mongo;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Activity")
@Data
public class ActivityDAO {
  @Id
  private String id;
  private String data;
  @Indexed
  private LocalDateTime timestamp;
  @Indexed
  private String userId;
  @Indexed
  private String taskId;

}
