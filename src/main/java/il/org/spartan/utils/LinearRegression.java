package il.org.spartan.utils;

import static il.org.spartan.Utils.*;

import static fluent.ly.unbox.*;

import java.util.*;

public class LinearRegression {
  List<Double> xVals;
  List<Double> yVals;

  public LinearRegression(final List<Double> xs, final List<Double> ys) {
    xVals = new ArrayList<>(xs);
    yVals = new ArrayList<>(ys);
  }

  // calcs the sum of all the x values
  public double Sx() {
    double $ = 0;
    for (int ¢ = 0; ¢ < xVals.size(); ++¢)
      $ += unbox(cantBeNull(xVals.get(¢)));
    return $;
  }

  // calcs the sum of all the y values
  public double Sy() {
    double $ = 0;
    for (int ¢ = 0; ¢ < yVals.size(); ++¢)
      $ += unbox(cantBeNull(yVals.get(¢)));
    return $;
  }

  // calcs the sum of all the squares of the x values
  public double Sxx() {
    double $ = 0;
    for (int ¢ = 0; ¢ < xVals.size(); ++¢)
      $ += unbox(cantBeNull(xVals.get(¢))) * unbox(cantBeNull(xVals.get(¢)));
    return $;
  }

  // calcs the sum of all the squares of the y values
  public double Syy() {
    double $ = 0;
    for (int ¢ = 0; ¢ < yVals.size(); ++¢)
      $ += unbox(cantBeNull(yVals.get(¢))) * unbox(cantBeNull(yVals.get(¢)));
    return $;
  }

  // calcs the sum of all the x*y values
  public double Sxy() {
    double $ = 0;
    for (int ¢ = 0; ¢ < yVals.size(); ++¢)
      $ += unbox(cantBeNull(xVals.get(¢))) * unbox(cantBeNull(yVals.get(¢)));
    return $;
  }

  // calculate the linear regression
  public LinearLine calcLinearRegression() {
    double $;
    final double n = xVals.size();
    final double a = (n * Sxy() - Sx() * Sy()) / (n * Sxx() - Sx() * Sx());
    $ = 1 / n * Sy() - a / n * Sx();
    return new LinearLine(a, $);
  }
}
