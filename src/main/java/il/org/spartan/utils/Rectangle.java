package il.org.spartan.utils;

public class Rectangle {
  double x1, y1, x2, y2;

  public Rectangle(final double x1, final double y1, final double x2, final double y2) throws IllegalArgumentException {
    if (x1 == x2 || y1 == y2)
      throw new IllegalArgumentException();
    this.x1 = x1 > x2 ? x2 : x1;
    this.y1 = x1 > x2 ? y2 : y1;
    this.x2 = x1 > x2 ? x1 : x2;
    this.y2 = x1 > x2 ? y1 : y2;
  }

  public double getPerimeter() {
    return 2 * (Math.abs(x1 - x2) + Math.abs(y1 - y2));
  }

  public double getArea() {
    return Math.abs(x1 - x2) * Math.abs(y1 - y2);
  }

  public double getHeight() {
    return Math.abs(y1 - y2);
  }

  public double getWidth() {
    return Math.abs(x1 - x2);
  }

  public void expand(final int ¢) {
    final double centerX = (x1 + x2) / 2, centerY = (y1 + y2) / 2;
    final double width = Math.abs(x1 - x2), height = Math.abs(y1 - y2);
    x1 = (centerX - width / 2) * Math.sqrt(¢);
    x2 = (centerX + width / 2) * Math.sqrt(¢);
    y1 = (centerY - height / 2) * Math.sqrt(¢);
    y2 = (centerY + height / 2) * Math.sqrt(¢);
  }

  public void rotate(final double angle) {
    final double centerX = (x1 + x2) / 2, centerY = (y1 + y2) / 2;
    double tempX = x1 - centerX, tempY = y1 - centerY, rotatedX = tempX * Math.cos(angle) - tempY * Math.sin(angle),
        rotatedY = tempX * Math.sin(angle) + tempY * Math.cos(angle);
    x1 = centerX + rotatedX;
    y1 = centerY + rotatedY;
    tempX = x2 - centerX;
    tempY = y2 - centerY;
    rotatedX = tempX * Math.cos(angle) - tempY * Math.sin(angle);
    rotatedY = tempX * Math.sin(angle) + tempY * Math.cos(angle);
    x2 = centerX + rotatedX;
    y2 = centerY + rotatedY;
  }
}
