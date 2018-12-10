package il.org.parking;

import org.junit.*;
import org.mockito.*;

public class UserImplementationTest {
  
  private static User user;
  
  @BeforeClass
  public static void setup() {
    DataBase db = Mockito.mock(DataBase.class);
    user = new UserImplementation(12345, "tomy", "tomboy@hotmail.com", db);
  }
  
  @Test public static void testGetId() {
    assert user.getId() == 12345;
  }
  
  @Test public static void testGetId2() {
    assert user.getId() != 123456;
  }
  
  @Test public static void testGetName() {
    assert user.getName() == "tomy";
  }
  
  @Test public static void testGeName2() {
    assert user.getName() != "timoty";
  }
  
  @Test public static void testContactInfo() {
    assert user.getContactInfo() == "tomboy@hotmail.com";
  }
}
