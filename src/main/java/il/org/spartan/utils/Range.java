package il.org.spartan.utils;

import java.util.*;

/**
 * [[SuppressWarningsSpartan]]
 */
public class Range{
  
  private int from;
  private int to;

  public Range() {
    this.from = Integer.MIN_VALUE;
    this.to = Integer.MAX_VALUE;
  }
  
  public Range from(int ¢) {
    this.from = ¢;
    return this;
  }
  
  public Range to(int ¢) {
    this.to= ¢ - 1;
    return this;
  }
  
  @SuppressWarnings("boxing") public Integer from() {
    return from == Integer.MIN_VALUE ? null : this.from;
  }
  
  public boolean includes(int ¢) {
    return ¢>=this.from && ¢<= this.to;
  }
  
  
  /**
   * [[SuppressWarningsSpartan]]
   */
  public Iterator<Integer> numbers(){
    
    int iteratorTo = this.to;
    int iteratorFrom = this.from;
    
    return new Iterator<Integer>() {
      
      int current = iteratorFrom;
      
      @Override @SuppressWarnings("boxing") public Integer next() {
        return ++current;
      }
      
      @Override public boolean hasNext() {
        return current < iteratorTo;
      }
    };
  }

  
}


