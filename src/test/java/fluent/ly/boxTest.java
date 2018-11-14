package fluent.ly;

import org.junit.*;

@SuppressWarnings({ "static-method", "static-access" }) public class boxTest {
  @Test public void booleanBoxingTest() {
    Assert.assertEquals(Boolean.TRUE, box.box(true));
    Assert.assertEquals(Boolean.FALSE, box.box(false));
  }

  @Test public void booleanEmptyArrayBoxingTest() {
    Assert.assertArrayEquals(new Boolean[0], box.box(new boolean[0]));
  }

  @Test public void booleanArrayBoxingTest() {
    final boolean[] boolArray = { true, true, false, false, true, false };
    final Boolean[] expected = new Boolean[boolArray.length];
    for (int ¢ = 0; ¢ < boolArray.length; ++¢)
      expected[¢] = Boolean.valueOf(boolArray[¢]);
    Assert.assertArrayEquals(expected, box.box(boolArray));
  }

  @Test public void byteBoxingTest() {
    for (byte i = Byte.MIN_VALUE; i < Byte.MAX_VALUE; ++i)
      Assert.assertEquals(Byte.valueOf(i), box.box(i));
    Assert.assertEquals(Byte.valueOf(Byte.MAX_VALUE), box.box(Byte.MAX_VALUE));
  }

  @Test public void byteEmptyArrayBoxingTest() {
    Assert.assertArrayEquals(new Byte[0], box.box(new byte[0]));
  }

  @Test public void byteArrayBoxingTest() {
    final byte[] byteArray = { 1, 2, 3, 4, 5, 6, 10, Byte.MAX_VALUE, Byte.MIN_VALUE, -127, 0, 127, 50, 100 };
    final Byte[] expected = new Byte[byteArray.length];
    for (int ¢ = 0; ¢ < byteArray.length; ++¢)
      expected[¢] = Byte.valueOf(byteArray[¢]);
    Assert.assertArrayEquals(expected, box.box(byteArray));
  }

  @Test public void charBoxingTest() {
    for (char i = Character.MIN_VALUE; i < Character.MAX_VALUE; ++i)
      Assert.assertEquals(Character.valueOf(i), box.box(i));
    Assert.assertEquals(Character.valueOf(Character.MAX_VALUE), box.box(Character.MAX_VALUE));
  }

  @Test public void charEmptyArrayBoxingTest() {
    Assert.assertArrayEquals(new Character[0], box.box(new char[0]));
  }

  @Test public void charArrayBoxingTest() {
    final char[] charArray = { 1, 2, 3, 4, 5, 6, 10, 127, 128, 127, 0, 127, 50, 100, 65535, 55555 };
    final Character[] expected = new Character[charArray.length];
    for (int ¢ = 0; ¢ < charArray.length; ++¢)
      expected[¢] = Character.valueOf(charArray[¢]);
    Assert.assertArrayEquals(expected, box.box(charArray));
  }

  @Test public void doubleBoxingTest() {
    Assert.assertEquals(Double.valueOf(Double.MAX_VALUE), box.box(Double.MAX_VALUE));
    Assert.assertEquals(Double.valueOf(Double.MIN_VALUE), box.box(Double.MIN_VALUE));
    Assert.assertEquals(Double.valueOf(Double.MIN_NORMAL), box.box(Double.MIN_NORMAL));
    Assert.assertEquals(Double.valueOf(0.0), box.box(0.0));
    Assert.assertEquals(Double.valueOf(Math.E), box.box(Math.E));
    Assert.assertEquals(Double.valueOf(Math.PI), box.box(Math.PI));
    Assert.assertEquals(Double.valueOf(-Math.sqrt(2)), box.box(-Math.sqrt(2)));
    Assert.assertEquals(Double.valueOf(238.0), box.box(238.0));
  }

  @Test public void doubleEmptyArrayBoxingTest() {
    Assert.assertArrayEquals(new Double[0], box.box(new double[0]));
  }

  @Test public void doubleArrayBoxingTest() {
    final double[] doubleArray = { Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL, Math.E, -Math.PI, 0.0, 55555.0, Math.sqrt(2) };
    final Double[] expected = new Double[doubleArray.length];
    for (int ¢ = 0; ¢ < doubleArray.length; ++¢)
      expected[¢] = Double.valueOf(doubleArray[¢]);
    Assert.assertArrayEquals(expected, box.box(doubleArray));
  }

  @Test public void floatBoxingTest() {
    Assert.assertEquals(Float.valueOf(Float.MAX_VALUE), box.box(Float.MAX_VALUE));
    Assert.assertEquals(Float.valueOf(Float.MIN_VALUE), box.box(Float.MIN_VALUE));
    Assert.assertEquals(Float.valueOf(Float.MIN_NORMAL), box.box(Float.MIN_NORMAL));
    Assert.assertEquals(Float.valueOf((float) 0.0), box.box((float) 0.0));
    Assert.assertEquals(Float.valueOf((float) Math.E), box.box((float) Math.E));
    Assert.assertEquals(Float.valueOf((float) Math.PI), box.box((float) Math.PI));
    Assert.assertEquals(Float.valueOf((float) -Math.sqrt(2)), box.box((float) -Math.sqrt(2)));
    Assert.assertEquals(Float.valueOf((float) 238.0), box.box((float) 238.0));
  }

  @Test public void floatEmptyArrayBoxingTest() {
    Assert.assertArrayEquals(new Float[0], box.box(new float[0]));
  }

  @Test public void floatArrayBoxingTest() {
    final float[] floatArray = { Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_NORMAL, (float) Math.E, (float) -Math.PI, (float) 0.0,
        (float) Math.sqrt(2) };
    final Float[] expected = new Float[floatArray.length];
    for (int ¢ = 0; ¢ < floatArray.length; ++¢)
      expected[¢] = Float.valueOf(floatArray[¢]);
    Assert.assertArrayEquals(expected, box.box(floatArray));
  }

  @Test public void intBoxingTest() {
    Assert.assertEquals(Integer.valueOf(Integer.MAX_VALUE), box.box(Integer.MAX_VALUE));
    Assert.assertEquals(Integer.valueOf(Integer.MIN_VALUE), box.box(Integer.MIN_VALUE));
    Assert.assertEquals(Integer.valueOf(0), box.box(0));
    Assert.assertEquals(Integer.valueOf(500), box.box(500));
    Assert.assertEquals(Integer.valueOf(-3), box.box(-3));
  }

  @Test public void intEmptyArrayBoxingTest() {
    Assert.assertArrayEquals(new Integer[0], box.box(new int[0]));
  }

  @Test public void intArrayBoxingTest() {
    final int[] intArray = { 10, Integer.MAX_VALUE, Integer.MIN_VALUE, -127, 0, 58745, -124856, 100 };
    final Integer[] expected = new Integer[intArray.length];
    for (int ¢ = 0; ¢ < intArray.length; ++¢)
      expected[¢] = Integer.valueOf(intArray[¢]);
    Assert.assertArrayEquals(expected, box.box(intArray));
  }

  @Test public void longBoxingTest() {
    Assert.assertEquals(Long.valueOf(Long.MAX_VALUE), box.box(Long.MAX_VALUE));
    Assert.assertEquals(Long.valueOf(Long.MIN_VALUE), box.box(Long.MIN_VALUE));
    Assert.assertEquals(Long.valueOf(0L), box.box(0L));
    Assert.assertEquals(Long.valueOf(500L), box.box(500L));
    Assert.assertEquals(Long.valueOf(-3L), box.box(-3L));
  }

  @Test public void longEmptyArrayBoxingTest() {
    Assert.assertArrayEquals(new Long[0], box.box(new long[0]));
  }

  @Test public void longArrayBoxingTest() {
    final long[] longArray = { 10L, Long.MAX_VALUE, Long.MIN_VALUE, 0L, 58745L, -124856L, 100L };
    final Long[] expected = new Long[longArray.length];
    for (int ¢ = 0; ¢ < longArray.length; ++¢)
      expected[¢] = Long.valueOf(longArray[¢]);
    Assert.assertArrayEquals(expected, box.box(longArray));
  }

  @Test public void shortBoxingTest() {
    Assert.assertEquals(Short.valueOf(Short.MAX_VALUE), box.box(Short.MAX_VALUE));
    Assert.assertEquals(Short.valueOf(Short.MIN_VALUE), box.box(Short.MIN_VALUE));
    Assert.assertEquals(Short.valueOf((short) 0), box.box((short) 0));
    Assert.assertEquals(Short.valueOf((short) 500), box.box((short) 500));
    Assert.assertEquals(Short.valueOf((short) -3), box.box((short) -3));
  }

  @Test public void shortEmptyArrayBoxingTest() {
    Assert.assertArrayEquals(new Short[0], box.box(new short[0]));
  }

  @Test public void shortArrayBoxingTest() {
    final short[] shortArray = { 10, Short.MAX_VALUE, Short.MIN_VALUE, -127, 0, 100 };
    final Short[] expected = new Short[shortArray.length];
    for (int ¢ = 0; ¢ < shortArray.length; ++¢)
      expected[¢] = Short.valueOf(shortArray[¢]);
    Assert.assertArrayEquals(expected, box.box(shortArray));
  }

  @Test public void booleanItTest() {
    Assert.assertEquals(Boolean.TRUE, box.it(true));
    Assert.assertEquals(Boolean.FALSE, box.it(false));
  }

  @Test public void booleanEmptyArrayItTest() {
    Assert.assertArrayEquals(new Boolean[0], box.it(new boolean[0]));
  }

  @Test public void booleanArrayItTest() {
    final boolean[] boolArray = { true, true, false, false, true, false };
    final Boolean[] expected = new Boolean[boolArray.length];
    for (int ¢ = 0; ¢ < boolArray.length; ++¢)
      expected[¢] = Boolean.valueOf(boolArray[¢]);
    Assert.assertArrayEquals(expected, box.it(boolArray));
  }

  @Test public void byteItTest() {
    for (byte i = Byte.MIN_VALUE; i < Byte.MAX_VALUE; ++i)
      Assert.assertEquals(Byte.valueOf(i), box.it(i));
    Assert.assertEquals(Byte.valueOf(Byte.MAX_VALUE), box.it(Byte.MAX_VALUE));
  }

  @Test public void byteEmptyArrayItTest() {
    Assert.assertArrayEquals(new Byte[0], box.it(new byte[0]));
  }

  @Test public void byteArrayItTest() {
    final byte[] byteArray = { 1, 2, 3, 4, 5, 6, 10, Byte.MAX_VALUE, Byte.MIN_VALUE, -127, 0, 127, 50, 100 };
    final Byte[] expected = new Byte[byteArray.length];
    for (int ¢ = 0; ¢ < byteArray.length; ++¢)
      expected[¢] = Byte.valueOf(byteArray[¢]);
    Assert.assertArrayEquals(expected, box.it(byteArray));
  }

  @Test public void charItTest() {
    for (char i = Character.MIN_VALUE; i < Character.MAX_VALUE; ++i)
      Assert.assertEquals(Character.valueOf(i), box.it(i));
    Assert.assertEquals(Character.valueOf(Character.MAX_VALUE), box.it(Character.MAX_VALUE));
  }

  @Test public void charEmptyArrayItTest() {
    Assert.assertArrayEquals(new Character[0], box.it(new char[0]));
  }

  @Test public void charArrayItTest() {
    final char[] charArray = { 1, 2, 3, 4, 5, 6, 10, 127, 128, 127, 0, 127, 50, 100, 65535, 55555 };
    final Character[] expected = new Character[charArray.length];
    for (int ¢ = 0; ¢ < charArray.length; ++¢)
      expected[¢] = Character.valueOf(charArray[¢]);
    Assert.assertArrayEquals(expected, box.it(charArray));
  }

  @Test public void doubleItTest() {
    Assert.assertEquals(Double.valueOf(Double.MAX_VALUE), box.it(Double.MAX_VALUE));
    Assert.assertEquals(Double.valueOf(Double.MIN_VALUE), box.it(Double.MIN_VALUE));
    Assert.assertEquals(Double.valueOf(Double.MIN_NORMAL), box.it(Double.MIN_NORMAL));
    Assert.assertEquals(Double.valueOf(0.0), box.it(0.0));
    Assert.assertEquals(Double.valueOf(Math.E), box.it(Math.E));
    Assert.assertEquals(Double.valueOf(Math.PI), box.it(Math.PI));
    Assert.assertEquals(Double.valueOf(-Math.sqrt(2)), box.it(-Math.sqrt(2)));
    Assert.assertEquals(Double.valueOf(238.0), box.it(238.0));
  }

  @Test public void doubleEmptyArrayItTest() {
    Assert.assertArrayEquals(new Double[0], box.it(new double[0]));
  }

  @Test public void doubleArrayItTest() {
    final double[] doubleArray = { Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL, Math.E, -Math.PI, 0.0, 55555.0, Math.sqrt(2) };
    final Double[] expected = new Double[doubleArray.length];
    for (int ¢ = 0; ¢ < doubleArray.length; ++¢)
      expected[¢] = Double.valueOf(doubleArray[¢]);
    Assert.assertArrayEquals(expected, box.it(doubleArray));
  }

  @Test public void floatItTest() {
    Assert.assertEquals(Float.valueOf(Float.MAX_VALUE), box.it(Float.MAX_VALUE));
    Assert.assertEquals(Float.valueOf(Float.MIN_VALUE), box.it(Float.MIN_VALUE));
    Assert.assertEquals(Float.valueOf(Float.MIN_NORMAL), box.it(Float.MIN_NORMAL));
    Assert.assertEquals(Float.valueOf((float) 0.0), box.it((float) 0.0));
    Assert.assertEquals(Float.valueOf((float) Math.E), box.it((float) Math.E));
    Assert.assertEquals(Float.valueOf((float) Math.PI), box.it((float) Math.PI));
    Assert.assertEquals(Float.valueOf((float) -Math.sqrt(2)), box.it((float) -Math.sqrt(2)));
    Assert.assertEquals(Float.valueOf((float) 238.0), box.it((float) 238.0));
  }

  @Test public void floatEmptyArrayItTest() {
    Assert.assertArrayEquals(new Float[0], box.it(new float[0]));
  }

  @Test public void floatArrayItTest() {
    final float[] floatArray = { Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_NORMAL, (float) Math.E, (float) -Math.PI, (float) 0.0,
        (float) Math.sqrt(2) };
    final Float[] expected = new Float[floatArray.length];
    for (int ¢ = 0; ¢ < floatArray.length; ++¢)
      expected[¢] = Float.valueOf(floatArray[¢]);
    Assert.assertArrayEquals(expected, box.it(floatArray));
  }

  @Test public void intItTest() {
    Assert.assertEquals(Integer.valueOf(Integer.MAX_VALUE), box.it(Integer.MAX_VALUE));
    Assert.assertEquals(Integer.valueOf(Integer.MIN_VALUE), box.it(Integer.MIN_VALUE));
    Assert.assertEquals(Integer.valueOf(0), box.it(0));
    Assert.assertEquals(Integer.valueOf(500), box.it(500));
    Assert.assertEquals(Integer.valueOf(-3), box.it(-3));
  }

  @Test public void intEmptyArrayItTest() {
    Assert.assertArrayEquals(new Integer[0], box.it(new int[0]));
  }

  @Test public void intArrayItTest() {
    final int[] intArray = { 10, Integer.MAX_VALUE, Integer.MIN_VALUE, -127, 0, 58745, -124856, 100 };
    final Integer[] expected = new Integer[intArray.length];
    for (int ¢ = 0; ¢ < intArray.length; ++¢)
      expected[¢] = Integer.valueOf(intArray[¢]);
    Assert.assertArrayEquals(expected, box.it(intArray));
  }

  @Test public void longItTest() {
    Assert.assertEquals(Long.valueOf(Long.MAX_VALUE), box.it(Long.MAX_VALUE));
    Assert.assertEquals(Long.valueOf(Long.MIN_VALUE), box.it(Long.MIN_VALUE));
    Assert.assertEquals(Long.valueOf(0L), box.it(0L));
    Assert.assertEquals(Long.valueOf(500L), box.it(500L));
    Assert.assertEquals(Long.valueOf(-3L), box.it(-3L));
  }

  @Test public void longEmptyArrayItTest() {
    Assert.assertArrayEquals(new Long[0], box.it(new long[0]));
  }

  @Test public void longArrayItTest() {
    final long[] longArray = { 10L, Long.MAX_VALUE, Long.MIN_VALUE, 0L, 58745L, -124856L, 100L };
    final Long[] expected = new Long[longArray.length];
    for (int ¢ = 0; ¢ < longArray.length; ++¢)
      expected[¢] = Long.valueOf(longArray[¢]);
    Assert.assertArrayEquals(expected, box.it(longArray));
  }

  @Test public void shortItTest() {
    Assert.assertEquals(Short.valueOf(Short.MAX_VALUE), box.it(Short.MAX_VALUE));
    Assert.assertEquals(Short.valueOf(Short.MIN_VALUE), box.it(Short.MIN_VALUE));
    Assert.assertEquals(Short.valueOf((short) 0), box.it((short) 0));
    Assert.assertEquals(Short.valueOf((short) 500), box.it((short) 500));
    Assert.assertEquals(Short.valueOf((short) -3), box.it((short) -3));
  }

  @Test public void shortEmptyArrayItTest() {
    Assert.assertArrayEquals(new Short[0], box.it(new short[0]));
  }

  @Test public void shortArrayItTest() {
    final short[] shortArray = { 10, Short.MAX_VALUE, Short.MIN_VALUE, -127, 0, 100 };
    final Short[] expected = new Short[shortArray.length];
    for (int ¢ = 0; ¢ < shortArray.length; ++¢)
      expected[¢] = Short.valueOf(shortArray[¢]);
    Assert.assertArrayEquals(expected, box.it(shortArray));
  }
}
