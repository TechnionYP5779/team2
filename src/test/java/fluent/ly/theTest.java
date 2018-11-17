package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method")public class theTest {
  @Ignore @Test public void testIndex1() {
   assert the.index(0, 1,2,3)==1;
  }
  
  @Ignore @Test public void testIndex2() {
    assert the.index(3, 1,2,3)==-1;
   }

  @Test public void testNil() {
    azzert.isNull(the.nil());
  }

  @Ignore @Test public void testNthIntCollectionOfQ() {
    assert the.nth(4,new ArrayList<Integer>(20)).equals(new String("41"));
  }

  @Ignore @Test public void testNthIntInt() {
    assert the.nth(4,2).equals(new String("42"));
  }

  @Test public void testNthStringString() {
    assert the.nth("abc","def").equals(new String(" #abc/def"));
  }

  @Ignore @Test public void testPenultimateOf() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testPrevious() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testTailOfListOfT() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testTailOfString() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testRestTIterableOfT() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testHeadOf() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testCharacterOf() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testIth() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testLastOfListOfT() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testLastOfString() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testBeforeLastOf() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testLastOfIterableOfT() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testOnlyOneOf() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testSecondOf() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testMax() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testMin() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testLastOfTArray() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testLast() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testSqr() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testRestString() {
    fail("Not yet implemented");
  }

  @Ignore @Test public void testTailOfTArray() {
    fail("Not yet implemented");
  }
}
