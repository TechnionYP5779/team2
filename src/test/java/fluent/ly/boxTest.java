package fluent.ly;

import static fluent.ly.azzert.*;

import static fluent.ly.box.*;
import static il.org.spartan.Utils.*;
import static fluent.ly.unbox.*;

import org.junit.*;

@SuppressWarnings({ "static-method", "boxing" }) public class boxTest {
  @Test public void boxTrue() {
    assert unbox(cantBeNull(box(true)));
  }

  @Test public void boxFalse() {
    assert !unbox(cantBeNull(box(false)));
  }

  @Test public void boxEmptyBooleanArray() {
    azzert.that(new Boolean[0], is(box(new boolean[0])));
  }

  @Test public void booleanArrayBoxingTest() {
    final boolean[] boolArray = { true, true, false, false, true, false };
    final Boolean[] expected = new Boolean[] { true, true, false, false, true, false };
    azzert.that(expected, is(box(boolArray)));
  }

  @Test public void itTrue() {
    assert box.it(true);
  }

  @Test public void itFalse() {
    assert !box.it(false);
  }

  @Test public void booleanEmptyArrayItTest() {
    azzert.that(new Boolean[0], is(box.it(new boolean[0])));
  }

  @Test public void booleanArrayItTest() {
    final boolean[] boolArray = { true, true, false, false, true, false };
    final Boolean[] expected = new Boolean[] { true, true, false, false, true, false };
    azzert.that(expected, is(box.it(boolArray)));
  }

  @Test public void byteBoxingTest() {
    for (byte i = Byte.MIN_VALUE; i < Byte.MAX_VALUE; ++i)
      azzert.that(Byte.valueOf(i), is(box(i)));
    azzert.that(Byte.valueOf(Byte.MAX_VALUE), is(box(Byte.MAX_VALUE)));
  }

  @Test public void byteEmptyArrayBoxingTest() {
    azzert.that(new Byte[0], is(box(new byte[0])));
  }

  @Test public void byteArrayBoxingTest() {
    final byte[] byteArray = { 1, 2, 3, 4, 5, 6, 10, Byte.MAX_VALUE, Byte.MIN_VALUE, -127, 0, 127, 50, 100 };
    final Byte[] expected = new Byte[] { 1, 2, 3, 4, 5, 6, 10, Byte.MAX_VALUE, Byte.MIN_VALUE, -127, 0, 127, 50, 100 };
    azzert.that(expected, is(box(byteArray)));
  }

  @Test public void byteItTest() {
    for (byte i = Byte.MIN_VALUE; i < Byte.MAX_VALUE; ++i)
      azzert.that(Byte.valueOf(i), is(box.it(i)));
    azzert.that(Byte.valueOf(Byte.MAX_VALUE), is(box.it(Byte.MAX_VALUE)));
  }

  @Test public void byteEmptyArrayItTest() {
    azzert.that(new Byte[0], is(box.it(new byte[0])));
  }

  @Test public void byteArrayItTest() {
    final byte[] byteArray = { 1, 2, 3, 4, 5, 6, 10, Byte.MAX_VALUE, Byte.MIN_VALUE, -127, 0, 127, 50, 100 };
    final Byte[] expected = new Byte[] { 1, 2, 3, 4, 5, 6, 10, Byte.MAX_VALUE, Byte.MIN_VALUE, -127, 0, 127, 50, 100 };
    azzert.that(expected, is(box.it(byteArray)));
  }

  @Test public void charBoxingTest() {
    for (char i = Character.MIN_VALUE; i < Character.MAX_VALUE; ++i)
      azzert.that(Character.valueOf(i), is(box(i)));
    azzert.that(Character.valueOf(Character.MAX_VALUE), is(box(Character.MAX_VALUE)));
  }

  @Test public void charEmptyArrayBoxingTest() {
    azzert.that(new Character[0], is(box(new char[0])));
  }

  @Test public void charArrayBoxingTest() {
    final char[] charArray = { 1, 2, 3, 4, 5, 6, 10, 127, 128, 127, 0, 127, 50, 100, 65535, 55555 };
    final Character[] expected = new Character[] { 1, 2, 3, 4, 5, 6, 10, 127, 128, 127, 0, 127, 50, 100, 65535, 55555 };
    azzert.that(expected, is(box(charArray)));
  }

  @Test public void charItTest() {
    for (char i = Character.MIN_VALUE; i < Character.MAX_VALUE; ++i)
      azzert.that(Character.valueOf(i), is(box.it(i)));
    azzert.that(Character.valueOf(Character.MAX_VALUE), is(box.it(Character.MAX_VALUE)));
  }

  @Test public void charEmptyArrayItTest() {
    azzert.that(new Character[0], is(box.it(new char[0])));
  }

  @Test public void charArrayItTest() {
    final char[] charArray = { 1, 2, 3, 4, 5, 6, 10, 127, 128, 127, 0, 127, 50, 100, 65535, 55555 };
    final Character[] expected = new Character[] { 1, 2, 3, 4, 5, 6, 10, 127, 128, 127, 0, 127, 50, 100, 65535, 55555 };
    azzert.that(expected, is(box.it(charArray)));
  }

  @Test public void doubleBoxingTest() {
    final Double[] expected = new Double[] { Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL, Math.E, -Math.PI, 0.0, 55555.0, Math.sqrt(2) };
    final Double[] doubleArray = new Double[] { box(Double.MAX_VALUE), box(Double.MIN_VALUE), box(Double.MIN_NORMAL), box(Math.E), box(-Math.PI),
        box(0.0), box(55555.0), box(Math.sqrt(2)) };
    azzert.that(expected, is(doubleArray));
  }

  @Test public void doubleEmptyArrayBoxingTest() {
    azzert.that(new Double[0], is(box(new double[0])));
  }

  @Test public void doubleArrayBoxingTest() {
    final double[] doubleArray = { Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL, Math.E, -Math.PI, 0.0, 55555.0, Math.sqrt(2) };
    final Double[] expected = new Double[] { Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL, Math.E, -Math.PI, 0.0, 55555.0, Math.sqrt(2) };
    azzert.that(expected, is(box(doubleArray)));
  }

  @Test public void doubleItTest() {
    final Double[] expected = new Double[] { Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL, Math.E, -Math.PI, 0.0, 55555.0, Math.sqrt(2) };
    final Double[] doubleArray = new Double[] { box.it(Double.MAX_VALUE), box.it(Double.MIN_VALUE), box.it(Double.MIN_NORMAL), box.it(Math.E),
        box.it(-Math.PI), box.it(0.0), box.it(55555.0), box.it(Math.sqrt(2)) };
    azzert.that(expected, is(doubleArray));
  }

  @Test public void doubleEmptyArrayItTest() {
    azzert.that(new Double[0], is(box.it(new double[0])));
  }

  @Test public void doubleArrayItTest() {
    final double[] doubleArray = { Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL, Math.E, -Math.PI, 0.0, 55555.0, Math.sqrt(2) };
    final Double[] expected = new Double[] { Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL, Math.E, -Math.PI, 0.0, 55555.0, Math.sqrt(2) };
    azzert.that(expected, is(box.it(doubleArray)));
  }

  @Test public void floatBoxingTest() {
    azzert.that(Float.valueOf((float) -Math.PI), is(box((float) -Math.PI)));
  }

  @Test public void floatEmptyArrayBoxingTest() {
    azzert.that(new Float[0], is(box(new float[0])));
  }

  @Test public void floatArrayBoxingTest() {
    final float[] floatArray = { Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_NORMAL, (float) Math.E, (float) -Math.PI, (float) 0.0 };
    final Float[] expected = new Float[] { Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_NORMAL, (float) Math.E, (float) -Math.PI, (float) 0.0 };
    azzert.that(expected, is(box(floatArray)));
  }

  @Test public void floatItTest() {
    azzert.that(Float.valueOf((float) -Math.PI), is(box((float) -Math.PI)));
  }

  @Test public void floatEmptyArrayItTest() {
    azzert.that(new Float[0], is(box.it(new float[0])));
  }

  @Test public void floatArrayItTest() {
    final float[] floatArray = { Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_NORMAL, (float) Math.E, (float) -Math.PI, (float) 0.0 };
    final Float[] expected = new Float[] { Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_NORMAL, (float) Math.E, (float) -Math.PI, (float) 0.0 };
    azzert.that(expected, is(box.it(floatArray)));
  }

  @Test public void intBoxingTest() {
    azzert.that(Integer.valueOf(Integer.MAX_VALUE), is(box(Integer.MAX_VALUE)));
    azzert.that(Integer.valueOf(Integer.MIN_VALUE), is(box(Integer.MIN_VALUE)));
  }

  @Test public void intEmptyArrayBoxingTest() {
    azzert.that(new Integer[0], is(box(new int[0])));
  }

  @Test public void intArrayBoxingTest() {
    final int[] intArray = { 10, Integer.MAX_VALUE, Integer.MIN_VALUE, -127, 0, 58745, -124856, 100 };
    final Integer[] expected = new Integer[] { 10, Integer.MAX_VALUE, Integer.MIN_VALUE, -127, 0, 58745, -124856, 100 };
    azzert.that(expected, is(box(intArray)));
  }

  @Test public void intItTest() {
    azzert.that(Integer.valueOf(Integer.MAX_VALUE), is(box.it(Integer.MAX_VALUE)));
    azzert.that(Integer.valueOf(Integer.MIN_VALUE), is(box.it(Integer.MIN_VALUE)));
  }

  @Test public void intEmptyArrayItTest() {
    azzert.that(new Integer[0], is(box.it(new int[0])));
  }

  @Test public void intArrayItTest() {
    final int[] intArray = { 10, Integer.MAX_VALUE, Integer.MIN_VALUE, -127, 0, 58745, -124856, 100 };
    final Integer[] expected = new Integer[] { 10, Integer.MAX_VALUE, Integer.MIN_VALUE, -127, 0, 58745, -124856, 100 };
    azzert.that(expected, is(box.it(intArray)));
  }

  @Test public void longBoxingTest() {
    azzert.that(Long.valueOf(Long.MAX_VALUE), is(box(Long.MAX_VALUE)));
    azzert.that(Long.valueOf(Long.MIN_VALUE), is(box(Long.MIN_VALUE)));
  }

  @Test public void longEmptyArrayBoxingTest() {
    azzert.that(new Long[0], is(box(new long[0])));
  }

  @Test public void longArrayBoxingTest() {
    final long[] longArray = { 10L, Long.MAX_VALUE, Long.MIN_VALUE, 0L, 58745L, -124856L, 100L };
    final Long[] expected = new Long[] { 10L, Long.MAX_VALUE, Long.MIN_VALUE, 0L, 58745L, -124856L, 100L };
    azzert.that(expected, is(box(longArray)));
  }

  @Test public void longItTest() {
    azzert.that(Long.valueOf(Long.MAX_VALUE), is(box.it(Long.MAX_VALUE)));
    azzert.that(Long.valueOf(Long.MIN_VALUE), is(box.it(Long.MIN_VALUE)));
  }

  @Test public void longEmptyArrayItTest() {
    azzert.that(new Long[0], is(box.it(new long[0])));
  }

  @Test public void longArrayItTest() {
    final long[] longArray = { 10L, Long.MAX_VALUE, Long.MIN_VALUE, 0L, 58745L, -124856L, 100L };
    final Long[] expected = new Long[] { 10L, Long.MAX_VALUE, Long.MIN_VALUE, 0L, 58745L, -124856L, 100L };
    azzert.that(expected, is(box.it(longArray)));
  }

  @Test public void shortBoxingTest() {
    azzert.that(Short.valueOf(Short.MAX_VALUE), is(box(Short.MAX_VALUE)));
    azzert.that(Short.valueOf(Short.MIN_VALUE), is(box(Short.MIN_VALUE)));
  }

  @Test public void shortEmptyArrayBoxingTest() {
    azzert.that(new Short[0], is(box(new short[0])));
  }

  @Test public void shortArrayBoxingTest() {
    final short[] shortArray = { 10, Short.MAX_VALUE, Short.MIN_VALUE, -127, 0, 100 };
    final Short[] expected = new Short[] { 10, Short.MAX_VALUE, Short.MIN_VALUE, -127, 0, 100 };
    azzert.that(expected, is(box(shortArray)));
  }

  @Test public void shortItTest() {
    azzert.that(Short.valueOf(Short.MAX_VALUE), is(box.it(Short.MAX_VALUE)));
    azzert.that(Short.valueOf(Short.MIN_VALUE), is(box.it(Short.MIN_VALUE)));
  }

  @Test public void shortEmptyArrayItTest() {
    azzert.that(new Short[0], is(box.it(new short[0])));
  }

  @Test public void shortArrayItTest() {
    final short[] shortArray = { 10, Short.MAX_VALUE, Short.MIN_VALUE, -127, 0, 100 };
    final Short[] expected = new Short[] { 10, Short.MAX_VALUE, Short.MIN_VALUE, -127, 0, 100 };
    azzert.that(expected, is(box.it(shortArray)));
  }
}
