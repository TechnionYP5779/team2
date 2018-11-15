package fluent.ly;

import static org.junit.Assert.*;

import static fluent.ly.box.*;

import org.junit.*;

@SuppressWarnings("static-method") public class boxTest {
  @Test public void booleanBoxingTest() {
    assertEquals(Boolean.TRUE, box(true));
    assertEquals(Boolean.FALSE, box(false));
  }

  @Test public void booleanEmptyArrayBoxingTest() {
    assertArrayEquals(new Boolean[0], box(new boolean[0]));
  }

  @Test public void booleanArrayBoxingTest() {
    final boolean[] boolArray = { true, true, false, false, true, false };
    final Boolean[] expected = new Boolean[boolArray.length];
    for (int ¢ = 0; ¢ < boolArray.length; ++¢)
      expected[¢] = Boolean.valueOf(boolArray[¢]);
    assertArrayEquals(expected, box(boolArray));
  }

  @Test public void byteBoxingTest() {
    for (byte i = Byte.MIN_VALUE; i < Byte.MAX_VALUE; ++i)
      assertEquals(Byte.valueOf(i), box(i));
    assertEquals(Byte.valueOf(Byte.MAX_VALUE), box(Byte.MAX_VALUE));
  }

  @Test public void byteEmptyArrayBoxingTest() {
    assertArrayEquals(new Byte[0], box(new byte[0]));
  }

  @Test public void byteArrayBoxingTest() {
    final byte[] byteArray = { 1, 2, 3, 4, 5, 6, 10, Byte.MAX_VALUE, Byte.MIN_VALUE, -127, 0, 127, 50, 100 };
    final Byte[] expected = new Byte[byteArray.length];
    for (int ¢ = 0; ¢ < byteArray.length; ++¢)
      expected[¢] = Byte.valueOf(byteArray[¢]);
    assertArrayEquals(expected, box(byteArray));
  }

  @Test public void charBoxingTest() {
    for (char i = Character.MIN_VALUE; i < Character.MAX_VALUE; ++i)
      assertEquals(Character.valueOf(i), box(i));
    assertEquals(Character.valueOf(Character.MAX_VALUE), box(Character.MAX_VALUE));
  }

  @Test public void charEmptyArrayBoxingTest() {
    assertArrayEquals(new Character[0], box(new char[0]));
  }

  @Test public void charArrayBoxingTest() {
    final char[] charArray = { 1, 2, 3, 4, 5, 6, 10, 127, 128, 127, 0, 127, 50, 100, 65535, 55555 };
    final Character[] expected = new Character[charArray.length];
    for (int ¢ = 0; ¢ < charArray.length; ++¢)
      expected[¢] = Character.valueOf(charArray[¢]);
    assertArrayEquals(expected, box(charArray));
  }

  @Test public void doubleBoxingTest() {
    assertEquals(Double.valueOf(Double.MAX_VALUE), box(Double.MAX_VALUE));
    assertEquals(Double.valueOf(Double.MIN_VALUE), box(Double.MIN_VALUE));
    assertEquals(Double.valueOf(Double.MIN_NORMAL), box(Double.MIN_NORMAL));
    assertEquals(Double.valueOf(0.0), box(0.0));
    assertEquals(Double.valueOf(Math.E), box(Math.E));
    assertEquals(Double.valueOf(Math.PI), box(Math.PI));
    assertEquals(Double.valueOf(-Math.sqrt(2)), box(-Math.sqrt(2)));
    assertEquals(Double.valueOf(238.0), box(238.0));
  }

  @Test public void doubleEmptyArrayBoxingTest() {
    assertArrayEquals(new Double[0], box(new double[0]));
  }

  @Test public void doubleArrayBoxingTest() {
    final double[] doubleArray = { Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL, Math.E, -Math.PI, 0.0, 55555.0, Math.sqrt(2) };
    final Double[] expected = new Double[doubleArray.length];
    for (int ¢ = 0; ¢ < doubleArray.length; ++¢)
      expected[¢] = Double.valueOf(doubleArray[¢]);
    assertArrayEquals(expected, box(doubleArray));
  }

  @Test public void floatBoxingTest() {
    assertEquals(Float.valueOf(Float.MAX_VALUE), box(Float.MAX_VALUE));
    assertEquals(Float.valueOf(Float.MIN_VALUE), box(Float.MIN_VALUE));
    assertEquals(Float.valueOf(Float.MIN_NORMAL), box(Float.MIN_NORMAL));
    assertEquals(Float.valueOf((float) 0.0), box((float) 0.0));
    assertEquals(Float.valueOf((float) Math.E), box((float) Math.E));
    assertEquals(Float.valueOf((float) Math.PI), box((float) Math.PI));
    assertEquals(Float.valueOf((float) -Math.sqrt(2)), box((float) -Math.sqrt(2)));
    assertEquals(Float.valueOf((float) 238.0), box((float) 238.0));
  }

  @Test public void floatEmptyArrayBoxingTest() {
    assertArrayEquals(new Float[0], box(new float[0]));
  }

  @Test public void floatArrayBoxingTest() {
    final float[] floatArray = { Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_NORMAL, (float) Math.E, (float) -Math.PI, (float) 0.0,
        (float) Math.sqrt(2) };
    final Float[] expected = new Float[floatArray.length];
    for (int ¢ = 0; ¢ < floatArray.length; ++¢)
      expected[¢] = Float.valueOf(floatArray[¢]);
    assertArrayEquals(expected, box(floatArray));
  }

  @Test public void intBoxingTest() {
    assertEquals(Integer.valueOf(Integer.MAX_VALUE), box(Integer.MAX_VALUE));
    assertEquals(Integer.valueOf(Integer.MIN_VALUE), box(Integer.MIN_VALUE));
    assertEquals(Integer.valueOf(0), box(0));
    assertEquals(Integer.valueOf(500), box(500));
    assertEquals(Integer.valueOf(-3), box(-3));
  }

  @Test public void intEmptyArrayBoxingTest() {
    assertArrayEquals(new Integer[0], box(new int[0]));
  }

  @Test public void intArrayBoxingTest() {
    final int[] intArray = { 10, Integer.MAX_VALUE, Integer.MIN_VALUE, -127, 0, 58745, -124856, 100 };
    final Integer[] expected = new Integer[intArray.length];
    for (int ¢ = 0; ¢ < intArray.length; ++¢)
      expected[¢] = Integer.valueOf(intArray[¢]);
    assertArrayEquals(expected, box(intArray));
  }

  @Test public void longBoxingTest() {
    assertEquals(Long.valueOf(Long.MAX_VALUE), box(Long.MAX_VALUE));
    assertEquals(Long.valueOf(Long.MIN_VALUE), box(Long.MIN_VALUE));
    assertEquals(Long.valueOf(0L), box(0L));
    assertEquals(Long.valueOf(500L), box(500L));
    assertEquals(Long.valueOf(-3L), box(-3L));
  }

  @Test public void longEmptyArrayBoxingTest() {
    assertArrayEquals(new Long[0], box(new long[0]));
  }

  @Test public void longArrayBoxingTest() {
    final long[] longArray = { 10L, Long.MAX_VALUE, Long.MIN_VALUE, 0L, 58745L, -124856L, 100L };
    final Long[] expected = new Long[longArray.length];
    for (int ¢ = 0; ¢ < longArray.length; ++¢)
      expected[¢] = Long.valueOf(longArray[¢]);
    assertArrayEquals(expected, box(longArray));
  }

  @Test public void shortBoxingTest() {
    assertEquals(Short.valueOf(Short.MAX_VALUE), box(Short.MAX_VALUE));
    assertEquals(Short.valueOf(Short.MIN_VALUE), box(Short.MIN_VALUE));
    assertEquals(Short.valueOf((short) 0), box((short) 0));
    assertEquals(Short.valueOf((short) 500), box((short) 500));
    assertEquals(Short.valueOf((short) -3), box((short) -3));
  }

  @Test public void shortEmptyArrayBoxingTest() {
    assertArrayEquals(new Short[0], box(new short[0]));
  }

  @Test public void shortArrayBoxingTest() {
    final short[] shortArray = { 10, Short.MAX_VALUE, Short.MIN_VALUE, -127, 0, 100 };
    final Short[] expected = new Short[shortArray.length];
    for (int ¢ = 0; ¢ < shortArray.length; ++¢)
      expected[¢] = Short.valueOf(shortArray[¢]);
    assertArrayEquals(expected, box(shortArray));
  }

  @Test public void booleanItTest() {
    assertEquals(Boolean.TRUE, box.it(true));
    assertEquals(Boolean.FALSE, box.it(false));
  }

  @Test public void booleanEmptyArrayItTest() {
    assertArrayEquals(new Boolean[0], box.it(new boolean[0]));
  }

  @Test public void booleanArrayItTest() {
    final boolean[] boolArray = { true, true, false, false, true, false };
    final Boolean[] expected = new Boolean[boolArray.length];
    for (int ¢ = 0; ¢ < boolArray.length; ++¢)
      expected[¢] = Boolean.valueOf(boolArray[¢]);
    assertArrayEquals(expected, box.it(boolArray));
  }

  @Test public void byteItTest() {
    for (byte i = Byte.MIN_VALUE; i < Byte.MAX_VALUE; ++i)
      assertEquals(Byte.valueOf(i), box.it(i));
    assertEquals(Byte.valueOf(Byte.MAX_VALUE), box.it(Byte.MAX_VALUE));
  }

  @Test public void byteEmptyArrayItTest() {
    assertArrayEquals(new Byte[0], box.it(new byte[0]));
  }

  @Test public void byteArrayItTest() {
    final byte[] byteArray = { 1, 2, 3, 4, 5, 6, 10, Byte.MAX_VALUE, Byte.MIN_VALUE, -127, 0, 127, 50, 100 };
    final Byte[] expected = new Byte[byteArray.length];
    for (int ¢ = 0; ¢ < byteArray.length; ++¢)
      expected[¢] = Byte.valueOf(byteArray[¢]);
    assertArrayEquals(expected, box.it(byteArray));
  }

  @Test public void charItTest() {
    for (char i = Character.MIN_VALUE; i < Character.MAX_VALUE; ++i)
      assertEquals(Character.valueOf(i), box.it(i));
    assertEquals(Character.valueOf(Character.MAX_VALUE), box.it(Character.MAX_VALUE));
  }

  @Test public void charEmptyArrayItTest() {
    assertArrayEquals(new Character[0], box.it(new char[0]));
  }

  @Test public void charArrayItTest() {
    final char[] charArray = { 1, 2, 3, 4, 5, 6, 10, 127, 128, 127, 0, 127, 50, 100, 65535, 55555 };
    final Character[] expected = new Character[charArray.length];
    for (int ¢ = 0; ¢ < charArray.length; ++¢)
      expected[¢] = Character.valueOf(charArray[¢]);
    assertArrayEquals(expected, box.it(charArray));
  }

  @Test public void doubleItTest() {
    assertEquals(Double.valueOf(Double.MAX_VALUE), box.it(Double.MAX_VALUE));
    assertEquals(Double.valueOf(Double.MIN_VALUE), box.it(Double.MIN_VALUE));
    assertEquals(Double.valueOf(Double.MIN_NORMAL), box.it(Double.MIN_NORMAL));
    assertEquals(Double.valueOf(0.0), box.it(0.0));
    assertEquals(Double.valueOf(Math.E), box.it(Math.E));
    assertEquals(Double.valueOf(Math.PI), box.it(Math.PI));
    assertEquals(Double.valueOf(-Math.sqrt(2)), box.it(-Math.sqrt(2)));
    assertEquals(Double.valueOf(238.0), box.it(238.0));
  }

  @Test public void doubleEmptyArrayItTest() {
    assertArrayEquals(new Double[0], box.it(new double[0]));
  }

  @Test public void doubleArrayItTest() {
    final double[] doubleArray = { Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL, Math.E, -Math.PI, 0.0, 55555.0, Math.sqrt(2) };
    final Double[] expected = new Double[doubleArray.length];
    for (int ¢ = 0; ¢ < doubleArray.length; ++¢)
      expected[¢] = Double.valueOf(doubleArray[¢]);
    assertArrayEquals(expected, box.it(doubleArray));
  }

  @Test public void floatItTest() {
    assertEquals(Float.valueOf(Float.MAX_VALUE), box.it(Float.MAX_VALUE));
    assertEquals(Float.valueOf(Float.MIN_VALUE), box.it(Float.MIN_VALUE));
    assertEquals(Float.valueOf(Float.MIN_NORMAL), box.it(Float.MIN_NORMAL));
    assertEquals(Float.valueOf((float) 0.0), box.it((float) 0.0));
    assertEquals(Float.valueOf((float) Math.E), box.it((float) Math.E));
    assertEquals(Float.valueOf((float) Math.PI), box.it((float) Math.PI));
    assertEquals(Float.valueOf((float) -Math.sqrt(2)), box.it((float) -Math.sqrt(2)));
    assertEquals(Float.valueOf((float) 238.0), box.it((float) 238.0));
  }

  @Test public void floatEmptyArrayItTest() {
    assertArrayEquals(new Float[0], box.it(new float[0]));
  }

  @Test public void floatArrayItTest() {
    final float[] floatArray = { Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_NORMAL, (float) Math.E, (float) -Math.PI, (float) 0.0,
        (float) Math.sqrt(2) };
    final Float[] expected = new Float[floatArray.length];
    for (int ¢ = 0; ¢ < floatArray.length; ++¢)
      expected[¢] = Float.valueOf(floatArray[¢]);
    assertArrayEquals(expected, box.it(floatArray));
  }

  @Test public void intItTest() {
    assertEquals(Integer.valueOf(Integer.MAX_VALUE), box.it(Integer.MAX_VALUE));
    assertEquals(Integer.valueOf(Integer.MIN_VALUE), box.it(Integer.MIN_VALUE));
    assertEquals(Integer.valueOf(0), box.it(0));
    assertEquals(Integer.valueOf(500), box.it(500));
    assertEquals(Integer.valueOf(-3), box.it(-3));
  }

  @Test public void intEmptyArrayItTest() {
    assertArrayEquals(new Integer[0], box.it(new int[0]));
  }

  @Test public void intArrayItTest() {
    final int[] intArray = { 10, Integer.MAX_VALUE, Integer.MIN_VALUE, -127, 0, 58745, -124856, 100 };
    final Integer[] expected = new Integer[intArray.length];
    for (int ¢ = 0; ¢ < intArray.length; ++¢)
      expected[¢] = Integer.valueOf(intArray[¢]);
    assertArrayEquals(expected, box.it(intArray));
  }

  @Test public void longItTest() {
    assertEquals(Long.valueOf(Long.MAX_VALUE), box.it(Long.MAX_VALUE));
    assertEquals(Long.valueOf(Long.MIN_VALUE), box.it(Long.MIN_VALUE));
    assertEquals(Long.valueOf(0L), box.it(0L));
    assertEquals(Long.valueOf(500L), box.it(500L));
    assertEquals(Long.valueOf(-3L), box.it(-3L));
  }

  @Test public void longEmptyArrayItTest() {
    assertArrayEquals(new Long[0], box.it(new long[0]));
  }

  @Test public void longArrayItTest() {
    final long[] longArray = { 10L, Long.MAX_VALUE, Long.MIN_VALUE, 0L, 58745L, -124856L, 100L };
    final Long[] expected = new Long[longArray.length];
    for (int ¢ = 0; ¢ < longArray.length; ++¢)
      expected[¢] = Long.valueOf(longArray[¢]);
    assertArrayEquals(expected, box.it(longArray));
  }

  @Test public void shortItTest() {
    assertEquals(Short.valueOf(Short.MAX_VALUE), box.it(Short.MAX_VALUE));
    assertEquals(Short.valueOf(Short.MIN_VALUE), box.it(Short.MIN_VALUE));
    assertEquals(Short.valueOf((short) 0), box.it((short) 0));
    assertEquals(Short.valueOf((short) 500), box.it((short) 500));
    assertEquals(Short.valueOf((short) -3), box.it((short) -3));
  }

  @Test public void shortEmptyArrayItTest() {
    assertArrayEquals(new Short[0], box.it(new short[0]));
  }

  @Test public void shortArrayItTest() {
    final short[] shortArray = { 10, Short.MAX_VALUE, Short.MIN_VALUE, -127, 0, 100 };
    final Short[] expected = new Short[shortArray.length];
    for (int ¢ = 0; ¢ < shortArray.length; ++¢)
      expected[¢] = Short.valueOf(shortArray[¢]);
    assertArrayEquals(expected, box.it(shortArray));
  }
}
