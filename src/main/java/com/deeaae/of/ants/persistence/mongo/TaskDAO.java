package com.deeaae.of.ants.persistence.mongo;

import com.deeaae.of.ants.core.RAGStatus;
import com.deeaae.of.ants.core.Status;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Task")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskDAO {
  @Id
  String taskId;

  @Indexed
  String userId;

  @CreatedBy
  LocalDateTime createdOn;

  @LastModifiedDate
  LocalDateTime modifiedOn;

  LocalDateTime lastActivity;
  String subject;
  String description;
  String rating;
  Status status;
  RAGStatus ragStatus;
  LocalDateTime ragStatusModifiedDate;
  TaskMeta taskMeta;
}


