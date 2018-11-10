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
  
  public Range to(int ¢) {
    this.to= ¢ - 1;
    return this;
  }
  
  @SuppressWarnings("boxing") public Integer from() {
    if(from == Integer.MIN_VALUE) {
      return null;
    }
    return this.from;
  }
  
  public boolean includes(int ¢) {
    return ¢>=this.from && ¢<= this.to;
  }

  
}


