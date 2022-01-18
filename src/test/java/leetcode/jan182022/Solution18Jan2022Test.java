package leetcode.jan182022;

import org.junit.Test;

import java.sql.Time;
import java.util.List;

import static org.junit.Assert.*;

public class Solution18Jan2022Test {

  @Test
  public void testCase_1() {
    List<String> timePoints = List.of("23:59", "00:00");
    int minTimeDifference = new Solution18Jan2022().findMinDifference(timePoints);
    assertEquals(1, minTimeDifference);
  }

  @Test
  public void testCase_2() {
    List<String> timePoints = List.of("00:00", "23:59", "00:00");
    int minTimeDifference = new Solution18Jan2022().findMinDifference(timePoints);
    assertEquals(0, minTimeDifference);
  }
  @Test
  public void testCase_3() {
    List<String> timePoints = List.of("00:00","04:00","22:00");
    int minTimeDifference = new Solution18Jan2022().findMinDifference(timePoints);
    assertEquals(120, minTimeDifference);
  }

  @Test
  public void timeDiffBetween0000and2359is1() {
    TimePoint t1 = new TimePoint(0, 0);
    TimePoint t2 = new TimePoint(23, 59);
    int timeDifference = Solution18Jan2022.timeDifference(t1, t2);
    assertEquals(1, timeDifference);
  }

  @Test
  public void timeDiffBetween1234and1234is0() {
    TimePoint t1 = new TimePoint(12, 34);
    TimePoint t2 = new TimePoint(12, 34);
    int timeDifference = Solution18Jan2022.timeDifference(t1, t2);
    assertEquals(0, timeDifference);
  }

  @Test
  public void timeDiffBetween1200and0000is720() {
    TimePoint t1 = new TimePoint(12, 0);
    TimePoint t2 = new TimePoint(0, 0);
    int timeDifference = Solution18Jan2022.timeDifference(t1, t2);
    assertEquals(720, timeDifference);
  }

  @Test
  public void canParse2359() {
    String timePoint = "23:59";
    TimePoint t = Solution18Jan2022.parseTimePoint(timePoint);
    assertEquals(23, t.getHH());
    assertEquals(59, t.getMM());
  }

  @Test
  public void canParse0000() {
    String timePoint = "00:00";
    TimePoint t = Solution18Jan2022.parseTimePoint(timePoint);
    assertEquals(0, t.getHH());
    assertEquals(0, t.getMM());
  }
}
