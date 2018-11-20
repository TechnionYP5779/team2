package il.org.spartan;

import static fluent.ly.azzert.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class tideTest {
  @Test public void testClean1() {
    azzert.that(tide.clean("    code"), is("code"));
  }

  @Test public void testClean2() {
    azzert.that(tide.clean("code      "), is("code"));
  }

  @Test public void testClean3() {
    for (final @NotNull String operator : new @NotNull String[] { ":", "/", "%", ",", "=", ":", ";", ">", ">=", "!=", "==", "<", "<=", "-" })
      azzert.that(tide.clean("code    " + operator + "   code"), is("code" + operator + "code"));
  }

  @Test public void testClean4() {
    for (final @NotNull String operator : new @NotNull String[] { "\\{", "\\}", "\\?", "\\+", "\\*", "\\|", "\\&", "\\(", "\\)" })
      azzert.that(tide.clean("code    " + operator + "   code"), is("code " + operator + "code"));
  }

  @Test public void testEq1() {
    assert tide.eq("str", "str");
  }

  @Test public void testEq2() {
    assert tide.eq(null, null);
  }

  @Test public void testEq3() {
    assert !tide.eq(null, "str");
  }

  @Test public void testEq4() {
    assert !tide.eq("str1", "str2");
  }

  @Test public void testEq5() {
    assert !tide.eq("str", null);
  }

  @Test public void testEq6() {
    assert tide.eq(String.valueOf("str"), String.valueOf("str"));
  }
}
