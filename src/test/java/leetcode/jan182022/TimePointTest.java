package leetcode.jan182022;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimePointTest {

  @Test
  public void _0000lessthan2359() {
    TimePoint t1 = new TimePoint(0, 0);
    TimePoint t2 = new TimePoint(23, 59);
    assertTrue(t1.compareTo(t2) < 0);
    assertTrue(t2.compareTo(t1) > 0);
  }

  @Test
  public void _1325lessthan1326() {
    TimePoint t1 = new TimePoint(13, 25);
    TimePoint t2 = new TimePoint(13, 26);
    assertTrue(t1.compareTo(t2) < 0);
    assertTrue(t2.compareTo(t1) > 0);
  }

  @Test
  public void _1200equalto1200() {
    TimePoint t1 = new TimePoint(12, 0);
    TimePoint t2 = new TimePoint(12, 0);
    assertEquals(0, t1.compareTo(t2));
    assertEquals(0, t2.compareTo(t1));
  }

  @Test
  public void _1200plus1200is2400() {
    TimePoint t1 = new TimePoint(12, 0);
    TimePoint t2 = new TimePoint(12, 0);
    TimePoint sumT = t1.plus(t2);
    assertEquals(24, sumT.getHH());
    assertEquals(0, sumT.getMM());
  }

  @Test
  public void _1220plus1240is2500() {
    TimePoint t1 = new TimePoint(12, 20);
    TimePoint t2 = new TimePoint(12, 40);
    TimePoint sumT = t1.plus(t2);
    assertEquals(25, sumT.getHH());
    assertEquals(0, sumT.getMM());
  }

  @Test
  public void _1220minus1200is0020() {
    TimePoint t1 = new TimePoint(12, 20);
    TimePoint t2 = new TimePoint(12, 0);
    TimePoint sumT = t1.minus(t2);
    assertEquals(0, sumT.getHH());
    assertEquals(20, sumT.getMM());
  }

  @Test
  public void _1320minus1240is0040() {
    TimePoint t1 = new TimePoint(13, 20);
    TimePoint t2 = new TimePoint(12, 40);
    TimePoint sumT = t1.minus(t2);
    assertEquals(0, sumT.getHH());
    assertEquals(40, sumT.getMM());
  }

  @Test
  public void _1220minus1220is0000() {
    TimePoint t1 = new TimePoint(12, 20);
    TimePoint t2 = new TimePoint(12, 20);
    TimePoint sumT = t1.minus(t2);
    assertEquals(0, sumT.getHH());
    assertEquals(0, sumT.getMM());
  }

  @Test
  public void _2520minus2340is0140() {
    TimePoint t1 = new TimePoint(25, 20);
    TimePoint t2 = new TimePoint(23, 40);
    TimePoint sumT = t1.minus(t2);
    assertEquals(1, sumT.getHH());
    assertEquals(40, sumT.getMM());
  }

  @Test
  public void _0159is161mins() {
    TimePoint t = new TimePoint(1, 59);
    assertEquals(60 + 59, t.toMinutes());
  }
}
