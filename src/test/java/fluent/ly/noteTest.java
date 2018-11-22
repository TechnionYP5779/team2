package fluent.ly;

import static fluent.ly.note.*;

import java.io.*;
import java.util.logging.*;

import org.junit.*;

@SuppressWarnings("static-method") public class noteTest {
  @Test public void testTrace() {
    final String real_trace = __.trace();
    assert real_trace.contains("fluent.ly.note$__.trace");
  }

  static class MyHandler extends Handler {
    public String str;

    @Override public void publish(final LogRecord ¢) {
      str = ¢.getMessage();
    }

    @Override public void flush() {
      // empty
    }

    @Override public void close() {
      // empty
    }

    public String get() {
      return str;
    }
  }

  MyHandler myHandler;
  final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  final PrintStream originalErr = System.err;

  @Before public void beforeEach() {
    System.setErr(new PrintStream(errContent));
    myHandler = new MyHandler();
    Logger.getGlobal().addHandler(myHandler);
    set(Level.ALL);
  }

  @After public void afterEach() {
    System.setErr(originalErr);
    unset();
  }

  @Test public void testBug_1() {
    bug("hello", "a_string");
    assert myHandler.get().contains("A bug was detected in the vicinty of fluent.ly.note$__.trace");
  }

  @Test public void testBug_2() {
    bug("hello", "a_string");
    assert myHandler.get().contains("hello");
  }

  @Test public void testBug2_1() {
    bug("123");
    assert myHandler.get().contains("A bug was detected in the vicinty of fluent.ly.note$__.trace");
  }

  @Test public void testBug2_2() {
    bug("123");
    assert myHandler.get().contains("Instance involved is a String");
  }

  @Test public void testBug3_1() {
    bug();
    assert myHandler.get().contains("A bug was detected in the vicinty of fluent.ly.note$__.trace");
  }

  @Test public void testBug3_2() {
    bug();
    assert myHandler.get().contains("Instance involved is a String");
  }

  @Test public void testBug4_1() {
    bug("123", new Throwable());
    assert myHandler.get().contains("An instance of String was hit by an Throwable exception.");
  }

  @Test public void testBug4_2() {
    bug("123", new Throwable());
    assert myHandler.get().contains("String = '123'");
  }

  @Test public void testBug4_3() {
    bug("123", new Throwable());
    assert myHandler.get().contains("Throwable = 'java.lang.Throwable'");
  }

  @Test public void testBug4_4() {
    bug("123", new Throwable());
    assert myHandler.get().contains("This is an indication of a bug.");
  }

  @Test public void testBug5_1() {
    bug(new Throwable());
    assert myHandler.get().contains("A static method was hit by an Throwable exception.");
  }

  @Test public void testBug5_2() {
    bug(new Throwable());
    assert myHandler.get().contains("This is an indication of a bug.");
  }

  @Test public void testBug5_3() {
    bug(new Throwable());
    assert myHandler.get().contains("Throwable = 'java.lang.Throwable'");
  }

  @Test public void testCancel1_1() {
    cancel(new Exception());
    assert myHandler.get().contains("Exception (probably cancellation) exception.");
  }

  @Test public void testCancel1_2() {
    cancel(new Exception());
    assert myHandler.get().contains("x = 'java.lang.Exception'");
  }

  @Test public void testCancel2_1() {
    cancel("123", new Exception());
    assert myHandler.get().contains("Exception (probably cancellation) exception.");
  }

  @Test public void testCancel2_2() {
    cancel("123", new Exception());
    assert myHandler.get().contains("x = 'java.lang.Exception'");
  }

  @Test public void testCancel2_3() {
    cancel("123", new Exception());
    assert myHandler.get().contains("o = 123'");
  }

  @Test public void testIgnore1_1() {
    ignore("123", new Throwable());
    assert myHandler.get().contains("An instance of String");
  }

  @Test public void testIgnore1_2() {
    ignore("123", new Throwable());
    assert myHandler.get().contains(" was hit by an Throwable exception. This is expected and printed only for the purpose of debugging");
  }

  @Test public void testIgnore1_3() {
    ignore("123", new Throwable());
    assert myHandler.get().contains("x = 'java.lang.Throwable'");
  }

  @Test public void testIgnore1_4() {
    ignore("123", new Throwable());
    assert myHandler.get().contains("o = 123'");
  }

  @Test public void testIgnore2_1() {
    ignore("123".getClass(), new Throwable());
    assert myHandler.get().contains("A static method of Stringwas hit by an Throwable");
  }

  @Test public void testIgnore2_2() {
    ignore("123".getClass(), new Throwable());
    assert myHandler.get()
        .contains("exception. This is expected and printed only for the purpose of debuggingx = 'java.lang.Throwable'o = class java.lang.String'");
  }

  @Test public void testIo_1() {
    io(new Exception(), "howdy");
    assert myHandler.get().contains(" Got an exception of __ : Exception");
  }

  @Test public void testIo_2() {
    io(new Exception(), "howdy");
    assert myHandler.get().contains("(probably I/O exception)");
  }

  @Test public void testIo_3() {
    io(new Exception(), "howdy");
    assert myHandler.get().contains("The exception says: 'java.lang.Exception'");
  }

  @Test public void testIo_4() {
    io(new Exception(), "howdy");
    assert myHandler.get().contains("The associated message is");
  }

  @Test public void testIo_5() {
    io(new Exception(), "howdy");
    assert myHandler.get().contains(">>>'howdy'<<<");
  }

  @Test public void testIo2_1() {
    io(new IOException());
    assert myHandler.get().contains("Got an exception of __ : IOException");
  }

  @Test public void testIo2_2() {
    io(new IOException());
    assert myHandler.get().contains("(probably I/O exception)");
  }

  @Test public void testIo2_3() {
    io(new IOException());
    assert myHandler.get().contains("The exception says: 'java.io.IOException'");
  }

  @Test public void testIo3() {
    io(new IndexOutOfBoundsException());
    azzert.assertNull(myHandler.get());
  }

  @Test public void testLogToFile() {
    logToFile(new Throwable(), "123", "hhoh");
    assert myHandler.get().contains("**");
  }
}
