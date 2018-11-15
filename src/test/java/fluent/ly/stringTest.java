package fluent.ly;

import static org.junit.Assert.assertEquals;

import static fluent.ly.azzert.assertEquals;
import static fluent.ly.azzert.assertFalse;
import static fluent.ly.azzert.assertTrue;

import java.io.*;
import java.util.*;

import org.junit.*;

@SuppressWarnings({ "static-method" }) public class stringTest {
  @Test public void testAtod() {
    assertEquals(string.atod("5.534534534"), 5.534534534, 0.00001);
  }

  @Test public void testAtof() {
    assertEquals(string.atof("5.534534534"), 5.534534534f, 0.00001f);
  }

  @Test public void testAtoi() {
    assertEquals(string.atoi("5"), 5);
  }

  @Test public void testAtol() {
    assertEquals(string.atol("5234234234234234"), 5234234234234234l);
  }

  @Test public void testCapitelize() {
    assertEquals(string.capitalize("capital"), "Capital");
  }

  @Test public void testEmptyCapitelize() {
    assertEquals(string.capitalize(""), "");
  }

  @Test public void testCat1() {
    assertEquals(string.cat("a", "b", "c", "d", "e"), "abcde");
  }

  @SuppressWarnings("null") @Test public void testCat2() {
    assertEquals(string.cat(new String[] { "a", "b", "c" }, new String[] { "d", "e" }), "abcde");
  }

  @Test public void testDelta1() {
    assertEquals(string.delta(12, 12), 0, 0);
  }

  @Test public void testDelta2() {
    assertEquals(string.delta(12, -11), Double.NaN, 0);
  }

  @Test public void testDelta3() {
    assertEquals(string.delta(1, 2), 2.0 / 3, 0);
  }

  @Test public void testDtoa() {
    assertEquals(string.dtoa(5.534534534), "5.534534534");
  }

  @Test public void testEq1() {
    assertTrue(string.eq(box.it(5), box.it(5)));
  }

  @Test public void testEq2() {
    assertFalse(string.eq(box.it(6), box.it(5)));
  }

  @Test public void testEq3() {
    assertTrue(string.eq(null, null));
  }

  @Test public void testEq4() {
    assertFalse(string.eq(null, box.it(6)));
  }

  @Test public void testEsc1() {
    assertEquals(string.esc('\n'), "\\n");
  }

  @Test public void testEsc2() {
    assertEquals(string.esc('\r'), "\\r");
  }

  @Test public void testEsc3() {
    assertEquals(string.esc('\t'), "\\t");
  }

  @Test public void testEsc4() {
    assertEquals(string.esc('\f'), "\\f");
  }

  @Test public void testEsc5() {
    assertEquals(string.esc('\b'), "\\b");
  }

  @Test public void testEsc6() {
    assertEquals(string.esc('\\'), "\\\\");
  }

  @Test public void testEsc7() {
    assertEquals(string.esc('x'), "x");
  }

  @Test public void testEsc8() {
    assertEquals(string.esc(null), "(null)");
  }

  @Test public void testEsc9() {
    assertEquals(string.esc("hello world\n"), "hello world\\n");
  }

  @Test public void testexpandLeadingTabs1() {
    assertEquals(string.expandLeadingTabs("\thello world"), "    hello world");
  }

  @Test public void testfill1() {
    assertEquals(string.fill(5, 'a'), "aaaaa");
  }

  @Test public void testfill2() {
    assertEquals(string.fill(5, "ab"), "ababababab");
  }

  @Test public void testfirst() {
    assertEquals(string.first("abcde"), 'a');
  }

  @Test public void testftoa() {
    assertEquals(string.ftoa(5.42342f), "5.42342");
  }

  @Test public void testIsDouble1() {
    assertTrue(string.isDouble("5.42342"));
  }

  @Test public void testIsDouble2() {
    assertFalse(string.isDouble("not double"));
  }

  @Test public void testIsFloat1() {
    assertTrue(string.isFloat("5.42342"));
  }

  @Test public void testIsFloat2() {
    assertFalse(string.isFloat("not float"));
  }

  @Test public void testIsInt1() {
    assertTrue(string.isInt("5"));
  }

  @Test public void testIsInt2() {
    assertFalse(string.isInt("5.243"));
  }

  @Test public void testIsLong1() {
    assertTrue(string.isLong("42342343423425"));
  }

  @Test public void testIsLong2() {
    assertFalse(string.isLong("5.243"));
  }

  @Test public void testitoa() {
    assertEquals(string.itoa(5), "5");
  }

  @Test public void testJavaCase1() {
    assertEquals(string.javaCase(""), "");
  }

  @Test public void testJavaCase2() {
    assertEquals(string.javaCase("Hello"), "hello");
  }

  @Test public void testLast() {
    assertEquals(string.last("Hello"), 'o');
  }

  @Test public void testLowCounter1() {
    assertEquals(string.lowCounter(-1), "");
  }

  @Test public void testLowCounter2() {
    assertEquals(string.lowCounter(0), "a");
  }

  @Test public void testLowCounter3() {
    assertEquals(string.lowCounter(1), "b");
  }

  @Test public void testLtoa() {
    assertEquals(string.ltoa(123456789), "123456789");
  }

  @Test public void testOrdinal1() {
    assertEquals(string.ordinal(1), "1st");
  }

  @Test public void testOrdinal2() {
    assertEquals(string.ordinal(11), "11th");
  }

  @Test public void testOrdinal3() {
    assertEquals(string.ordinal(2), "2nd");
  }

  @Test public void testOrdinal4() {
    assertEquals(string.ordinal(12), "12th");
  }

  @Test public void testOrdinal5() {
    assertEquals(string.ordinal(13), "13th");
  }

  @Test public void testParen() {
    assertEquals(string.paren("hello"), "(hello)");
  }

  @Test public void testPluralize0() {
    assertEquals(string.pluralize(0, "apple"), "no apples");
  }

  @Test public void testPluralize1() {
    assertEquals(string.pluralize(1, "apple"), "apple");
  }

  @Test public void testPluralize2() {
    assertEquals(string.pluralize(2, "apple"), "two apples");
  }

  @Test public void testPluralize3() {
    assertEquals(string.pluralize(3, "apple"), "three apples");
  }

  @Test public void testPluralize4() {
    assertEquals(string.pluralize(4, "apple"), "four apples");
  }

  @Test public void testPluralize5() {
    assertEquals(string.pluralize(5, "apple"), "five apples");
  }

  @Test public void testPluralize6() {
    assertEquals(string.pluralize(6, "apple"), "six apples");
  }

  @Test public void testPluralize7() {
    assertEquals(string.pluralize(7, "apple"), "seven apples");
  }

  @Test public void testPluralize8() {
    assertEquals(string.pluralize(8, "apple"), "eight apples");
  }

  @Test public void testPluralize9() {
    assertEquals(string.pluralize(9, "apple"), "nine apples");
  }

  @Test public void testPluralize10() {
    assertEquals(string.pluralize(10, "apple"), "10 apples");
  }

  @SuppressWarnings("null") @Test public void testPretty1() {
    assertEquals(string.pretty("apple", null), "");
  }

  @Test public void testPretty2() {
    assertEquals(string.pretty("apple", new ArrayList<Integer>()), "");
  }

  @Test public void testPretty3() {
    assertEquals(string.pretty("apple", new ArrayList<>(Arrays.asList(box.it(1)))), "1 apple: 1\n");
  }

  @Test public void testPretty4() {
    assertEquals(string.pretty("apple", new ArrayList<>(Arrays.asList(box.it(1), box.it(2)))), "2 apples:\n\t1) 1\n\t2) 2\n");
  }

  @Test public void testPretty5() {
    assertEquals(
        string.pretty("apple",
            new ArrayList<>(Arrays.asList(box.it(1), box.it(2), box.it(3), box.it(4), box.it(5), box.it(6), box.it(7), box.it(8), box.it(9),
                box.it(10), box.it(11), box.it(12), box.it(13), box.it(14), box.it(15), box.it(16), box.it(17), box.it(18), box.it(19), box.it(20),
                box.it(21), box.it(22), box.it(23), box.it(24), box.it(25), box.it(26), box.it(27), box.it(28), box.it(29), box.it(30), box.it(31)))),
        "31 apples:\n\t1) 1\n\t2) 2\n\t3) 3\n\t4) 4\n\t5) 5\n\t6) 6\n\t7) 7\n\t8) 8\n\t9) 9\n\t10) 10\n"
            + "\t11) 11\n\t12) 12\n\t13) 13\n\t14) 14\n\t15) 15\n\t16) 16\n\t17) 17\n\t18) 18\n\t19) 19\n\t20) 20\n"
            + "\t...\n\t22) 22\n\t23) 23\n\t24) 24\n\t25) 25\n\t26) 26\n\t27) 27\n\t28) 28\n\t29) 29\n\t30) 30\n\t31) 31\n");
  }

  @Test public void testQuote() {
    assertEquals(string.quote("apple"), "\'apple\'");
  }

  @Test public void testRepeat() {
    assertEquals(string.repeat(2, 'a'), "aa");
  }

  @Test public void testSignum1() {
    assertEquals(string.signum(0), 0);
  }

  @Test public void testSignum2() {
    assertEquals(string.signum(1), 1);
  }

  @Test public void testSignum3() {
    assertEquals(string.signum(-1), -1);
  }

  @Test public void testSprintf1() {
    assertEquals(string.sprintf("%d", box.it(3)), "3");
  }

  @SuppressWarnings("null") @Test public void testSprintf2() {
    assertEquals(string.sprintf(new String[] {}), "");
  }

  @SuppressWarnings("null") @Test public void testSprintf3() {
    assertEquals(string.sprintf(new String[] { "1" }), "1");
  }

  @SuppressWarnings("null") @Test public void testSprintf4() {
    assertEquals(string.sprintf(new String[] { "%s", "2" }), "2");
  }

  @Test(expected = RuntimeException.class) public void testStrip1() {
    assertEquals(string.strip(""), "");
  }

  @Test public void testStrip2() {
    assertEquals(string.strip("123"), "2");
  }

  @Test public void testToLines() throws IOException {
    assertEquals(string.toLines("1\n2\n3\n"), new ArrayList<>(Arrays.asList("1", "2", "3")));
  }

  @Test public void testUpCounter1() {
    assertEquals(string.upCounter(-1), "");
  }

  @Test public void testUpCounter2() {
    assertEquals(string.upCounter(0), "A");
  }

  @Test public void testUpCounter3() {
    assertEquals(string.upCounter(1), "B");
  }

  @Test public void testVisualize() {
    assertEquals(string.visualize("hello world\n"), "hellosworld\\n");
  }

  @Test public void testWrap() {
    assertEquals(string.wrap("1", "2"), "121");
  }
}
