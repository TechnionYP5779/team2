package il.org.spartan.etc;

import org.junit.*;


@SuppressWarnings("static-method")
public class forgetTest {
   @Test public void testForgetAll() {
    forget.all("hi");
    forget.all("hi", "bye");
    forget.all(Integer.valueOf(1), "hi", Integer.valueOf(3));
    forget.all(Double.valueOf(1.1), Integer.valueOf(2));
  }
   
   @Test public void testForgetItBoolean() {
     forget.it(true);
     forget.it(false);
   }
   
   @Test public void testForgetItDouble() {
     forget.it(Double.valueOf(1.19));
   }
   
   @Test public void testForgetItLong() {
     forget.it(Long.valueOf(Long.MAX_VALUE/2));
   }
   
   @Test public void testForgetItObject() {
     forget.it("hi");
     forget.it(true);
     forget.it(Integer.valueOf(3));
   }
}
