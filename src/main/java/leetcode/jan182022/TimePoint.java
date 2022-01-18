package leetcode.jan182022;

public class TimePoint implements Comparable<TimePoint> {
  private static final int MINS_IN_A_HOUR = 60;
  private final int hh;
  private final int mm;

  public TimePoint(int hh, int mm) {
    this.hh = hh;
    this.mm = mm;
  }

  public TimePoint minus(TimePoint other) {
    assert this.compareTo(other) >= 0;
    if (other.mm > mm) {
      return new TimePoint(hh - 1 - other.hh, MINS_IN_A_HOUR - other.mm + mm);
    } else {
      return new TimePoint(hh - other.hh, mm - other.mm);
    }
  }

  public TimePoint plus(TimePoint other) {
    int newMM = other.mm + mm;
    return new TimePoint(
        hh + other.hh + newMM / MINS_IN_A_HOUR, newMM % MINS_IN_A_HOUR);
  }

  public int getHH() {
    return hh;
  }

  public int getMM() {
    return mm;
  }

  public int toMinutes(){
    assert this.compareTo(new TimePoint(0,0)) >=0;
    assert this.compareTo(new TimePoint(23,59)) <= 0;
    return getHH() * 60 + getMM();
  }

  @Override
  public int compareTo(TimePoint o) {
    if (hh == o.hh) {
      return Integer.compare(mm, o.mm);
    } else {
      return Integer.compare(hh, o.hh);
    }
  }
}
