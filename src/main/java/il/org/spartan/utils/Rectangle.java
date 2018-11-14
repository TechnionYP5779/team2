package il.org.spartan.utils;

public class Rectangle {
  double width, height;

  public Rectangle(final double x1, final double y1, final double x2, final double y2) throws IllegalArgumentException {
    if (x1 == x2 || y1 == y2)
      throw new IllegalArgumentException();
    width = Math.abs(x1 - x2);
    height = Math.abs(y1 - y2);
  }

  public double getPerimeter() {
    return 2 * (width + height);
  }

  public double getArea() {
    return width * height;
  }

  public double getHeight() {
    return height;
  }

  public double getWidth() {
    return width;
  }

  public void expand(final int ¢) {
    height *= Math.sqrt(¢);
    width *= Math.sqrt(¢);
  }

  public void rotate() {
    final double tmp = height;
    height = width;
    width = tmp;
  }
}
