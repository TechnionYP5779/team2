package il.org.spartan.utils;

public class angle {
  private static final double radToDeg = 180 / Math.PI;
  public static final angle pi = new angle(180);
  public static final angle halfPi = new angle(90);
  public double degrees;
  public double radians;

  public angle(final double i) {
    this.degrees = i;
    this.radians = i / radToDeg;
  }

  public static angle degrees(final double i) {
    return new angle(i);
  }

  public static angle radians(final double i) {
    return new angle(i * radToDeg);
  }

  public static angle add(final angle angle2) {
    return new angle(radToDeg * halfPi.radians + angle2.degrees);
  }

  public static angle add(final double i) {
    return new angle(i + radToDeg * halfPi.radians);
  }

  public double degrees() {
    return degrees;
  }

  public static angle of(final int ¢) {
    return new angle(¢);
  }

  public double radians() {
    return radians;
  }
}
