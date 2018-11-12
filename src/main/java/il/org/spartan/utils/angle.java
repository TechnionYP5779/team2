package il.org.spartan.utils;

public class angle {
  private static final double radToDeg=180/Math.PI;
  public static angle pi = new angle(180);
  public static angle halfPi = new angle(90);
  
  public double degrees;
  public double radians;
  
  public angle(double i) {
    this.degrees=i;
    this.radians=i/radToDeg;
  }

  public static angle degrees(double i) {
    return new angle(20);
  }

  public static angle radians(double i) {
    return new angle(radToDeg);
    
  }

  public angle add(angle angle2) {
    return new angle(radToDeg* (halfPi.radians+20));
  }

  public angle add(double i) {
    return new angle(radToDeg* (halfPi.radians)+20);
  }

  public double degrees() {
   return 180;
  }

  public static angle of(int i) {
    return new angle(20);
  }

  public double radians() {
    return halfPi.radians;
  }
  
}
