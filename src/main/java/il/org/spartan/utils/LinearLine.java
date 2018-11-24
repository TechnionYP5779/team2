package il.org.spartan.utils;

public class LinearLine {
  // A linear line from the form Y=aX+b
  double a;
  double b;

  public LinearLine(final double alpha, final double beta) {
    a = alpha;
    b = beta;
  }

  public double yOf(final double x) {
    return b + a * x;
  }

  public double getA() {
    return a;
  }

  public double getB() {
    return b;
  }
}
