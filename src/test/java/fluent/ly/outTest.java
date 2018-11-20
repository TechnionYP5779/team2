package fluent.ly;

import java.io.*;
import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method")
/* In all of the test methods we need to redirect to console output (that was
 * created with System.out.print) to a String object, so we can test it */
public class outTest {
  @Test public void testOutString() {
    String name = "Hello world";
    ByteArrayOutputStream ba = new ByteArrayOutputStream();
    System.setOut(new PrintStream(ba));
    out.out(name);
    azzert.that(name, is(ba + ""));
  }

  @Test public void testOutStringBoolean() {
    String name = "Hello world";
    boolean b = true;
    ByteArrayOutputStream ba = new ByteArrayOutputStream();
    System.setOut(new PrintStream(ba));
    out.out(name, b);
    azzert.that(name + " = " + b + "\n", is(ba + ""));
  }

  @Test public void testOutStringCollectionObjectsOSNull() {
    String name = "Amit";
    ByteArrayOutputStream ba = new ByteArrayOutputStream();
    System.setOut(new PrintStream(ba));
    out.out(name, (ArrayList<String>)null);
    azzert.that("No " + name + "\n", is(ba + ""));
  }

  @Test public void testOutStringCollectionObjectsOSEmpty() {
    String name = "Amit";
    ByteArrayOutputStream ba = new ByteArrayOutputStream();
    System.setOut(new PrintStream(ba));
    out.out(name, new ArrayList<>());
    azzert.that("No " + name + "\n", is(ba + ""));
  }

  @Test public void testOutStringCollectionSizeOne() {
    String name = "Amit";
    ByteArrayOutputStream ba = new ByteArrayOutputStream();
    System.setOut(new PrintStream(ba));
    String toAdd = "Added";
    ArrayList<Object> collection = new ArrayList<>();
    collection.add(toAdd);
    out.out(name, collection);
    azzert.that("Only 1 " + name + ": " + toAdd + "\n", is(ba + ""));
  }

  @Test public void testOutStringCollectionMoreThanSizeOne() {
    String name = "Amit";
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("One");
    collection.add("Two");
    collection.add("Three");
    ByteArrayOutputStream ba = new ByteArrayOutputStream();
    System.setOut(new PrintStream(ba));
    out.out(name, collection);
    azzert.that("Total of 3 Amit:\n\t 1) One\n\t 2) Two\n\t 3) Three\n", is(ba + ""));
  }
}
