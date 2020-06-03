package com.deeaae.of.ants.core;

public interface UserHandler {
  User getUser(String userId);
  void notifyUser(String userId, String message);
}
