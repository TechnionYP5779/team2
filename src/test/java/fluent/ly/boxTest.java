package fluent.ly;

import org.junit.*;

@SuppressWarnings({ "static-method", "static-access" }) public class boxTest {
  @Test public void booleanBoxingTest() {
    azzert.assertEquals(Boolean.TRUE, box.box(true));
    azzert.assertEquals(Boolean.FALSE, box.box(false));
  }

  @Test public void booleanEmptyArrayBoxingTest() {
    azzert.assertArrayEquals(new Boolean[0], box.box(new boolean[0]));
  }

  @Test public void booleanArrayBoxingTest() {
    boolean[] boolArray = { true, true, false, false, true, false };
    Boolean[] expected = new Boolean[boolArray.length];
    for (int ¢ = 0; ¢ < boolArray.length; ++¢)
      expected[¢] = Boolean.valueOf(boolArray[¢]);
    azzert.assertArrayEquals(expected, box.box(boolArray));
  }

  @Test public void byteBoxingTest() {
    for (byte i = Byte.MIN_VALUE; i < Byte.MAX_VALUE; ++i)
      azzert.assertEquals(Byte.valueOf(i), box.box(i));
    azzert.assertEquals(Byte.valueOf(Byte.MAX_VALUE), box.box(Byte.MAX_VALUE));
  }

  @Test public void byteEmptyArrayBoxingTest() {
    azzert.assertArrayEquals(new Byte[0], box.box(new byte[0]));
  }

  @Test public void byteArrayBoxingTest() {
    byte[] byteArray = { 1, 2, 3, 4, 5, 6, 10, Byte.MAX_VALUE, Byte.MIN_VALUE, -127, 0, 127, 50, 100 };
    Byte[] expected = new Byte[byteArray.length];
    for (int ¢ = 0; ¢ < byteArray.length; ++¢)
      expected[¢] = Byte.valueOf(byteArray[¢]);
    azzert.assertArrayEquals(expected, box.box(byteArray));
  }

  @Test public void charBoxingTest() {
    for (char i = Character.MIN_VALUE; i < Character.MAX_VALUE; ++i)
      azzert.assertEquals(Character.valueOf(i), box.box(i));
    azzert.assertEquals(Character.valueOf(Character.MAX_VALUE), box.box(Character.MAX_VALUE));
  }

  @Test public void charEmptyArrayBoxingTest() {
    azzert.assertArrayEquals(new Character[0], box.box(new char[0]));
  }

  @Test public void charArrayBoxingTest() {
    char[] charArray = { 1, 2, 3, 4, 5, 6, 10, 127, 128, 127, 0, 127, 50, 100, 65535, 55555 };
    Character[] expected = new Character[charArray.length];
    for (int ¢ = 0; ¢ < charArray.length; ++¢)
      expected[¢] = Character.valueOf(charArray[¢]);
    azzert.assertArrayEquals(expected, box.box(charArray));
  }

  @Test public void doubleBoxingTest() {
    azzert.assertEquals(Double.valueOf(Double.MAX_VALUE), box.box(Double.MAX_VALUE));
    azzert.assertEquals(Double.valueOf(Double.MIN_VALUE), box.box(Double.MIN_VALUE));
    azzert.assertEquals(Double.valueOf(Double.MIN_NORMAL), box.box(Double.MIN_NORMAL));
    azzert.assertEquals(Double.valueOf(0.0), box.box(0.0));
    azzert.assertEquals(Double.valueOf(Math.E), box.box(Math.E));
    azzert.assertEquals(Double.valueOf(Math.PI), box.box(Math.PI));
    azzert.assertEquals(Double.valueOf(-Math.sqrt(2)), box.box(-Math.sqrt(2)));
    azzert.assertEquals(Double.valueOf(238.0), box.box(238.0));
  }

  @Test public void doubleEmptyArrayBoxingTest() {
    azzert.assertArrayEquals(new Double[0], box.box(new double[0]));
  }

  @Test public void doubleArrayBoxingTest() {
    double[] doubleArray = { Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL, Math.E, -Math.PI, 0.0, 55555.0, Math.sqrt(2) };
    Double[] expected = new Double[doubleArray.length];
    for (int ¢ = 0; ¢ < doubleArray.length; ++¢)
      expected[¢] = Double.valueOf(doubleArray[¢]);
    azzert.assertArrayEquals(expected, box.box(doubleArray));
  }

  @Test public void floatBoxingTest() {
    azzert.assertEquals(Float.valueOf(Float.MAX_VALUE), box.box(Float.MAX_VALUE));
    azzert.assertEquals(Float.valueOf(Float.MIN_VALUE), box.box(Float.MIN_VALUE));
    azzert.assertEquals(Float.valueOf(Float.MIN_NORMAL), box.box(Float.MIN_NORMAL));
    azzert.assertEquals(Float.valueOf((float) 0.0), box.box((float) 0.0));
    azzert.assertEquals(Float.valueOf((float) Math.E), box.box((float) Math.E));
    azzert.assertEquals(Float.valueOf((float) Math.PI), box.box((float) Math.PI));
    azzert.assertEquals(Float.valueOf((float) -Math.sqrt(2)), box.box((float) -Math.sqrt(2)));
    azzert.assertEquals(Float.valueOf((float) 238.0), box.box((float) 238.0));
  }

  @Test public void floatEmptyArrayBoxingTest() {
    azzert.assertArrayEquals(new Float[0], box.box(new float[0]));
  }

  @Test public void floatArrayBoxingTest() {
    float[] floatArray = { Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_NORMAL, (float) Math.E, (float) -Math.PI, (float) 0.0, (float) Math.sqrt(2) };
    Float[] expected = new Float[floatArray.length];
    for (int ¢ = 0; ¢ < floatArray.length; ++¢)
      expected[¢] = Float.valueOf(floatArray[¢]);
    azzert.assertArrayEquals(expected, box.box(floatArray));
  }

  @Test public void intBoxingTest() {
    azzert.assertEquals(Integer.valueOf(Integer.MAX_VALUE), box.box(Integer.MAX_VALUE));
    azzert.assertEquals(Integer.valueOf(Integer.MIN_VALUE), box.box(Integer.MIN_VALUE));
    azzert.assertEquals(Integer.valueOf(0), box.box(0));
    azzert.assertEquals(Integer.valueOf(500), box.box(500));
    azzert.assertEquals(Integer.valueOf(-3), box.box(-3));
  }

  @Test public void intEmptyArrayBoxingTest() {
    azzert.assertArrayEquals(new Integer[0], box.box(new int[0]));
  }

  @Test public void intArrayBoxingTest() {
    int[] intArray = { 10, Integer.MAX_VALUE, Integer.MIN_VALUE, -127, 0, 58745, -124856, 100 };
    Integer[] expected = new Integer[intArray.length];
    for (int ¢ = 0; ¢ < intArray.length; ++¢)
      expected[¢] = Integer.valueOf(intArray[¢]);
    azzert.assertArrayEquals(expected, box.box(intArray));
  }

  @Test public void longBoxingTest() {
    azzert.assertEquals(Long.valueOf(Long.MAX_VALUE), box.box(Long.MAX_VALUE));
    azzert.assertEquals(Long.valueOf(Long.MIN_VALUE), box.box(Long.MIN_VALUE));
    azzert.assertEquals(Long.valueOf(0L), box.box(0L));
    azzert.assertEquals(Long.valueOf(500L), box.box(500L));
    azzert.assertEquals(Long.valueOf(-3L), box.box(-3L));
  }

  @Test public void longEmptyArrayBoxingTest() {
    azzert.assertArrayEquals(new Long[0], box.box(new long[0]));
  }

  @Test public void longArrayBoxingTest() {
    long[] longArray = { 10L, Long.MAX_VALUE, Long.MIN_VALUE, 0L, 58745L, -124856L, 100L };
    Long[] expected = new Long[longArray.length];
    for (int ¢ = 0; ¢ < longArray.length; ++¢)
      expected[¢] = Long.valueOf(longArray[¢]);
    azzert.assertArrayEquals(expected, box.box(longArray));
  }

  @Test public void shortBoxingTest() {
    azzert.assertEquals(Short.valueOf(Short.MAX_VALUE), box.box(Short.MAX_VALUE));
    azzert.assertEquals(Short.valueOf(Short.MIN_VALUE), box.box(Short.MIN_VALUE));
    azzert.assertEquals(Short.valueOf((short) 0), box.box((short) 0));
    azzert.assertEquals(Short.valueOf((short) 500), box.box((short) 500));
    azzert.assertEquals(Short.valueOf((short) -3), box.box((short) -3));
  }

  @Test public void shortEmptyArrayBoxingTest() {
    azzert.assertArrayEquals(new Short[0], box.box(new short[0]));
  }

  @Test public void shortArrayBoxingTest() {
    short[] shortArray = { 10, Short.MAX_VALUE, Short.MIN_VALUE, -127, 0, 100 };
    Short[] expected = new Short[shortArray.length];
    for (int ¢ = 0; ¢ < shortArray.length; ++¢)
      expected[¢] = Short.valueOf(shortArray[¢]);
    azzert.assertArrayEquals(expected, box.box(shortArray));
  }

  @Test public void booleanItTest() {
    azzert.assertEquals(Boolean.TRUE, box.it(true));
    azzert.assertEquals(Boolean.FALSE, box.it(false));
  }

  @Test public void booleanEmptyArrayItTest() {
    azzert.assertArrayEquals(new Boolean[0], box.it(new boolean[0]));
  }

  @Test public void booleanArrayItTest() {
    boolean[] boolArray = { true, true, false, false, true, false };
    Boolean[] expected = new Boolean[boolArray.length];
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
    byte[] byteArray = { 1, 2, 3, 4, 5, 6, 10, Byte.MAX_VALUE, Byte.MIN_VALUE, -127, 0, 127, 50, 100 };
    Byte[] expected = new Byte[byteArray.length];
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
    char[] charArray = { 1, 2, 3, 4, 5, 6, 10, 127, 128, 127, 0, 127, 50, 100, 65535, 55555 };
    Character[] expected = new Character[charArray.length];
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
    double[] doubleArray = { Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL, Math.E, -Math.PI, 0.0, 55555.0, Math.sqrt(2) };
    Double[] expected = new Double[doubleArray.length];
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
    float[] floatArray = { Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_NORMAL, (float) Math.E, (float) -Math.PI, (float) 0.0, (float) Math.sqrt(2) };
    Float[] expected = new Float[floatArray.length];
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
    int[] intArray = { 10, Integer.MAX_VALUE, Integer.MIN_VALUE, -127, 0, 58745, -124856, 100 };
    Integer[] expected = new Integer[intArray.length];
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
    long[] longArray = { 10L, Long.MAX_VALUE, Long.MIN_VALUE, 0L, 58745L, -124856L, 100L };
    Long[] expected = new Long[longArray.length];
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
    short[] shortArray = { 10, Short.MAX_VALUE, Short.MIN_VALUE, -127, 0, 100 };
    Short[] expected = new Short[shortArray.length];
    for (int ¢ = 0; ¢ < shortArray.length; ++¢)
      expected[¢] = Short.valueOf(shortArray[¢]);
    azzert.assertArrayEquals(expected, box.it(shortArray));
  }
}
