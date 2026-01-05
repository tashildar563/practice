package org.example.unittesting;

public interface UserRepository {
  User findById(int id);
  void save(User user);

}
