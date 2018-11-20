package fluent.ly;

import static fluent.ly.anonymous.*;
import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class anonymousTest {
  @Test public void booleanTest1() {
    azzert.that(ly(() -> true), is(true));
  }

  @Test public void booleanTest2() {
    azzert.that(!ly(() -> true), is(false));
  }

  @Test public void doubleTest1() {
    azzert.that(1.5, is(ly(() -> 1.5)));
  }

  @Test public void doubleTest2() {
    azzert.that(500.0, is(ly(() -> 500.0)));
  }

  @Test public void intTest1() {
    azzert.that(1, is(ly(() -> 1)));
  }

  @Test public void intTest2() {
    azzert.that(500, is(ly(() -> 500)));
  }

  @Test public void longTest1() {
    azzert.that(500548943L, is(ly(() -> 500548943L)));
  }

  @Test public void longTest2() {
    azzert.that(1325489434L, is(ly(() -> 1325489434L)));
  }

  @Test @SuppressWarnings("null") public void tTest() {
    azzert.that(anonymous.ly(() -> Collections.EMPTY_LIST), isA(List.class));
  }
}
