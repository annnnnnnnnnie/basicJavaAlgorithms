package leetcode.jan182022;

import java.util.List;
import java.util.stream.Collectors;

// https://leetcode-cn.com/problems/minimum-time-difference/
public class Solution18Jan2022 {
  public int findMinDifference(List<String> timePoints) {
    List<TimePoint> sortedTimePoints =
        timePoints.stream()
            .map(Solution18Jan2022::parseTimePoint)
            .sorted()
            .collect(Collectors.toList());
    int minTimeDiffMinutes = 24 * 60;
    for (int i = 0; i < sortedTimePoints.size(); i++) {
      TimePoint t1 = sortedTimePoints.get(i);
      TimePoint t2 = sortedTimePoints.get((i + 1) % sortedTimePoints.size());
      int timeDiff = timeDifference(t2, t1);
      if (timeDiff < minTimeDiffMinutes) {
        minTimeDiffMinutes = timeDiff;
      }
    }
    return minTimeDiffMinutes;
  }

  public static int timeDifference(TimePoint t1, TimePoint t2) {
    if (t1.compareTo(t2) == 0) {
      return 0;
    } else if (t1.compareTo(t2) < 0) {
      int diff_t2t1 = t2.minus(t1).toMinutes();
      int diff_t1t2 = t1.plus(new TimePoint(24, 0)).minus(t2).toMinutes();
      return Math.min(diff_t1t2, diff_t2t1);
    } else {
      int diff_t1t2 = t1.minus(t2).toMinutes();
      int diff_t2t1 = t2.plus(new TimePoint(24, 0)).minus(t1).toMinutes();
      return Math.min(diff_t1t2, diff_t2t1);
    }
  }

  public static TimePoint parseTimePoint(String t) {
    String[] hhmm = t.split(":");
    int hh = Integer.parseInt(hhmm[0]);
    int mm = Integer.parseInt(hhmm[1]);
    return new TimePoint(hh, mm);
  }
}
