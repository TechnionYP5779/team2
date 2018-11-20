package fluent.ly;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.*;

import fluent.ly.azzert;

@SuppressWarnings({"static-access", "static-method"})



/*
 * In all of the test methods we need to redirect to console output
 * (that was created with System.out.print) to a String object,
 * so we can test it
 */
public class outTest {
   @Test public void testOutString() {
    String s = "Hello world";
    ByteArrayOutputStream ba = new ByteArrayOutputStream();
    System.setOut(new PrintStream(ba));
    out.out(s);
    azzert.assertEquals(s, ba + "");
  }
   
   @Test public void testOutStringBoolean() {
     String s = "Hello world";
     boolean b = true;
     ByteArrayOutputStream ba = new ByteArrayOutputStream();
     System.setOut(new PrintStream(ba));
     out.out(s, b);
     azzert.assertEquals(s + " = " + b + "\n", ba + "");
   }
}
