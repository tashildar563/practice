package org.example.unittesting;


import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {
  public void testGetUserName(){
    UserRepoImpl repository = mock(UserRepoImpl.class);
    when(repository.findById(1)).thenReturn(new User(1,"Rakesh"));

    UserService service = new UserService(repository);
    String name = service.getUserName(1);
    assertEquals("Rakesh",name) ;
  }

}
