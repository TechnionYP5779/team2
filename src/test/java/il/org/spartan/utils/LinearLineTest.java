package il.org.spartan.utils;
import static fluent.ly.azzert.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class LinearLineTest {
  @Test public void test1() {
    LinearLine ll = new LinearLine(1.0,0.0);
    azzert.that(ll.yOf(1.0), is(1.0));
  }
  
  @Test public void test2() {
    LinearLine ll = new LinearLine(1.0,0.0);
    azzert.that(ll.yOf(2.0), is(2.0));
  }
  
  @Test public void getaTest1() {
    LinearLine ll = new LinearLine(1.0,0.0);
    azzert.that(ll.geta(), is(1.0));
  }
  
  @Test public void getaTest2() {
    LinearLine ll = new LinearLine(2.0,0.0);
    azzert.that(ll.geta(), is(2.0));
  }
  
  @Test public void getbTest1() {
    LinearLine ll = new LinearLine(1.0,1.0);
    azzert.that(ll.getb(), is(1.0));
  }
  
  @Test public void getbTest2() {
    LinearLine ll = new LinearLine(0.0,2.0);
    azzert.that(ll.getb(), is(2.0));
  }
}
