package fluent.ly;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;
import java.io.*;
import java.util.*;
import org.junit.*;

public class outTest1 {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  @Before public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @After public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  @Test public void outPrint() {
    out.out("Shokolad");
    azzert.that(outContent + "", is("Shokolad"));
  }

  @Test public void outStringBool() {
    out.out("Shokolad", true);
    azzert.that(outContent + "", is("Shokolad = true\n"));
  }

  @Test public void outInt1() {
    out.out("Shokolad", 5);
    azzert.that(outContent + "", is("Shokolad = 5\n"));
  }

  @Test public void outInt2() {
    out.out("Shokolad", -654684);
    azzert.that(outContent + "", is("Shokolad = -654684\n"));
  }

  @Test public void outInt3() {
    out.out("Shokolad", 654684);
    azzert.that(outContent + "", is("Shokolad = 654684\n"));
  }

  @Test public void outCollection1() {
    ArrayList<Integer> al = null;
    out.out("Shokolad", al);
    azzert.that(outContent + "", is("No Shokolad\n"));
  }

  @Test public void outCollection2() {
    out.out("Shokolad", Collections.emptyList());
    azzert.that(outContent + "", is("No Shokolad\n"));
  }

  @Test public void outCollection3() {
    Collection<Object> objC = new ArrayList<>();
    for (int ¢ = 1; ¢ < 5; ++¢)
      objC.add(box(¢));
    out.out("Array", objC);
    azzert.that(outContent + "", is("Total of 4 Array:\n\t 1) 1\n\t 2) 2\n\t 3) 3\n\t 4) 4\n"));
  }

  @Test public void outObjArr0() {
    Object[] objects = null;
    out.out("objArr", objects);
    azzert.that(outContent + "", is("No objArr\n"));
  }

  @Test public void outObjArr1() {
    Object[] objects = new Object[] {};
    out.out("objArr", objects);
    azzert.that(outContent + "", is("No objArr\n"));
  }

  @Test public void outObjArr2() {
    Object[] objects = new Object[] { "word" };
    out.out("objArr", objects);
    azzert.that(outContent + "", is("Only one objArr: word\n"));
  }

  @Test public void outObjArr3() {
    Object[] objects = new Object[] { "word", box(5), box(3.14f) };
    out.out("objArr", objects);
    azzert.that(outContent + "", is("Total of 3 objArr:\n\tword\n\t5\n\t3.14\n"));
  }
}
