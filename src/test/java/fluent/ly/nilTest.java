package fluent.ly;

import static il.org.spartan.Utils.*;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;
import static fluent.ly.nil.*;
import static fluent.ly.unbox.*;

import java.util.function.*;

import org.junit.*;


@SuppressWarnings("static-method") public class nilTest {
  @Test public void forgettingTest() {
    azzert.isNull(forgetting(new Object()));
    azzert.isNull(forgetting(new Object(), new Object()));
    azzert.isNull(forgetting(new Object(), new Object(), new Object()));
  }

  @Test public void guardinglyTest() {
    azzert.isNull(guardingly(λ -> λ).on(null));
    assert guardingly(λ -> λ).on(box(5)).equals(box(5));
    assert guardingly((final Integer λ) -> box(unbox(cantBeNull(λ)) * unbox(cantBeNull(λ)))).on(box(5)).equals(box(25));
  }

  @Test public void booleanIgnoringTest() {
    azzert.isNull(ignoring(true));
    azzert.isNull(ignoring(false));
  }

  @Test public void doubleIgnoringTest() {
    for (double i = -10; i < 10; i += 0.1)
      assert ignoring(i) == null;
  }

  @Test public void longIgnoringTest() {
    for (long i = -100; i < 101; ++i)
      assert ignoring(i) == null;
  }
  
  static String helloString = "Hello";

  @Test public void t() {
    final Integer i1 = nil.guardingly(String::length).on(helloString);
    azzert.that(i1, is(5));
    final Integer i2 = nil.guardingly(String::length).on(nullString);
    azzert.that(i1, is(5));
    azzert.isNull(i2);
    final Integer i3 = nil.guardingly(f).on(nullString);
    azzert.that(i1, is(5));
    azzert.isNull(i2);
    azzert.isNull(i3);
    nil.guardingly(State::getName).on(null);
    nil.guardingly(State::getName).on(californiaCustomer.getAddress().getState());
  }

  String nullString;
  final Customer californiaCustomer = () -> () -> new State() {
    @Override public String getName() {
      return "California";
    }
  };
  final Function<String, Integer> f = String::length;
  final Customer nullAddressCustomer = () -> null;
  final Customer nullNameCustomer = () -> () -> new State() {/***/
  };
  final Customer nullStateCustomer = () -> () -> null;
  final Customer nullStateCustomer1 = () -> () -> null;

  //@formatter:off
  interface Address { State getState(); }
  interface Customer { Address getAddress(); }
  interface State {default String getName() { return null; } }
}
