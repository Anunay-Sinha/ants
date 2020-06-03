package com.deeaae.of.ants.persistence.mongo;

import com.deeaae.of.ants.core.Activity;
import com.deeaae.of.ants.core.ActivityLogger;
import com.deeaae.of.ants.persistence.mongo.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("MongoActivityLogger")
public class MongoActivityLogger<String> implements ActivityLogger {

  @Autowired
  ActivityRepo activityRepo;

  @Override
  public Activity save(Activity activity) {
    ActivityDAO responseActivityDao = activityRepo.save(Mapper.activityToActivityDAOMapper(activity));
    return Mapper.activityDAOToActivityMapper(responseActivityDao);
  }
}
