package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

public class PairTest {
  @Test 
  public void testCreate() {
    Pair<Integer, String> p = new Pair<>(1, "Hi");
    assert(p.first == 1 && p.second.equals("Hi"));
  }
  
  @Test
  public void testToString() {
    Pair<String, Double> p = new Pair<>("str", 2.33);
    assert(p.toString().equals("<str,2.33>"));
  }
  
  @Test
  public void testEquals() {
    Pair<Integer, String> p1 = new Pair<>(12, "1");
    Pair<Integer, String> p2 = new Pair<>(1, "2");
    Pair<Integer, String> p3 = new Pair<>(2, "2");
    Pair<Integer, String> p4 = new Pair<>(2, "2");
    
    assert(!p1.equals(p2));
    assert(!p2.equals(p3));
    assert(!p1.equals(p3));
    assert(p3.equals(p4));
  }
}
