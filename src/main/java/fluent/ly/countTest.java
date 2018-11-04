package fluent.ly;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.*;

public class countTest {
  private List<Integer> l;
  
  @Before
  public void setUp() {
    l = new ArrayList<>();
  }
  
  
  @Test public void testCreateEmpty() {
    assert(count.of(l)==0);
  }
  
  @Test public void testAdd() {
    l.add(3);
    l.add(2);
    l.add(111);
    assert(count.of(l)==3);
  }
  
  
  @Test public void testAddRemove() {
    l.add(5);
    l.remove(0);
    assert(count.of(l)==0);
  }
}
