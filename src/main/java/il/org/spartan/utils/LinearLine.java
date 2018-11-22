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

  public double geta() {
    return a;
  }

  public double getb() {
    return b;
  }
}
