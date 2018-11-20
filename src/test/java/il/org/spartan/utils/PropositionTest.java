package il.org.spartan.utils;

import java.util.function.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class PropositionTest {
  @Test public void testAND1() {
    assert Proposition.AND(() -> true, () -> true).eval();
  }

  @Test public void testAND2() {
    assert !Proposition.AND(() -> true, () -> false).eval();
  }

  @Test public void testNot() {
    assert !Proposition.not(() -> true).eval();
  }

  @Test public void testNot2() {
    assert Proposition.not(() -> false).eval();
  }

  @Test public void testThat() {
    assert !Proposition.that(() -> false).eval();
  }

  @Test public void testThat2() {
    assert Proposition.that(() -> true).eval();
  }

  @Test public void testThat3() {
    assert Proposition.that(() -> true).and(() -> true).eval();
  }

  @Test public void testThat4() {
    assert Proposition.that(() -> true).or(() -> false).eval();
  }

  @Test public void testThat5() {
    assert !Proposition.that(() -> true).and(() -> true).and(() -> false).eval();
  }

  @Test public void testF() {
    assert !Proposition.F.eval();
  }

  @Test public void testT() {
    assert Proposition.T.eval();
  }

  @Test(expected = NullPointerException.class) public void testN() {
    assert Proposition.N.eval();
  }

  @Test(expected = AssertionError.class) public void testX() {
    assert Proposition.X.eval();
  }

  @Test public void testOR1() {
    assert Proposition.OR(() -> true, () -> true).eval();
  }

  @Test public void testOR2() {
    assert !Proposition.OR(() -> false, () -> false).eval();
  }

  @Test public void testOR3() {
    assert !Proposition.OR("str", () -> false, () -> false).eval();
  }

  @Test public void testOR4() {
    assert Proposition.OR("str", () -> false, () -> false).or(() -> true).eval();
  }

  @Test public void testOrAnd() {
    assert Proposition.OR("str", () -> false, () -> false).or(() -> true).and(() -> true, () -> true).eval();
  }

  @Test public void testAnd1() {
    assert Proposition.AND(() -> true, () -> true).and(() -> true).eval();
  }

  @Test public void testAnd2() {
    assert !Proposition.AND(() -> true, () -> true).and(() -> false).eval();
  }

  @Test public void testAnd3() {
    assert !Proposition.AND(() -> true, () -> true).and("str", () -> false).eval();
  }

  @Test public void testAnd4() {
    assert !Proposition.AND(() -> true, () -> true).and(() -> false, () -> true).eval();
  }

  @Test public void testAnd5() {
    assert !Proposition.AND(() -> true, () -> true).and(() -> false).eval();
  }

  @Test public void testOr1() {
    assert Proposition.AND(() -> true, () -> true).or("str", () -> false).eval();
  }

  @Test public void testOr2() {
    assert new Proposition.Or(() -> true, () -> false).eval();
  }

  @Test public void testAnd6() {
    assert !new Proposition.And(() -> true, new BooleanSupplier[] { () -> false }).eval();
  }

  @Test public void testSelf() {
    azzert.assertNull(new Proposition.Singleton(() -> true).self());
  }
}
