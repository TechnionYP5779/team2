package il.org.parking;

import java.io.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "static-method", "static-access" }) public class GeoLocationTest {
  @Test(expected = IllegalArgumentException.class) public void ctorTest1() throws IOException {
    forget.unused(new GeoLocation(91.0, 0.0));
  }

  @Test(expected = IllegalArgumentException.class) public void ctorTest2() throws IOException {
    forget.unused(new GeoLocation(-91.0, 0.0));
  }

  @Test(expected = IllegalArgumentException.class) public void ctorTest3() throws IOException {
    forget.unused(new GeoLocation(0.0, 181.0));
  }

  @Test(expected = IllegalArgumentException.class) public void ctorTest4() throws IOException {
    forget.unused(new GeoLocation(0.0, -181.0));
  }

  @Test public void ctorTest5() throws IOException {
    forget.unused(new GeoLocation(52.548742971495, -1.81602098644987));
  }

  @Test public void getLatTest() throws IOException {
    azzert.assertEquals(32.08, new GeoLocation("Tel Aviv").getLatitude(), 0.01);
  }

  @Test public void getLonTest() throws IOException {
    azzert.assertEquals(34.78, new GeoLocation("Tel Aviv").getLongitude(), 0.01);
  }

  @Test public void getAddressTest1() throws IOException {
    azzert.assertEquals("NYC, New York, USA", new GeoLocation("New York city").getAddress());
  }

  @Test public void getAddressTest2() throws IOException {
    azzert.assertEquals("137, Pilkington Avenue, Sutton Coldfield, Birmingham, West Midlands Combined Authority, West Midlands, England, B72 1LH, UK",
        new GeoLocation(52.548742971495, -1.81602098644987).getAddress());
  }

  @Test public void calcDistTest1() throws IOException {
    azzert.assertEquals(84.63,new GeoLocation("תל אביב").calcDist(new GeoLocation("חיפה")).doubleValue(),  0.01);
  }

  @Test public void calcDistTest2() throws IOException {
    azzert.assertEquals(84.63,new GeoLocation("Tel Aviv").calcDist(new GeoLocation("Haifa")).doubleValue(),  0.01);
  }

  @Test public void calcDistTest3() throws IOException {
    azzert.assertEquals( 0,new GeoLocation("חיפה").calcDist(new GeoLocation("חיפה")).doubleValue(), 0.01);
  }

  @Test public void calcDistTest4() throws IOException {
    azzert.assertEquals( 0,new GeoLocation("Haifa").calcDist(new GeoLocation("Haifa")).doubleValue(), 0.01);
  }

  @Test public void calcDistTest5() throws IOException {
    azzert.assertEquals(6.35,new GeoLocation("הטכניון חיפה").calcDist(new GeoLocation("חיפה חוף הכרמל")).doubleValue(),  0.01);
  }

  @Test public void calcDistTest6() throws IOException {
    azzert.assertNull(new GeoLocation("תל אביב").calcDist(null));
  }

  @Test public void toStringTest() throws IOException {
    azzert.assertEquals("32.0804808\t34.7805274",new GeoLocation("Tel Aviv") + "");
  }
}
