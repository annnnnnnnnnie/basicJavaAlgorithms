package org.example;

public class Point {
  protected final double x;
  protected final double y;

  protected Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }
}
