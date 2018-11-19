package fluent.ly;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;
import static fluent.ly.string.*;

import java.io.*;
import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class stringTest {
  @Test public void testAtod() {
    azzert.that(atod("5.534534534"), is(5.534534534));
  }

  @Test public void testAtof() {
    azzert.that(atof("5.534534534"), is(5.534534534f));
  }

  @Test public void testAtoi() {
    azzert.that(atoi("5"), is(5));
  }

  @Test public void testAtol() {
    azzert.that(atol("5234234234234234"), is(5234234234234234l));
  }

  @Test public void testCapitelize() {
    azzert.that(capitalize("capital"), is("Capital"));
  }

  @Test public void testEmptyCapitelize() {
    azzert.that(capitalize(""), is(""));
  }

  @Test public void testCat1() {
    azzert.that(cat("a", "b", "c", "d", "e"), is("abcde"));
  }

  @Test @SuppressWarnings("null") public void testCat2() {
    azzert.that(cat(new String[] { "a", "b", "c" }, new String[] { "d", "e" }), is("abcde"));
  }

  @Test public void testDelta1() {
    azzert.that(delta(12, 12), is(0.0));
  }

  @Test public void testDelta2() {
    azzert.that(delta(12, -11), is(Double.NaN));
  }

  @Test public void testDelta3() {
    azzert.that(delta(1, 2), is(2.0 / 3));
  }

  @Test public void testDtoa() {
    azzert.that(dtoa(5.534534534), is("5.534534534"));
  }

  @Test public void testEq1() {
    assert eq(box(5), box(5));
  }

  @Test public void testEq2() {
    assert !eq(box(6), box(5));
  }

  @Test public void testEq3() {
    assert eq(null, null);
  }

  @Test public void testEq4() {
    assert !eq(null, box(6));
  }

  @Test public void testEsc1() {
    azzert.that(esc('\n'), is("\\n"));
  }

  @Test public void testEsc2() {
    azzert.that(esc('\r'), is("\\r"));
  }

  @Test public void testEsc3() {
    azzert.that(esc('\t'), is("\\t"));
  }

  @Test public void testEsc4() {
    azzert.that(esc('\f'), is("\\f"));
  }

  @Test public void testEsc5() {
    azzert.that(esc('\b'), is("\\b"));
  }

  @Test public void testEsc6() {
    azzert.that(esc('\\'), is("\\\\"));
  }

  @Test public void testEsc7() {
    azzert.that(esc('x'), is("x"));
  }

  @Test public void testEsc8() {
    azzert.that(esc(null), is("(null)"));
  }

  @Test public void testEsc9() {
    azzert.that(esc("hello world\n"), is("hello world\\n"));
  }

  @Test public void testexpandLeadingTabs1() {
    azzert.that(expandLeadingTabs("\thello world"), is("    hello world"));
  }

  @Test public void testfill1() {
    azzert.that(fill(5, 'a'), is("aaaaa"));
  }

  @Test public void testfill2() {
    azzert.that(fill(5, "ab"), is("ababababab"));
  }

  @Test public void testfirst() {
    azzert.that(first("abcde"), is('a'));
  }

  @Test public void testftoa() {
    azzert.that(ftoa(5.42342f), is("5.42342"));
  }

  @Test public void testIsDouble1() {
    assert isDouble("5.42342");
  }

  @Test public void testIsDouble2() {
    assert !isDouble("not double");
  }

  @Test public void testIsFloat1() {
    assert isFloat("5.42342");
  }

  @Test public void testIsFloat2() {
    assert !isFloat("not float");
  }

  @Test public void testIsInt1() {
    assert isInt("5");
  }

  @Test public void testIsInt2() {
    assert !isInt("5.243");
  }

  @Test public void testIsLong1() {
    assert isLong("42342343423425");
  }

  @Test public void testIsLong2() {
    assert !isLong("5.243");
  }

  @Test public void testitoa() {
    azzert.that(itoa(5), is("5"));
  }

  @Test public void testJavaCase1() {
    azzert.that(javaCase(""), is(""));
  }

  @Test public void testJavaCase2() {
    azzert.that(javaCase("Hello"), is("hello"));
  }

  @Test public void testLast() {
    azzert.that(last("Hello"), is('o'));
  }

  @Test public void testLowCounter1() {
    azzert.that(lowCounter(-1), is(""));
  }

  @Test public void testLowCounter2() {
    azzert.that(lowCounter(0), is("a"));
  }

  @Test public void testLowCounter3() {
    azzert.that(lowCounter(1), is("b"));
  }

  @Test public void testLtoa() {
    azzert.that(ltoa(123456789), is("123456789"));
  }

  @Test public void testOrdinal1() {
    azzert.that(ordinal(1), is("1st"));
  }

  @Test public void testOrdinal2() {
    azzert.that(ordinal(11), is("11th"));
  }

  @Test public void testOrdinal3() {
    azzert.that(ordinal(2), is("2nd"));
  }

  @Test public void testOrdinal4() {
    azzert.that(ordinal(12), is("12th"));
  }

  @Test public void testOrdinal5() {
    azzert.that(ordinal(13), is("13th"));
  }

  @Test public void testParen() {
    azzert.that(paren("hello"), is("(hello)"));
  }

  @Test public void testPluralize0() {
    azzert.that(pluralize(0, "apple"), is("no apples"));
  }

  @Test public void testPluralize1() {
    azzert.that(pluralize(1, "apple"), is("apple"));
  }

  @Test public void testPluralize2() {
    azzert.that(pluralize(2, "apple"), is("two apples"));
  }

  @Test public void testPluralize3() {
    azzert.that(pluralize(3, "apple"), is("three apples"));
  }

  @Test public void testPluralize4() {
    azzert.that(pluralize(4, "apple"), is("four apples"));
  }

  @Test public void testPluralize5() {
    azzert.that(pluralize(5, "apple"), is("five apples"));
  }

  @Test public void testPluralize6() {
    azzert.that(pluralize(6, "apple"), is("six apples"));
  }

  @Test public void testPluralize7() {
    azzert.that(pluralize(7, "apple"), is("seven apples"));
  }

  @Test public void testPluralize8() {
    azzert.that(pluralize(8, "apple"), is("eight apples"));
  }

  @Test public void testPluralize9() {
    azzert.that(pluralize(9, "apple"), is("nine apples"));
  }

  @Test public void testPluralize10() {
    azzert.that(pluralize(10, "apple"), is("10 apples"));
  }

  @Test @SuppressWarnings("null") public void testPretty1() {
    azzert.that(pretty("apple", null), is(""));
  }

  @Test public void testPretty2() {
    azzert.that(pretty("apple", new ArrayList<Integer>()), is(""));
  }

  @Test public void testPretty3() {
    azzert.that(pretty("apple", new ArrayList<>(Arrays.asList(box(1)))), is("1 apple: 1\n"));
  }

  @Test public void testPretty4() {
    azzert.that(pretty("apple", new ArrayList<>(Arrays.asList(box(1), box(2)))), is("2 apples:\n\t1) 1\n\t2) 2\n"));
  }

  @Test public void testPretty5() {
    azzert
        .that(
            pretty("apple",
                new ArrayList<>(Arrays.asList(box(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                    25, 26, 27, 28, 29, 30, 31 })))),
            is("31 apples:\n\t1) 1\n\t2) 2\n\t3) 3\n\t4) 4\n\t5) 5\n\t6) 6\n\t7) 7\n\t8) 8\n\t9) 9\n\t10) 10\n"
                + "\t11) 11\n\t12) 12\n\t13) 13\n\t14) 14\n\t15) 15\n\t16) 16\n\t17) 17\n\t18) 18\n\t19) 19\n\t20) 20\n"
                + "\t...\n\t22) 22\n\t23) 23\n\t24) 24\n\t25) 25\n\t26) 26\n\t27) 27\n\t28) 28\n\t29) 29\n\t30) 30\n\t31) 31\n"));
  }

  @Test public void testQuote() {
    azzert.that(quote("apple"), is("\'apple\'"));
  }

  @Test public void testRepeat() {
    azzert.that(repeat(2, 'a'), is("aa"));
  }

  @Test public void testSignum1() {
    azzert.zero(signum(0));
  }

  @Test public void testSignum2() {
    azzert.that(signum(1), is(1));
  }

  @Test public void testSignum3() {
    azzert.that(signum(-1), is(-1));
  }

  @Test public void testSprintf1() {
    azzert.that(sprintf("%d", box(3)), is("3"));
  }

  @Test @SuppressWarnings("null") public void testSprintf2() {
    azzert.that(sprintf(new String[] {}), is(""));
  }

  @Test @SuppressWarnings("null") public void testSprintf3() {
    azzert.that(sprintf(new String[] { "1" }), is("1"));
  }

  @Test @SuppressWarnings("null") public void testSprintf4() {
    azzert.that(sprintf(new String[] { "%s", "2" }), is("2"));
  }

  @Test(expected = RuntimeException.class) public void testStrip1() {
    azzert.that(strip(""), is(""));
  }

  @Test public void testStrip2() {
    azzert.that(strip("123"), is("2"));
  }

  @Test public void testToLines() throws IOException {
    azzert.that(toLines("1\n2\n3\n"), is(new ArrayList<>(Arrays.asList("1", "2", "3"))));
  }

  @Test public void testUpCounter1() {
    azzert.that(upCounter(-1), is(""));
  }

  @Test public void testUpCounter2() {
    azzert.that(upCounter(0), is("A"));
  }

  @Test public void testUpCounter3() {
    azzert.that(upCounter(1), is("B"));
  }

  @Test public void testVisualize() {
    azzert.that(visualize("hello world\n"), is("hellosworld\\n"));
  }

  @Test public void testWrap() {
    azzert.that(wrap("1", "2"), is("121"));
  }
}
