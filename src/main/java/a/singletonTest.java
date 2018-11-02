package a;

import static org.junit.Assert.*;

import java.lang.reflect.*;
import java.util.*;

import org.junit.*;

public class singletonTest {
  @SuppressWarnings("static-method") @Test public void testList() {
    Integer a = new Integer(3);
    List<Integer> l = singleton.list(a);
    assertEquals(l.size(), 1);
    assertEquals(l.get(0),a);
    l.add(a);
    assertEquals(l.size(), 2);
  }
  @SuppressWarnings("static-method") @Test public void testArray() {
    Object a = null;
    Object[] l = singleton.array(a);
    assertEquals(l.length,1);
    assertTrue(l[0]==null);
  }
  
  
}
