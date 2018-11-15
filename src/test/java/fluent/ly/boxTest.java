package fluent.ly;

import org.junit.*;
import static fluent.ly.box.*;

@SuppressWarnings({ "static-method", "static-access" }) public class boxTest {
  @Test public void booleanBoxingTest() {
    azzert.assertEquals(Boolean.TRUE, box(true));
    azzert.assertEquals(Boolean.FALSE, box(false));
  }

  @Test public void booleanEmptyArrayBoxingTest() {
    azzert.assertArrayEquals(new Boolean[0], box(new boolean[0]));
  }

  @Test public void booleanArrayBoxingTest() {
    final boolean[] boolArray = { true, true, false, false, true, false };
    final Boolean[] expected = new Boolean[boolArray.length];
    for (int ¢ = 0; ¢ < boolArray.length; ++¢)
      expected[¢] = Boolean.valueOf(boolArray[¢]);
    azzert.assertArrayEquals(expected, box(boolArray));
  }

  @Test public void byteBoxingTest() {
    for (byte i = Byte.MIN_VALUE; i < Byte.MAX_VALUE; ++i)
      azzert.assertEquals(Byte.valueOf(i), box(i));
    azzert.assertEquals(Byte.valueOf(Byte.MAX_VALUE), box(Byte.MAX_VALUE));
  }

  @Test public void byteEmptyArrayBoxingTest() {
    azzert.assertArrayEquals(new Byte[0], box(new byte[0]));
  }

  @Test public void byteArrayBoxingTest() {
    final byte[] byteArray = { 1, 2, 3, 4, 5, 6, 10, Byte.MAX_VALUE, Byte.MIN_VALUE, -127, 0, 127, 50, 100 };
    final Byte[] expected = new Byte[byteArray.length];
    for (int ¢ = 0; ¢ < byteArray.length; ++¢)
      expected[¢] = Byte.valueOf(byteArray[¢]);
    azzert.assertArrayEquals(expected, box(byteArray));
  }

  @Test public void charBoxingTest() {
    for (char i = Character.MIN_VALUE; i < Character.MAX_VALUE; ++i)
      azzert.assertEquals(Character.valueOf(i), box(i));
    azzert.assertEquals(Character.valueOf(Character.MAX_VALUE), box(Character.MAX_VALUE));
  }

  @Test public void charEmptyArrayBoxingTest() {
    azzert.assertArrayEquals(new Character[0], box(new char[0]));
  }

  @Test public void charArrayBoxingTest() {
    final char[] charArray = { 1, 2, 3, 4, 5, 6, 10, 127, 128, 127, 0, 127, 50, 100, 65535, 55555 };
    final Character[] expected = new Character[charArray.length];
    for (int ¢ = 0; ¢ < charArray.length; ++¢)
      expected[¢] = Character.valueOf(charArray[¢]);
    azzert.assertArrayEquals(expected, box(charArray));
  }

  @Test public void doubleBoxingTest() {
    azzert.assertEquals(Double.valueOf(Double.MAX_VALUE), box(Double.MAX_VALUE));
    azzert.assertEquals(Double.valueOf(Double.MIN_VALUE), box(Double.MIN_VALUE));
    azzert.assertEquals(Double.valueOf(Double.MIN_NORMAL), box(Double.MIN_NORMAL));
    azzert.assertEquals(Double.valueOf(0.0), box(0.0));
    azzert.assertEquals(Double.valueOf(Math.E), box(Math.E));
    azzert.assertEquals(Double.valueOf(Math.PI), box(Math.PI));
    azzert.assertEquals(Double.valueOf(-Math.sqrt(2)), box(-Math.sqrt(2)));
    azzert.assertEquals(Double.valueOf(238.0), box(238.0));
  }

  @Test public void doubleEmptyArrayBoxingTest() {
    azzert.assertArrayEquals(new Double[0], box(new double[0]));
  }

  @Test public void doubleArrayBoxingTest() {
    final double[] doubleArray = { Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL, Math.E, -Math.PI, 0.0, 55555.0, Math.sqrt(2) };
    final Double[] expected = new Double[doubleArray.length];
    for (int ¢ = 0; ¢ < doubleArray.length; ++¢)
      expected[¢] = Double.valueOf(doubleArray[¢]);
    azzert.assertArrayEquals(expected, box(doubleArray));
  }

  @Test public void floatBoxingTest() {
    azzert.assertEquals(Float.valueOf(Float.MAX_VALUE), box(Float.MAX_VALUE));
    azzert.assertEquals(Float.valueOf(Float.MIN_VALUE), box(Float.MIN_VALUE));
    azzert.assertEquals(Float.valueOf(Float.MIN_NORMAL), box(Float.MIN_NORMAL));
    azzert.assertEquals(Float.valueOf((float) 0.0), box((float) 0.0));
    azzert.assertEquals(Float.valueOf((float) Math.E), box((float) Math.E));
    azzert.assertEquals(Float.valueOf((float) Math.PI), box((float) Math.PI));
    azzert.assertEquals(Float.valueOf((float) -Math.sqrt(2)), box((float) -Math.sqrt(2)));
    azzert.assertEquals(Float.valueOf((float) 238.0), box((float) 238.0));
  }

  @Test public void floatEmptyArrayBoxingTest() {
    azzert.assertArrayEquals(new Float[0], box(new float[0]));
  }

  @Test public void floatArrayBoxingTest() {
    final float[] floatArray = { Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_NORMAL, (float) Math.E, (float) -Math.PI, (float) 0.0,
        (float) Math.sqrt(2) };
    final Float[] expected = new Float[floatArray.length];
    for (int ¢ = 0; ¢ < floatArray.length; ++¢)
      expected[¢] = Float.valueOf(floatArray[¢]);
    azzert.assertArrayEquals(expected, box(floatArray));
  }

  @Test public void intBoxingTest() {
    azzert.assertEquals(Integer.valueOf(Integer.MAX_VALUE), box(Integer.MAX_VALUE));
    azzert.assertEquals(Integer.valueOf(Integer.MIN_VALUE), box(Integer.MIN_VALUE));
    azzert.assertEquals(Integer.valueOf(0), box(0));
    azzert.assertEquals(Integer.valueOf(500), box(500));
    azzert.assertEquals(Integer.valueOf(-3), box(-3));
  }

  @Test public void intEmptyArrayBoxingTest() {
    azzert.assertArrayEquals(new Integer[0], box(new int[0]));
  }

  @Test public void intArrayBoxingTest() {
    final int[] intArray = { 10, Integer.MAX_VALUE, Integer.MIN_VALUE, -127, 0, 58745, -124856, 100 };
    final Integer[] expected = new Integer[intArray.length];
    for (int ¢ = 0; ¢ < intArray.length; ++¢)
      expected[¢] = Integer.valueOf(intArray[¢]);
    azzert.assertArrayEquals(expected, box(intArray));
  }

  @Test public void longBoxingTest() {
    azzert.assertEquals(Long.valueOf(Long.MAX_VALUE), box(Long.MAX_VALUE));
    azzert.assertEquals(Long.valueOf(Long.MIN_VALUE), box(Long.MIN_VALUE));
    azzert.assertEquals(Long.valueOf(0L), box(0L));
    azzert.assertEquals(Long.valueOf(500L), box(500L));
    azzert.assertEquals(Long.valueOf(-3L), box(-3L));
  }

  @Test public void longEmptyArrayBoxingTest() {
    azzert.assertArrayEquals(new Long[0], box(new long[0]));
  }

  @Test public void longArrayBoxingTest() {
    final long[] longArray = { 10L, Long.MAX_VALUE, Long.MIN_VALUE, 0L, 58745L, -124856L, 100L };
    final Long[] expected = new Long[longArray.length];
    for (int ¢ = 0; ¢ < longArray.length; ++¢)
      expected[¢] = Long.valueOf(longArray[¢]);
    azzert.assertArrayEquals(expected, box(longArray));
  }

  @Test public void shortBoxingTest() {
    azzert.assertEquals(Short.valueOf(Short.MAX_VALUE), box(Short.MAX_VALUE));
    azzert.assertEquals(Short.valueOf(Short.MIN_VALUE), box(Short.MIN_VALUE));
    azzert.assertEquals(Short.valueOf((short) 0), box((short) 0));
    azzert.assertEquals(Short.valueOf((short) 500), box((short) 500));
    azzert.assertEquals(Short.valueOf((short) -3), box((short) -3));
  }

  @Test public void shortEmptyArrayBoxingTest() {
    azzert.assertArrayEquals(new Short[0], box(new short[0]));
  }

  @Test public void shortArrayBoxingTest() {
    final short[] shortArray = { 10, Short.MAX_VALUE, Short.MIN_VALUE, -127, 0, 100 };
    final Short[] expected = new Short[shortArray.length];
    for (int ¢ = 0; ¢ < shortArray.length; ++¢)
      expected[¢] = Short.valueOf(shortArray[¢]);
    azzert.assertArrayEquals(expected, box(shortArray));
  }

  @Test public void booleanItTest() {
    azzert.assertEquals(Boolean.TRUE, box.it(true));
    azzert.assertEquals(Boolean.FALSE, box.it(false));
  }

  @Test public void booleanEmptyArrayItTest() {
    azzert.assertArrayEquals(new Boolean[0], box.it(new boolean[0]));
  }

  @Test public void booleanArrayItTest() {
    final boolean[] boolArray = { true, true, false, false, true, false };
    final Boolean[] expected = new Boolean[boolArray.length];
    for (int ¢ = 0; ¢ < boolArray.length; ++¢)
      expected[¢] = Boolean.valueOf(boolArray[¢]);
    azzert.assertArrayEquals(expected, box.it(boolArray));
  }

  @Test public void byteItTest() {
    for (byte i = Byte.MIN_VALUE; i < Byte.MAX_VALUE; ++i)
      azzert.assertEquals(Byte.valueOf(i), box.it(i));
    azzert.assertEquals(Byte.valueOf(Byte.MAX_VALUE), box.it(Byte.MAX_VALUE));
  }

  @Test public void byteEmptyArrayItTest() {
    azzert.assertArrayEquals(new Byte[0], box.it(new byte[0]));
  }

  @Test public void byteArrayItTest() {
    final byte[] byteArray = { 1, 2, 3, 4, 5, 6, 10, Byte.MAX_VALUE, Byte.MIN_VALUE, -127, 0, 127, 50, 100 };
    final Byte[] expected = new Byte[byteArray.length];
    for (int ¢ = 0; ¢ < byteArray.length; ++¢)
      expected[¢] = Byte.valueOf(byteArray[¢]);
    azzert.assertArrayEquals(expected, box.it(byteArray));
  }

  @Test public void charItTest() {
    for (char i = Character.MIN_VALUE; i < Character.MAX_VALUE; ++i)
      azzert.assertEquals(Character.valueOf(i), box.it(i));
    azzert.assertEquals(Character.valueOf(Character.MAX_VALUE), box.it(Character.MAX_VALUE));
  }

  @Test public void charEmptyArrayItTest() {
    azzert.assertArrayEquals(new Character[0], box.it(new char[0]));
  }

  @Test public void charArrayItTest() {
    final char[] charArray = { 1, 2, 3, 4, 5, 6, 10, 127, 128, 127, 0, 127, 50, 100, 65535, 55555 };
    final Character[] expected = new Character[charArray.length];
    for (int ¢ = 0; ¢ < charArray.length; ++¢)
      expected[¢] = Character.valueOf(charArray[¢]);
    azzert.assertArrayEquals(expected, box.it(charArray));
  }

  @Test public void doubleItTest() {
    azzert.assertEquals(Double.valueOf(Double.MAX_VALUE), box.it(Double.MAX_VALUE));
    azzert.assertEquals(Double.valueOf(Double.MIN_VALUE), box.it(Double.MIN_VALUE));
    azzert.assertEquals(Double.valueOf(Double.MIN_NORMAL), box.it(Double.MIN_NORMAL));
    azzert.assertEquals(Double.valueOf(0.0), box.it(0.0));
    azzert.assertEquals(Double.valueOf(Math.E), box.it(Math.E));
    azzert.assertEquals(Double.valueOf(Math.PI), box.it(Math.PI));
    azzert.assertEquals(Double.valueOf(-Math.sqrt(2)), box.it(-Math.sqrt(2)));
    azzert.assertEquals(Double.valueOf(238.0), box.it(238.0));
  }

  @Test public void doubleEmptyArrayItTest() {
    azzert.assertArrayEquals(new Double[0], box.it(new double[0]));
  }

  @Test public void doubleArrayItTest() {
    final double[] doubleArray = { Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL, Math.E, -Math.PI, 0.0, 55555.0, Math.sqrt(2) };
    final Double[] expected = new Double[doubleArray.length];
    for (int ¢ = 0; ¢ < doubleArray.length; ++¢)
      expected[¢] = Double.valueOf(doubleArray[¢]);
    azzert.assertArrayEquals(expected, box.it(doubleArray));
  }

  @Test public void floatItTest() {
    azzert.assertEquals(Float.valueOf(Float.MAX_VALUE), box.it(Float.MAX_VALUE));
    azzert.assertEquals(Float.valueOf(Float.MIN_VALUE), box.it(Float.MIN_VALUE));
    azzert.assertEquals(Float.valueOf(Float.MIN_NORMAL), box.it(Float.MIN_NORMAL));
    azzert.assertEquals(Float.valueOf((float) 0.0), box.it((float) 0.0));
    azzert.assertEquals(Float.valueOf((float) Math.E), box.it((float) Math.E));
    azzert.assertEquals(Float.valueOf((float) Math.PI), box.it((float) Math.PI));
    azzert.assertEquals(Float.valueOf((float) -Math.sqrt(2)), box.it((float) -Math.sqrt(2)));
    azzert.assertEquals(Float.valueOf((float) 238.0), box.it((float) 238.0));
  }

  @Test public void floatEmptyArrayItTest() {
    azzert.assertArrayEquals(new Float[0], box.it(new float[0]));
  }

  @Test public void floatArrayItTest() {
    final float[] floatArray = { Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_NORMAL, (float) Math.E, (float) -Math.PI, (float) 0.0,
        (float) Math.sqrt(2) };
    final Float[] expected = new Float[floatArray.length];
    for (int ¢ = 0; ¢ < floatArray.length; ++¢)
      expected[¢] = Float.valueOf(floatArray[¢]);
    azzert.assertArrayEquals(expected, box.it(floatArray));
  }

  @Test public void intItTest() {
    azzert.assertEquals(Integer.valueOf(Integer.MAX_VALUE), box.it(Integer.MAX_VALUE));
    azzert.assertEquals(Integer.valueOf(Integer.MIN_VALUE), box.it(Integer.MIN_VALUE));
    azzert.assertEquals(Integer.valueOf(0), box.it(0));
    azzert.assertEquals(Integer.valueOf(500), box.it(500));
    azzert.assertEquals(Integer.valueOf(-3), box.it(-3));
  }

  @Test public void intEmptyArrayItTest() {
    azzert.assertArrayEquals(new Integer[0], box.it(new int[0]));
  }

  @Test public void intArrayItTest() {
    final int[] intArray = { 10, Integer.MAX_VALUE, Integer.MIN_VALUE, -127, 0, 58745, -124856, 100 };
    final Integer[] expected = new Integer[intArray.length];
    for (int ¢ = 0; ¢ < intArray.length; ++¢)
      expected[¢] = Integer.valueOf(intArray[¢]);
    azzert.assertArrayEquals(expected, box.it(intArray));
  }

  @Test public void longItTest() {
    azzert.assertEquals(Long.valueOf(Long.MAX_VALUE), box.it(Long.MAX_VALUE));
    azzert.assertEquals(Long.valueOf(Long.MIN_VALUE), box.it(Long.MIN_VALUE));
    azzert.assertEquals(Long.valueOf(0L), box.it(0L));
    azzert.assertEquals(Long.valueOf(500L), box.it(500L));
    azzert.assertEquals(Long.valueOf(-3L), box.it(-3L));
  }

  @Test public void longEmptyArrayItTest() {
    azzert.assertArrayEquals(new Long[0], box.it(new long[0]));
  }

  @Test public void longArrayItTest() {
    final long[] longArray = { 10L, Long.MAX_VALUE, Long.MIN_VALUE, 0L, 58745L, -124856L, 100L };
    final Long[] expected = new Long[longArray.length];
    for (int ¢ = 0; ¢ < longArray.length; ++¢)
      expected[¢] = Long.valueOf(longArray[¢]);
    azzert.assertArrayEquals(expected, box.it(longArray));
  }

  @Test public void shortItTest() {
    azzert.assertEquals(Short.valueOf(Short.MAX_VALUE), box.it(Short.MAX_VALUE));
    azzert.assertEquals(Short.valueOf(Short.MIN_VALUE), box.it(Short.MIN_VALUE));
    azzert.assertEquals(Short.valueOf((short) 0), box.it((short) 0));
    azzert.assertEquals(Short.valueOf((short) 500), box.it((short) 500));
    azzert.assertEquals(Short.valueOf((short) -3), box.it((short) -3));
  }

  @Test public void shortEmptyArrayItTest() {
    azzert.assertArrayEquals(new Short[0], box.it(new short[0]));
  }

  @Test public void shortArrayItTest() {
    final short[] shortArray = { 10, Short.MAX_VALUE, Short.MIN_VALUE, -127, 0, 100 };
    final Short[] expected = new Short[shortArray.length];
    for (int ¢ = 0; ¢ < shortArray.length; ++¢)
      expected[¢] = Short.valueOf(shortArray[¢]);
    azzert.assertArrayEquals(expected, box.it(shortArray));
  }
}
