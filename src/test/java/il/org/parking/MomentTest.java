package il.org.parking;

import static org.junit.Assert.*;

import java.time.*;

import org.junit.*;

@SuppressWarnings("static-method") public class MomentTest {
  @Test public void testEmptyCtorDayOfMonth() {
    Moment m = new Moment();
    LocalDateTime now = LocalDateTime.now();
    assertEquals(now.getDayOfMonth(), m.getDayOfMonth());
  }

  @Test public void testEmptyCtorMonth() {
    Moment m = new Moment();
    LocalDateTime now = LocalDateTime.now();
    assertEquals(now.getMonth(), m.getMonth());
  }

  @Test public void testEmptyCtorYear() {
    Moment m = new Moment();
    LocalDateTime now = LocalDateTime.now();
    assertEquals(now.getYear(), m.getYear());
  }

  @Test public void testEmptyCtorHour() {
    Moment m = new Moment();
    LocalDateTime now = LocalDateTime.now();
    assertEquals(now.getHour(), m.getHour());
  }

  @Test public void testEmptyCtorMinute() {
    Moment m = new Moment();
    LocalDateTime now = LocalDateTime.now();
    assertEquals(now.getMinute(), m.getMinute());
  }

  @Test public void test2ParamsCtor() {
    Moment m = new Moment(LocalDate.of(1996, Month.DECEMBER, 1), LocalTime.of(15, 30));
    assertEquals(1996, m.getYear());
  }

  @Test public void test5ParamsCtor() {
    Moment m = new Moment(1997, Month.MAY, 17, 18, 00);
    assertEquals(18, m.getHour());
  }

  @Test public void testGetDate() {
    Moment m = new Moment(LocalDate.of(1996, Month.DECEMBER, 1), LocalTime.of(15, 30));
    assertEquals(LocalDateTime.of(LocalDate.of(1996, Month.DECEMBER, 1), LocalTime.of(15, 30)), m.getDate());
  }
}
