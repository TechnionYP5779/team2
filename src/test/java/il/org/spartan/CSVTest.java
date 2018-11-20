package il.org.spartan;

import static il.org.spartan.Utils.*;

import static fluent.ly.azzert.*;

import java.io.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class CSVTest {
  enum Direction {
    UP, RIGHT, DOWN, LEFT;
  }

  @Test public void testCombineClassOfQArray() {
    azzert.that(CSV.combine(new Class<?>[] { Integer.class, String.class, Double.class, null }),
        is("java.lang.Integer,java.lang.String,java.lang.Double," + null));
  }

  @Test public void testCombineEnumArray() {
    azzert.that(CSV.combine(new Direction[] { Direction.UP, Direction.RIGHT, Direction.DOWN, Direction.LEFT, null }),
        is("UP,RIGHT,DOWN,LEFT," + null));
  }

  @Test public void testEscape1() {
    azzert.that(CSV.escape(null), is("\\0"));
  }

  @Test public void testEscape2() {
    azzert.that(CSV.escape("\n\t\r\\,"), is("\\n\\t\\r\\\\\\."));
  }

  @Test public void testLoadFile() {
    final File f = new File("src/test/resources/CSV_input.csv");
    try {
      final String[][] data = CSV.load(f);
      azzert.that(data[0][0], is("A"));
      azzert.that(data[0][1], is("1"));
      azzert.that(data[0][2], is("a"));
      azzert.that(data[1][0], is("B"));
      azzert.that(data[1][1], is("2"));
      azzert.that(data[1][2], is("b"));
    } catch (final IOException ¢) {
      ¢.printStackTrace();
      assert false;
    }
  }

  @Test @SuppressWarnings("null") public void testSave() {
    final File f = new File("src/test/resources/CSV_input.csv");
    try {
      CSV.save(f, cantBeNull(CSV.load(f)));
    } catch (final IOException ¢) {
      ¢.printStackTrace();
      assert false;
    }
  }

  @Test public void testSplitString() {
    azzert.zero(CSV.split("").length);
  }

  @Test public void testSplitEnum() {
    azzert.that(new Direction[] { Direction.UP, Direction.RIGHT, Direction.DOWN, Direction.LEFT },
        is(CSV.split(Direction.class, "UP,RIGHT,DOWN,LEFT")));
  }

  @Test public void testSplitToClasses1() {
    azzert.that(new Class<?>[] { Integer.class, String.class, Double.class },
        is(CSV.splitToClasses("java.lang.Integer,java.lang.String,java.lang.Double")));
  }

  @Test public void testSplitToClasses2() {
    try {
      azzert.that(new Class<?>[] { Integer.class, String.class, Double.class, null },
          is(CSV.splitToClasses("java.lang.Integer,java.lang.String,java.lang.Double," + null)));
    } catch (final RuntimeException ¢) {
      azzert.that(¢.getMessage(), is("s=java.lang.Integer,java.lang.String,java.lang.Double,null"));
    }
  }

  @Test public void testUnescape1() {
    azzert.isNull(CSV.unescape("\\0"));
  }

  @Test public void testUnescape3() {
    azzert.that(CSV.unescape("\\n"), is("\n"));
  }

  @Test public void testUnescape4() {
    azzert.that(CSV.unescape("\\r"), is("\r"));
  }

  @Test public void testUnescape5() {
    azzert.that(CSV.unescape("\\t"), is("\t"));
  }

  @Test public void testUnescape6() {
    azzert.that(CSV.unescape("\\."), is(","));
  }

  @Test public void testUnescape7() {
    azzert.that(CSV.unescape("\\\\"), is("\\"));
  }

  @Test public void testUnescape8() {
    azzert.that(CSV.unescape("g"), is("g"));
  }
}
