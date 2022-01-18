package algorithms.binarySearch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class BinarySearchTest {

  @Test
  public void binarySearch_50_in_0_to_100() {
    List<Integer> xs = getOneHundredConsecutiveIntegers();
    int y = 50;
    int y_i = BinarySearch.binarySearch(xs, y);
    assertEquals(50, y_i);
  }

  @Test
  public void binarySearch_all_in_0_to_100() {
    List<Integer> xs = getOneHundredConsecutiveIntegers();
    for (int i = 0; i < 100; i++) {
      int index_i = BinarySearch.binarySearch(xs, i);
      assertEquals(i, index_i);
    }
  }

  @Test
  public void cornerCaseOneElementList() {
    List<Integer> xs = List.of(1);
    int y = 1;
    int y_i = BinarySearch.binarySearch(xs, y);
    assertEquals(0, y_i);
  }

  @Test (expected = NoSuchElementException.class)
  public void throwsExceptionIfNotFound() {
    List<Integer> xs = getOneHundredConsecutiveIntegers();
    int y = 200;
    int y_i = BinarySearch.binarySearch(xs, y);
    fail();
  }

  private List<Integer> getOneHundredConsecutiveIntegers() {
    List<Integer> xs = new ArrayList<>(100);
    for (int i = 0; i < 100; i++) {
      xs.add(i);
    }
    return xs;
  }
}
