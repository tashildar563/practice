package org.example.unittesting;

public class UserService {
  private final UserRepoImpl repo;

  public UserService(UserRepoImpl repo) {
    this.repo = repo;
  }

  public String getUserName(int i) {
    User usr = repo.findById(i);
    return usr.getName();
  }
}
