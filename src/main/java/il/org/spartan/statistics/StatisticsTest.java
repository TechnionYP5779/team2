package il.org.spartan.statistics;

import static org.junit.Assert.*;

import org.junit.*;

public class StatisticsTest {
  @Test public void medianTest() {
    double[] a = {1,2,3,4,5};
    assert Statistics.median(a)==3;
    
    double[] b = {1, 1, 1, 1, 1, 1};
    assert Statistics.median(b)==1;
    
    double[] c = {2, 3, 2, 5, 2, 2};
    assert Statistics.median(c)==2;
  }
  
  @Test public void madTest() {    
    double[] a = {1,2,3,4,5};
    assert Statistics.mad(a)==1;
    
    double[] b = {1, 1, 1, 1, 1, 1};
    assert Statistics.mad(b)==0;
    
    double[] c = {2, 3, 2, 5, 2, 2};
    assert Statistics.mad(c)==0;
  }
  
  @Test public void pruneTest() {    
    
    assert true;
    }
}
