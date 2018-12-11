package il.org.parking;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({"static-method","static-access"}) 

public class GeoLocationTest {
  
  @Test(expected=IllegalArgumentException.class) public void ctorTest1() throws Exception {
    forget.unused(new GeoLocation(91.0,0.0));
  }
  @Test(expected=IllegalArgumentException.class) public void ctorTest2() throws Exception {
    forget.unused(new GeoLocation(-91.0,0.0));
  }
  @Test(expected=IllegalArgumentException.class) public void ctorTest3() throws Exception {
    forget.unused(new GeoLocation(0.0,181.0));
  }
  @Test(expected=IllegalArgumentException.class) public void ctorTest4() throws Exception {
    forget.unused(new GeoLocation(0.0,-181.0));
  }
  @Test public void ctorTest5() throws Exception {
    forget.unused(new GeoLocation(52.548742971495,-1.81602098644987));
  }
  @Test public void getLatTest() throws Exception {
    azzert.assertEquals(new GeoLocation("Tel Aviv").getLatitude(),32.08,0.01);
  }
  @Test public void getLonTest() throws Exception {
    azzert.assertEquals(new GeoLocation("Tel Aviv").getLongitude(),34.78,0.01);
  }
  @Test public void getAddressTest1() throws Exception {
    azzert.assertEquals(new GeoLocation("New York city").getAddress(),"NYC, New York, USA");
  }
  @Test public void getAddressTest2() throws Exception {
    azzert.assertEquals(new GeoLocation(52.548742971495,-1.81602098644987).getAddress(),"137, Pilkington Avenue, Sutton Coldfield, Birmingham, West Midlands Combined Authority, West Midlands, England, B72 1LH, UK");
  }
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
  @Test public void calcDistTest6() throws Exception {
    azzert.assertNull(new GeoLocation("תל אביב").calcDist(null));
  }
  @Test public void toStringTest() throws Exception {
    azzert.assertEquals(new GeoLocation("Tel Aviv")+"","32.0804808\t34.7805274");
  }
}
