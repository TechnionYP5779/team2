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
}
