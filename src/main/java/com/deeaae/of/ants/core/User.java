package com.deeaae.of.ants.core;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
  String userId;
  String name;
  String lastname;
  String username;
}
