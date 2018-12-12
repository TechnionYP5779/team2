package il.org.parking;

import org.junit.*;
import org.mockito.*;


public class UserImplementationTest {
  private User user;
  private DataBase db;

  @Before @SuppressWarnings("null") public void setup() {
    this.db = Mockito.mock(DataBase.class);
    this.user = new UserImplementation(Integer.valueOf(12345), "tomy", "tomboy@hotmail.com", db);
  }

  @Test public void testGetId() {
    assert user.getId().equals(Integer.valueOf(12345));
  }

  @Test public void testGetId2() {
    assert !user.getId().equals(Integer.valueOf(123456));
  }

  @Test public void testGetName() {
    assert "tomy".equals(user.getName());
  }

  @Test public void testGeName2() {
    assert !"timoty".equals(user.getName());
  }

  @Test public void testContactInfo() {
    assert "tomboy@hotmail.com".equals(user.getContactInfo());
  }

  @Test public void testContactInfo2() {
    assert !"tomboy@gmail.com".equals(user.getContactInfo());
  }

  @Test public void testUpdate() {
    User newUser = new UserImplementation(Integer.valueOf(111), "cohen", "coco@hotmail.com", db);
    user.update(newUser);
    assert user.getId().equals(Integer.valueOf(111));
  }

  @Test public void testUpdate2() {
    User newUser = new UserImplementation(Integer.valueOf(111), "cohen", "coco@hotmail.com", db);
    user.update(newUser);
    assert "cohen".equals(user.getName());
  }

  @Test public void testUpdate3() {
    User newUser = new UserImplementation(Integer.valueOf(111), "cohen", "coco@hotmail.com", db);
    user.update(newUser);
    assert "coco@hotmail.com".equals(user.getContactInfo());
  }

  @Test public void testUpdate4() {
    User newUser = new UserImplementation(Integer.valueOf(111), "cohen", "coco@hotmail.com", db);
    user.update(newUser);
    Mockito.verify(db, Mockito.times(1)).update(newUser);
  }
}
