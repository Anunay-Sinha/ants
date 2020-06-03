package com.deeaae.of.ants.core;

public interface ActivityLogger<T extends Activity> {
  public T save(T activity);
}
