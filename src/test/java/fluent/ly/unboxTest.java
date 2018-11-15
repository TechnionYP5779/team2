package fluent.ly;

import static org.junit.Assert.assertEquals;

import static fluent.ly.azzert.assertEquals;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class unboxTest {
  @Test @SuppressWarnings("null") public void itIntTest() {
    for (int ¢ = -100; ¢ < 100; ++¢)
      assertEquals(unbox.it(Integer.valueOf(¢)), ¢);
  }

  @Test @SuppressWarnings("null") public void unboxBoolTest() {
    assertEquals(unbox.unbox(Boolean.TRUE), true);
    assertEquals(unbox.unbox(Boolean.FALSE), false);
  }

  @Test public void unboxBoolArrayTest() {
    @SuppressWarnings("null") final boolean newArr[] = unbox
        .unbox(new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE });
    for (int ¢ = 0; ¢ < 5; ++¢)
      assert newArr[¢];
  }

  @Test @SuppressWarnings("null") public void unboxByteTest() {
    for (byte i = -100; i < 100; ++i)
      assertEquals(unbox.unbox(Byte.valueOf(i)), i);
  }

  @Test public void unboxByteArrayTest() {
    @SuppressWarnings({ "null", "boxing" }) final byte newArr[] = unbox.unbox(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
    for (int ¢ = 0; ¢ < 10; ++¢)
      assertEquals(¢ + 1, newArr[¢]);
  }

  @Test @SuppressWarnings("null") public void unboxCharTest() {
    for (char i = 0; i < 128; ++i)
      assertEquals(unbox.unbox(Character.valueOf(i)), i);
  }

  @Test public void unboxCharArrayTest() {
    @SuppressWarnings({ "null", "boxing" }) final char newArr[] = unbox.unbox(new Character[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
    for (int ¢ = 0; ¢ < 10; ++¢)
      assertEquals(¢ + 1, newArr[¢]);
  }

  @Test public void unboxShortCollectionTest() {
    @SuppressWarnings({ "null", "boxing" }) final short newArr[] = unbox.unbox(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
    for (int ¢ = 0; ¢ < 5; ++¢)
      assertEquals(¢ + 1, newArr[¢]);
  }

  @Test public void itIntCollectionTest() {
    @SuppressWarnings({ "null", "boxing" }) final int newArr[] = unbox.it(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    for (int ¢ = 0; ¢ < 10; ++¢)
      assertEquals(¢, newArr[¢]);
  }

  @Test @SuppressWarnings("null") public void unboxDoubleTest() {
    for (double i = -10; i < 10; i += 0.1)
      assert unbox.unbox(Double.valueOf(i)) == i;
  }

  @Test public void unboxDoubleArrayTest() {
    @SuppressWarnings({ "null", "boxing" }) final double newArr[] = unbox.unbox(new Double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1d });
    for (int ¢ = 0; ¢ < 10; ++¢)
      assert (¢ + 1) / 10.0f == newArr[¢];
  }

  @Test public void itDoubleArrayTest() {
    @SuppressWarnings({ "null", "boxing" }) final double newArr[] = unbox.it(new Double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1d });
    for (int ¢ = 0; ¢ < 10; ++¢)
      assert (¢ + 1) / 10.0f == newArr[¢];
  }

  @Test @SuppressWarnings("null") public void unboxFloatTest() {
    for (float i = -10f; i < 10; i += 0.1f)
      assert unbox.unbox(Float.valueOf(i)) == i;
  }

  @Test public void unboxFloatArrayTest() {
    @SuppressWarnings("boxing") final float newArr[] = unbox.unbox(new Float[] { 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1f });
    for (int ¢ = 0; ¢ < 10; ++¢)
      assert (¢ + 1) / 10.0f == newArr[¢];
  }

  @Test public void itFloatArrayTest() {
    @SuppressWarnings("boxing") final float newArr[] = unbox.it(new Float[] { 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1f });
    for (int ¢ = 0; ¢ < 10; ++¢)
      assert (¢ + 1) / 10.0f == newArr[¢];
  }

  @Test @SuppressWarnings("null") public void unboxIntTest() {
    for (int ¢ = -10; ¢ < 10; ++¢)
      assertEquals(unbox.unbox(Integer.valueOf(¢)), ¢);
  }

  @Test public void unboxIntArrayTest() {
    @SuppressWarnings({ "boxing", "null" }) final int newArr[] = unbox.unbox(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
    for (int ¢ = 0; ¢ < 10; ++¢)
      assertEquals(¢, newArr[¢]);
  }

  @Test public void itIntArrayTest() {
    @SuppressWarnings({ "boxing", "null" }) final int newArr[] = unbox.it(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
    for (int ¢ = 0; ¢ < 10; ++¢)
      assertEquals(¢, newArr[¢]);
  }

  @Test @SuppressWarnings("null") public void unboxLongTest() {
    for (long ¢ = -10; ¢ < 10; ++¢)
      assertEquals(unbox.unbox(Long.valueOf(¢)), ¢);
  }

  @Test public void unboxLongArrayTest() {
    @SuppressWarnings({ "boxing", "null" }) final long newArr[] = unbox.unbox(new Long[] { 0l, 1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l });
    for (int ¢ = 0; ¢ < 10; ++¢)
      assertEquals(¢, newArr[¢]);
  }

  @Test @SuppressWarnings("null") public void unboxShortTest() {
    for (short ¢ = -10; ¢ < 10; ++¢)
      assertEquals(unbox.unbox(Short.valueOf(¢)), ¢);
  }

  @Test public void unboxShortArrayTest() {
    @SuppressWarnings({ "boxing", "null" }) final short newArr[] = unbox
        .unbox(new Short[] { (short) 0, (short) 1, (short) 2, (short) 3, (short) 4, (short) 5 });
    for (int ¢ = 0; ¢ < 6; ++¢)
      assertEquals(¢, newArr[¢]);
  }
}
