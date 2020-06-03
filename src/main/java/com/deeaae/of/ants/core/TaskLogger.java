package com.deeaae.of.ants.core;

public interface TaskLogger<T extends Task> {
  T save(T task);

}
