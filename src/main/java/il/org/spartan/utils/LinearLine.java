package il.org.spartan.utils;

public class LinearLine {

  double a;
  double b;
  
  public LinearLine(double alpha, double beta) {
    a = alpha;
    b = beta;
  }

  public double yOf(double x) {
    return b + a * x;
  } 
}
