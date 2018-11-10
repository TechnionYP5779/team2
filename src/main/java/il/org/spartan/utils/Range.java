package il.org.spartan.utils;


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
  
  public int from() {
    return this.from;
  }
  
  public boolean includes(int ¢) {
    return ¢>=this.from && ¢<= this.to;
  }
}


