package il.org.spartan.utils;

public class Rectangle {
  double width,height;
  public Rectangle(double x1,double y1,double x2,double y2) throws Exception {
    if(x1==x2 || y1==y2) throw new Exception();
    width = Math.abs(x1-x2);
    height = Math.abs(y1-y2);
  }
  public double getPerimeter() {
    return 2*(width+height);
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
  public void expand(int ¢) {
    height *= Math.sqrt(¢);
    width *= Math.sqrt(¢);
  }
  public void rotate() {
    double tmp = height;
    height=width;
    width = tmp;
  }
}
