package org.example;

/** Hello world! */
public class App {
  public static void main(String[] args) {
    System.out.println("Hello World!");
    double pi = estimatePI(100000000, 42, 0.5);
    System.out.println("pi is " + pi);
  }

  public static double estimatePI(int n, long seed, double radius) {
    RandomPoint.setSeed(seed);
    Point centre = new Point(radius, radius);
    Circle c = new Circle(centre, radius);
    long hit = 0;
    for (int i = 0; i < n; i++) {
      RandomPoint rp = new RandomPoint(0, 2 * radius, 0, 2 * radius);
      if (c.contains(rp)) {
        hit++;
      }
    }

    return 4 * (hit / (double) n);
  }
}
