package org.example.unittesting;

import java.util.HashMap;
import java.util.Map;

public class UserRepoImpl implements UserRepository{
  private final Map<Integer,User> users = new HashMap<>();

  @Override
  public User findById(int id) {
    return users.get(id);
  }

  @Override
  public void save(User user) {
    users.put(user.getId(),user);
  }
}
