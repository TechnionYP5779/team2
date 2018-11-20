package fluent.ly;

import static fluent.ly.azzert.*;

import java.io.*;
import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method")
/* In all of the test methods we need to redirect to console output (that was
 * created with System.out.print) to a String object, so we can test it */
public class outTest {
  @Test public void testOutString() {
    final String name = "Hello world";
    final ByteArrayOutputStream ba = new ByteArrayOutputStream();
    System.setOut(new PrintStream(ba));
    out.out(name);
    azzert.that(name, is(ba + ""));
  }

  @Test public void testOutStringBoolean() {
    final String name = "Hello world";
    final boolean b = true;
    final ByteArrayOutputStream ba = new ByteArrayOutputStream();
    System.setOut(new PrintStream(ba));
    out.out(name, b);
    azzert.that(name + " = " + b + "\n", is(ba + ""));
  }

  @Test public void testOutStringCollectionObjectsOSNull() {
    final String name = "Amit";
    final ByteArrayOutputStream ba = new ByteArrayOutputStream();
    System.setOut(new PrintStream(ba));
    out.out(name, (ArrayList<String>) null);
    azzert.that("No " + name + "\n", is(ba + ""));
  }

  @Test public void testOutStringCollectionObjectsOSEmpty() {
    final String name = "Amit";
    final ByteArrayOutputStream ba = new ByteArrayOutputStream();
    System.setOut(new PrintStream(ba));
    out.out(name, new ArrayList<>());
    azzert.that("No " + name + "\n", is(ba + ""));
  }

  @Test public void testOutStringCollectionSizeOne() {
    final String name = "Amit";
    final ByteArrayOutputStream ba = new ByteArrayOutputStream();
    System.setOut(new PrintStream(ba));
    final String toAdd = "Added";
    final ArrayList<Object> collection = new ArrayList<>();
    collection.add(toAdd);
    out.out(name, collection);
    azzert.that("Only 1 " + name + ": " + toAdd + "\n", is(ba + ""));
  }

  @Test public void testOutStringCollectionMoreThanSizeOne() {
    final String name = "Amit";
    final ArrayList<Object> collection = new ArrayList<>();
    collection.add("One");
    collection.add("Two");
    collection.add("Three");
    final ByteArrayOutputStream ba = new ByteArrayOutputStream();
    System.setOut(new PrintStream(ba));
    out.out(name, collection);
    azzert.that("Total of 3 Amit:\n\t 1) One\n\t 2) Two\n\t 3) Three\n", is(ba + ""));
  }
}
