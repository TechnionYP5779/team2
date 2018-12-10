package il.org.parking;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({"static-method","static-access"}) 
public class GeoLocationTest {
  @Test public void calcDistTest1() throws Exception {
      azzert.assertEquals(new GeoLocation("תל אביב").calcDist(new GeoLocation("חיפה")).doubleValue(),107.468,0.01);
  }
  @Test public void calcDistTest2() throws Exception {
    azzert.assertEquals(new GeoLocation("Tel Aviv").calcDist(new GeoLocation("Haifa")).doubleValue(),107.468,0.01);
  }
  @Test public void calcDistTest3() throws Exception {
    azzert.assertEquals(new GeoLocation("חיפה").calcDist(new GeoLocation("חיפה")).doubleValue(),0,0.01);
  }
  @Test public void calcDistTest4() throws Exception {
    azzert.assertEquals(new GeoLocation("Haifa").calcDist(new GeoLocation("Haifa")).doubleValue(),0,0.01);
  }
}
