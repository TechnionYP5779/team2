package il.org.spartan.utils;


public class Range{
  
  private int from;
  private int to;

  public Range() {
    this.from = Integer.MIN_VALUE;
    this.to = Integer.MAX_VALUE;
  }
  
  public void from(int ¢) {
    this.from = ¢;
  }

  public boolean includes(int ¢) {
    return ¢>=this.from && ¢<= this.to;
  }
}


