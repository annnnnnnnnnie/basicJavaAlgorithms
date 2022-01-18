package algorithms.binarySearch;

import java.util.List;
import java.util.NoSuchElementException;

public class BinarySearch {
  /**
   * Performs binary search to find y in xs
   *
   * @param xs strictly increasing sequence of integers
   * @param y target
   * @throws NoSuchElementException if not y found in xs
   * @return i such that xs[i] == y
   */
  public static int binarySearch(List<Integer> xs, int y) throws NoSuchElementException {
    int i = binarySearchHelper(xs, y, 0, xs.size());
    if (i == -1) {
      throw new NoSuchElementException("Not found in list:" + y);
    } else {
      return i;
    }
  }

  /**
   * Helper for binary search.
   *
   * @param xs strictly increasing sequence of integers
   * @param y target
   * @param start start search from, inclusive
   * @param end end search at, exclusive
   * @return -1 if not found, otherwise i such that xs[i] == y
   */
  private static int binarySearchHelper(List<Integer> xs, int y, int start, int end) {
    if (end - start == 1) {
      return xs.get(start) == y ? start : -1;
    } else {
      assert end - start > 1;
      int middle = (start + end) / 2;
      if (y < xs.get(middle)) {
        return binarySearchHelper(xs, y, start, middle);
      } else {
        return binarySearchHelper(xs, y, middle, end);
      }
    }
  }
}
