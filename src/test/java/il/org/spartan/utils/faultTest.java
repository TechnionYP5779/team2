package il.org.spartan.utils;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class faultTest {
  @Test public void testDoneStackCaptureNotNull() {
    azzert.notNull(fault.done());
  }

  @Test public void testTraceStackCaptureNotNull() {
    azzert.notNull(fault.trace());
  }

  @Test public void testDumpValue() {
    azzert.that(fault.dump(), is("\n FAULT: this should not have happened!\n-----To help you fix the code, here is some info"));
  }

  @Test public void testSpecificallyNotNull() {
    azzert.notNull(fault.specifically("Explanation string", box(1), "Hey", "There", box(2)));
  }

  @Test public void testUnreachableIsFalse() {
    assert !fault.unreachable();
  }

  @Test public void testBoolIsFalse() {
    assert !fault.bool("Hey");
  }
}
