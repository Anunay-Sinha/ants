package com.deeaae.of.ants.core.defaultimpl;

import com.deeaae.of.ants.core.ActivityFetcher;
import com.deeaae.of.ants.core.RAGStatus;
import com.deeaae.of.ants.core.RagStatusComputer;

public class DefaultRagStatusComputer implements RagStatusComputer {

  @Override
  public RAGStatus getRagStatus(String activityType, ActivityFetcher activityFetcher) {
    return RAGStatus.GREEN;
  }
}
