package fluent.ly;

import static il.org.spartan.Utils.*;

import static fluent.ly.azzert.*;
import static fluent.ly.box.box;
import static fluent.ly.unbox.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class unboxTest {
  @Test public void itIntTest() {
    for (int ¢ = -100; ¢ < 100; ++¢)
      azzert.that(it(cantBeNull(box(¢))), is(¢));
  }

  @Test public void unboxBoolTest() {
    assert unbox(cantBeNull(Boolean.TRUE));
    assert !unbox(cantBeNull(Boolean.FALSE));
  }

  @Test public void unboxBoolArrayTest() {
    final boolean newArr[] = unbox(box(new boolean[] { true, true, true, true, true }));
    for (int ¢ = 0; ¢ < 5; ++¢)
      assert newArr[¢];
  }

  @Test public void unboxByteTest() {
    for (byte i = -100; i < 100; ++i)
      azzert.that(unbox(box(i)), is(i));
  }

  @Test public void unboxByteArrayTest() {
    final byte newArr[] = unbox(box(new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
    azzert.that(newArr, is(new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
  }

  @Test public void unboxCharTest() {
    for (char i = 0; i < 128; ++i)
      azzert.that(unbox(cantBeNull(box(i))), is(i));
  }

  @Test public void unboxCharArrayTest() {
    final char newArr[] = unbox(box(new char[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
    azzert.that(newArr, is(new char[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
  }

  @Test public void unboxShortCollectionTest() {
    final short newArr[] = unbox(cantBeNull(Arrays.asList(box(new short[] { 1, 2, 3, 4, 5 }))));
    azzert.that(newArr, is(new short[] { 1, 2, 3, 4, 5 }));
  }

  @Test public void itIntCollectionTest() {
    final int newArr[] = it(cantBeNull(Arrays.asList(box(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }))));
    azzert.that(newArr, is(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
  }

  @Test public void unboxDoubleTest() {
    for (double i = -10; i < 10; i += 0.1)
      azzert.that(unbox(cantBeNull(box(i))), is(i));
  }

  @Test public void unboxDoubleArrayTest() {
    final double newArr[] = unbox(box(new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1d }));
    for (int ¢ = 0; ¢ < 10; ++¢)
      assert (¢ + 1) / 10.0f == newArr[¢];
  }

  @Test public void itDoubleArrayTest() {
    final double newArr[] = it(box(new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1d }));
    for (int ¢ = 0; ¢ < 10; ++¢)
      assert (¢ + 1) / 10.0f == newArr[¢];
  }

  @Test public void unboxFloatTest() {
    for (float i = -10f; i < 10; i += 0.1f)
      azzert.that(unbox(cantBeNull(box(i))), is(i));
  }

  @Test public void unboxFloatArrayTest() {
    final float newArr[] = unbox(box(new float[] { 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1f }));
    azzert.that(newArr, is(new float[] { 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1f }));
  }

  @Test public void itFloatArrayTest() {
    final float newArr[] = it(box(new float[] { 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1f }));
    azzert.that(newArr, is(new float[] { 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1f }));
  }

  @Test public void unboxIntTest() {
    for (int ¢ = -10; ¢ < 10; ++¢)
      azzert.that(unbox(cantBeNull(box(¢))), is(¢));
  }

  @Test public void unboxIntArrayTest() {
    final int newArr[] = unbox(box(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
    azzert.that(newArr, is(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
  }

  @Test public void itIntArrayTest() {
    final int newArr[] = it(box(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
    azzert.that(newArr, is(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
  }

  @Test public void unboxLongTest() {
    for (long ¢ = -10; ¢ < 10; ++¢)
      azzert.that(unbox(box(¢)), is(¢));
  }

  @Test public void unboxLongArrayTest() {
    final long newArr[] = unbox(box(new long[] { 0l, 1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l }));
    azzert.that(newArr, is(new long[] { 0l, 1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l }));
  }

  @Test public void unboxShortTest() {
    for (short ¢ = -10; ¢ < 10; ++¢)
      azzert.that(unbox(cantBeNull(box(¢))), is(¢));
  }

  @Test public void unboxShortArrayTest() {
    final short newArr[] = unbox(box(new short[] { 0, 1, 2, 3, 4, 5 }));
    for (int ¢ = 0; ¢ < 6; ++¢)
      azzert.that(newArr, is(new short[] { 0, 1, 2, 3, 4, 5 }));
  }
}
