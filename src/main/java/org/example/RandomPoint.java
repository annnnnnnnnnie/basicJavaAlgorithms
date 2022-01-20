package org.example;

import java.util.Random;

public final class RandomPoint extends Point {
  private static final Random random = new Random(1);

  public RandomPoint(double minX, double maxX, double minY, double maxY) {
    super(minX + (maxX - minX) * random.nextDouble(), minY + (maxY - minY) * random.nextDouble());
  }

  public static void setSeed(long seed) {
    random.setSeed(seed);
  }
}
