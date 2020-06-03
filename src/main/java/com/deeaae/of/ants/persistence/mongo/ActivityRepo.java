package com.deeaae.of.ants.persistence.mongo;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepo extends MongoRepository<ActivityDAO, String> {
  Page<ActivityDAO> findByUserIdAndTaskIdOrderByTimestamp(String userId,String taskId, Pageable pageable);

}
