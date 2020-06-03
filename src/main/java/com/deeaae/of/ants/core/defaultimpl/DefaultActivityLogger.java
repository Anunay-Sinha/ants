package com.deeaae.of.ants.core.defaultimpl;

import com.deeaae.of.ants.core.Activity;
import com.deeaae.of.ants.core.ActivityLogger;

public class DefaultActivityLogger<T extends Activity> implements ActivityLogger<T> {

  @Override
  public T save(T activity) {
    return activity;
  }
}
