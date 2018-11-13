package fluent.ly;

import static fluent.ly.azzert.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.idiomatic;
import fluent.ly.idiomatic.*;
import java.io.IOException;
import java.util.function.*;

public class BigIntegerTest {
  @Test
  public void testCreateFromString() {
    BigInteger bi = new BigInteger("123");
    azzert.assertNotEquals(bi, null);
  }
  
  @Test
  public void testsEquals() {
    azzert.assertEquals(new BigInteger("123"),new BigInteger("123"));
  }
  
  @Test
  public void testNotEquals() {
    azzert.assertNotEquals(new BigInteger("123"),new BigInteger("100"));
  }
  
  @Test
  public void testAdd() {
    BigInteger bi = new BigInteger("123");
    
    azzert.assertEquals(bi.add(new BigInteger("5")),new BigInteger("128"));
  }
  
  @Test
  public void testAdd2() {
    BigInteger bi = new BigInteger("312345");
    
    azzert.assertEquals(bi.add(new BigInteger("90000")),new BigInteger("402345"));
  }
  
  @Test
  public void testNegativeAdd() {
    BigInteger bi1 = new BigInteger("100");
    BigInteger bi2 = new BigInteger("-10");
    
    azzert.assertEquals(bi1.add(bi2),new BigInteger("90"));
  }
  
  @Test
  public void testNegativeAdd2() {
    BigInteger bi1 = new BigInteger("-1234");
    BigInteger bi2 = new BigInteger("1234");
    
    azzert.assertEquals(bi1.add(bi2),new BigInteger("0"));
  }
  
  @Test
  public void testNegativeAdd3() {
    BigInteger bi1 = new BigInteger("-1234");
    BigInteger bi2 = new BigInteger("1");
    
    azzert.assertEquals(bi1.add(bi2),new BigInteger("-1233"));
  }
  
  @Test
  public void testAddBigNumber() {
    BigInteger bi1 = new BigInteger("1234567890123456789012345678901234567890");
    BigInteger bi2 = new BigInteger("5");
    
    azzert.assertEquals(bi1.add(bi2),new BigInteger("1234567890123456789012345678901234567895"));
  }
  
  @Test
  public void testAddBigNumber2() {
    BigInteger bi1 = new BigInteger("15");
    BigInteger bi2 = new BigInteger("1234567890123456789012345678901234567890");
    
    azzert.assertEquals(bi1.add(bi2),new BigInteger("1234567890123456789012345678901234567905"));
  }
  
  @Test
  public void testAddBigNumber3() {
    BigInteger bi1 = new BigInteger("9000000000000000000000000000000000000000");
    BigInteger bi2 = new BigInteger("1234567890123456789012345678901234567890");
    
    BigInteger res = new BigInteger("10234567890123456789012345678901234567890");
    
    azzert.assertEquals(bi1.add(bi2),res);
  }
  
  
  
  
}
