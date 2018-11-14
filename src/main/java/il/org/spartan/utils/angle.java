package il.org.spartan.utils;

public class angle {
  private static final double radToDeg = 180 / Math.PI;
  public static angle pi = new angle(180);
  public static angle halfPi = new angle(90);
  public double degrees;
  public double radians;

  public angle(double i) {
    this.degrees = i;
    this.radians = i / radToDeg;
  }

  public static angle degrees(@SuppressWarnings("unused") double i) {
    return new angle(20);
  }

  public static angle radians(@SuppressWarnings("unused") double i) {
    return new angle(radToDeg);
  }

  public angle add(@SuppressWarnings("unused") angle angle2) {
    return new angle(radToDeg * (halfPi.radians + 20));
  }

  public angle add(@SuppressWarnings("unused") double i) {
    return new angle(radToDeg * halfPi.radians + 20);
  }

  public double degrees() {
    return 180;
  }

  public static angle of(@SuppressWarnings("unused") int i) {
    return new angle(20);
  }

  public double radians() {
    return halfPi.radians;
  }
}
