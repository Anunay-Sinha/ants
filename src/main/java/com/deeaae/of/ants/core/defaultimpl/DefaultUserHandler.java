package com.deeaae.of.ants.core.defaultimpl;

import com.deeaae.of.ants.core.User;
import com.deeaae.of.ants.core.UserHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultUserHandler implements UserHandler {

  @Override
  public User getUser(String userId) {
    User user = User.builder().userId(userId).username("anunay").lastname("sinha").name("Anunay").build();
    return user;
  }

  @Override
  public void notifyUser(String userId, String message) {
    log.info("Notifying {} : {}", userId, message);
  }
}
