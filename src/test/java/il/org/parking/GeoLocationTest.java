package il.org.parking;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({"static-method","static-access"}) 
public class GeoLocationTest {
  @Test public void calcDistTest1() throws Exception {
    azzert.assertEquals(new GeoLocation("תל אביב").calcDist(new GeoLocation("חיפה")).doubleValue(),84.63,0.01);
  }
  @Test public void calcDistTest2() throws Exception {
    azzert.assertEquals(new GeoLocation("Tel Aviv").calcDist(new GeoLocation("Haifa")).doubleValue(),84.63,0.01);
  }
  @Test public void calcDistTest3() throws Exception {
    azzert.assertEquals(new GeoLocation("חיפה").calcDist(new GeoLocation("חיפה")).doubleValue(),0,0.01);
  }
  @Test public void calcDistTest4() throws Exception {
    azzert.assertEquals(new GeoLocation("Haifa").calcDist(new GeoLocation("Haifa")).doubleValue(),0,0.01);
  }
  @Test public void calcDistTest5() throws Exception {
    azzert.assertEquals(new GeoLocation("הטכניון חיפה").calcDist(new GeoLocation("חיפה חוף הכרמל")).doubleValue(),6.35,0.01);
  }
}
