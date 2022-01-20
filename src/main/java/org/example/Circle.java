package org.example;

public final class Circle {
  private final Point centre;
  private final double radius;

  public Circle(Point centre, double radius) {
    this.centre = centre;
    this.radius = radius;
  }

  public boolean contains(Point p) {
    double dx = centre.getX() - p.getX();
    double dy = centre.getY() - p.getY();
    double distance = Math.sqrt(dx * dx + dy * dy);
    return distance <= radius;
  }
}
