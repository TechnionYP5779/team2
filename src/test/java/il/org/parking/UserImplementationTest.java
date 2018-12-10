package il.org.parking;

import org.junit.*;
import org.mockito.*;
import org.mockito.Mockito.*;

public class UserImplementationTest {
  private User user;
  private DataBase db;

  @Before public void setup() {
    this.db = Mockito.mock(DataBase.class);
    this.user = new UserImplementation(12345, "tomy", "tomboy@hotmail.com", db);
  }

  @Test public void testGetId() {
    assert user.getId() == 12345;
  }

  @Test public void testGetId2() {
    assert user.getId() != 123456;
  }

  @Test public void testGetName() {
    assert user.getName() == "tomy";
  }

  @Test public void testGeName2() {
    assert user.getName() != "timoty";
  }

  @Test public void testContactInfo() {
    assert user.getContactInfo() == "tomboy@hotmail.com";
  }
  
  @Test public void testContactInfo2() {
    assert user.getContactInfo() != "tomboy@gmail.com";
  }
  
  @Test public void testUpdate() {
    User newUser = new UserImplementation(111, "cohen", "coco@hotmail.com", db);
    user.update(newUser);
    
    assert user.getId() == 111;
  }
  
  @Test public void testUpdate2() {
    User newUser = new UserImplementation(111, "cohen", "coco@hotmail.com", db);
    user.update(newUser);
    
    assert user.getName() == "cohen";
  }
  
  @Test public void testUpdate3() {
    User newUser = new UserImplementation(111, "cohen", "coco@hotmail.com", db);
    user.update(newUser);
    
    assert user.getContactInfo() == "coco@hotmail.com";
  }
  
  @Test public void testUpdate4() {
    User newUser = new UserImplementation(111, "cohen", "coco@hotmail.com", db);
    user.update(newUser);
    
    Mockito.verify(db, Mockito.times(1)).update(12345, newUser);
  }
}
