package il.org.spartan.utils;

import static il.org.spartan.Utils.*;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;
import static fluent.ly.unbox.*;

import java.util.function.*;

import org.junit.*;

import fluent.ly.*;

public class PropositionReducerTest {
  class MyReduce extends Reduce<Integer> {
    @Override public Integer reduce() {
      return box(0);
    }

    @Override public Integer reduce(final Integer r1, final Integer r2) {
      return box(unbox(cantBeNull(r1)) + unbox(cantBeNull(r2)));
    }
  }

  class MyPropositionReducer extends PropositionReducer<Integer> {
    public MyPropositionReducer(final Reduce<Integer> inner) {
      super(inner);
    }

    @Override protected Integer map(final BooleanSupplier ¢) {
      return box(¢.getAsBoolean() ? 1 : -1);
    }
  }

  MyPropositionReducer myPropositionReducer = new MyPropositionReducer(new MyReduce());

  @Test public void testReduce1() {
    azzert.that(myPropositionReducer.reduce(), is(box(0)));
  }

  @Test public void testReduce2() {
    azzert.that(myPropositionReducer.reduce(() -> true), is(box(1)));
  }

  @Test public void testReducePropositionAND() {
    azzert.that(myPropositionReducer.reduce(Proposition.AND(() -> true, () -> true)), is(box(2)));
  }

  @Test public void testReducePropositionOR() {
    azzert.that(myPropositionReducer.reduce(Proposition.OR(() -> true, () -> true)), is(box(2)));
  }

  @Test public void testReducePropositionNot() {
    azzert.that(myPropositionReducer.reduce(Proposition.not(() -> true)), is(box(1)));
  }

  @Test public void testReducePropositionThat() {
    azzert.that(myPropositionReducer.reduce(Proposition.that(() -> true)), is(box(1)));
  }
}
