package il.org.spartan.etc;

import static il.org.spartan.etc.English.*;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.*;

@SuppressWarnings("static-method") public class EnglishTest {
  @Test public void testStem1() {
    azzert.that(Inflection.stem("test").get(), is("test"));
  }

  @Test public void testStem2() {
    azzert.that(Inflection.stem("test").getEd(), is("tested"));
  }

  @Test public void testStem3() {
    azzert.that(Inflection.stem("test").getIng(), is("testing"));
  }

  @Test public void testIsAcronym() {
    assert !isAcronym("test");
  }

  @Test @SuppressWarnings("null") public void testList1() {
    azzert.that(list(null), is("nothing"));
  }

  @Test public void testList2() {
    azzert.that(list(new ArrayList<String>()), is("nothing"));
  }

  @Test public void testList3() {
    azzert.that(list(new ArrayList<>(Arrays.asList("1"))), is("1"));
  }

  @Test public void testList4() {
    azzert.that(list(new ArrayList<>(Arrays.asList("1", "2"))), is("1 and 2"));
  }

  @Test public void testLowerFirstLetter1() {
    azzert.that(lowerFirstLetter("").substring(0, 11), is("genererated"));
  }

  @Test public void testLowerFirstLetter2() {
    azzert.that(lowerFirstLetter("Test"), is("test"));
  }

  @Test public void testName1() {
    azzert.that(name(Object.class), is("Object"));
  }

  @Test public void testName2() {
    azzert.that(name(Inflection.class), is("Inflection.English"));
  }

  @Test public void testName3() {
    azzert.that(English.name((Object) null), is("null"));
  }

  @Test public void testName4() {
    azzert.that(English.name(new String()), is("String"));
  }

  @Test public void testiIndefinite() {
    azzert.that(English.indefinite(new Object()), is("a Object"));
  }

  @Test public void testPlurales1() {
    azzert.that(plurales("test", 1), is("one test"));
  }

  @Test public void testPlurales2() {
    azzert.that(plurales("test", 2), is("2 testes"));
  }

  @Test public void testPlurales3() {
    azzert.that(plurales("test", new Int(1)), is("one test"));
  }

  @Test public void testPlurales4() {
    azzert.that(plurales("test", new Int(2)), is("2 testes"));
  }

  @Test public void testPlurales5() {
    azzert.that(plurales("test", (Int) null), is(English.UNKNOWN + " testes"));
  }

  @Test public void testPlurales6() {
    azzert.that(plurales("test", Integer.valueOf(1)), is("one test"));
  }

  @Test public void testPlurales7() {
    azzert.that(plurales("test", Integer.valueOf(2)), is("2 testes"));
  }

  @Test public void testPlurales8() {
    azzert.that(plurales("test", (Integer) null), is(English.UNKNOWN + " testes"));
  }

  @Test public void testPlurals1() {
    azzert.that(plurals("test", 1), is("one test"));
  }

  @Test public void testPlurals2() {
    azzert.that(plurals("test", 2), is("2 tests"));
  }

  @Test public void testPlurals3() {
    azzert.that(plurals("test", new Int(1)), is("one test"));
  }

  @Test public void testPlurals4() {
    azzert.that(plurals("test", new Int(2)), is("2 tests"));
  }

  @Test public void testPlurals5() {
    azzert.that(plurals("test", (Int) null), is(English.UNKNOWN + " tests"));
  }

  @Test public void testPlurals6() {
    azzert.that(plurals("test", Integer.valueOf(1)), is("one test"));
  }

  @Test public void testPlurals7() {
    azzert.that(plurals("test", Integer.valueOf(2)), is("2 tests"));
  }

  @Test public void testPlurals8() {
    azzert.that(plurals("test", (Integer) null), is(English.UNKNOWN + " tests"));
  }

  @Test public void testPronounce1() {
    azzert.that(pronounce('A'), is("aey"));
  }

  @Test public void testPronounce2() {
    azzert.that(pronounce('b'), is("bee"));
  }

  @Test public void testPronounce3() {
    azzert.that(pronounce('c'), is("see"));
  }

  @Test public void testPronounce4() {
    azzert.that(pronounce('d'), is("dee"));
  }

  @Test public void testPronounce5() {
    azzert.that(pronounce('e'), is("eae"));
  }

  @Test public void testPronounce6() {
    azzert.that(pronounce('f'), is("eff"));
  }

  @Test public void testPronounce7() {
    azzert.that(pronounce('g'), is("gee"));
  }

  @Test public void testPronounce8() {
    azzert.that(pronounce('h'), is("eitch"));
  }

  @Test public void testPronounce9() {
    azzert.that(pronounce('i'), is("eye"));
  }

  @Test public void testPronounce10() {
    azzert.that(pronounce('j'), is("jay"));
  }

  @Test public void testPronounce11() {
    azzert.that(pronounce('k'), is("kay"));
  }

  @Test public void testPronounce12() {
    azzert.that(pronounce('l'), is("ell"));
  }

  @Test public void testPronounce13() {
    azzert.that(pronounce('m'), is("em"));
  }

  @Test public void testPronounce14() {
    azzert.that(pronounce('n'), is("en"));
  }

  @Test public void testPronounce15() {
    azzert.that(pronounce('o'), is("oh"));
  }

  @Test public void testPronounce16() {
    azzert.that(pronounce('p'), is("pee"));
  }

  @Test public void testPronounce17() {
    azzert.that(pronounce('q'), is("queue"));
  }

  @Test public void testPronounce18() {
    azzert.that(pronounce('r'), is("ar"));
  }

  @Test public void testPronounce19() {
    azzert.that(pronounce('s'), is("ess"));
  }

  @Test public void testPronounce20() {
    azzert.that(pronounce('t'), is("tee"));
  }

  @Test public void testPronounce21() {
    azzert.that(pronounce('u'), is("you"));
  }

  @Test public void testPronounce22() {
    azzert.that(pronounce('v'), is("vee"));
  }

  @Test public void testPronounce23() {
    azzert.that(pronounce('w'), is("some character"));
  }

  @Test public void testPronounce24() {
    azzert.that(pronounce('x'), is("exx"));
  }

  @Test public void testPronounce25() {
    azzert.that(pronounce('y'), is("why"));
  }

  @Test public void testPronounce26() {
    azzert.that(pronounce('z'), is("zee"));
  }

  @Test public void testRepeat() {
    azzert.that(repeat(3, 'a'), is("aaa"));
  }

  @Test public void testSelfName1() {
    azzert.that(English.selfName(Object.class), is("Object"));
  }

  @Test public void testSelfName2() {
    azzert.that(English.selfName(new Object() {
      @Override protected Object clone() throws CloneNotSupportedException {
        return super.clone();
      }
    }.getClass()), is("{}"));
  }

  @Test public void testSelfName3() {
    azzert.that(English.selfName(Deprecated.class), is("@Deprecated"));
  }

  @Test public void testTime() {
    azzert.that(time(10000000000000l), is("10000.00"));
  }

  @Test public void testTrim1() {
    azzert.assertNull(trim(null));
  }

  @Test public void testTrim2() {
    azzert.that(trim("1\n2\n3\n"), is("1\n2\n3"));
  }

  @Test public void testTrimAbsolute1() {
    azzert.that(trimAbsolute("123456", 6, ""), is("123456"));
  }

  @Test public void testTrimAbsolute2() {
    azzert.that(trimAbsolute("123456", 5, "789"), is("12789"));
  }

  @Test public void testUnknownIfNull1() {
    azzert.that(unknownIfNull(null), is(English.UNKNOWN));
  }

  @Test public void testUnknownIfNull2() {
    azzert.that(unknownIfNull("1"), is("1"));
  }

  @Test public void testUnknownIfNull3() {
    azzert.that(unknownIfNull(null, λ -> "3"), is(English.UNKNOWN));
  }

  @Test public void testUnknownIfNull4() {
    azzert.that(unknownIfNull("1", λ -> "3"), is("3"));
  }

  @Test public void testUpperFirstLetter1() {
    azzert.that(upperFirstLetter("").substring(0, 11), is("genererated"));
  }

  @Test public void testUpperFirstLetter2() {
    azzert.that(upperFirstLetter("test"), is("Test"));
  }

  @Test public void testIndefinite1() {
    azzert.that(indefinite("apple"), is("an apple"));
  }

  @Test public void testIndefinite2() {
    azzert.that(indefinite("Test"), is("a Test"));
  }

  @Test public void testIndefinite3() {
    azzert.that(indefinite("T"), is("an tee"));
  }
}
