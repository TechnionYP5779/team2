package fluent.ly;

import static il.org.spartan.Utils.*;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;
import static fluent.ly.unbox.*;
import static fluent.ly.unbox.it;

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
    azzert.that(unbox(box(new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 })), is(new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
  }

  @Test public void unboxCharTest() {
    for (char i = 0; i < 128; ++i)
      azzert.that(unbox(cantBeNull(box(i))), is(i));
  }

  @Test public void unboxCharArrayTest() {
    azzert.that(unbox(box(new char[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 })), is(new char[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
  }

  @Test public void unboxShortCollectionTest() {
    azzert.that(unbox(cantBeNull(Arrays.asList(box(new short[] { 1, 2, 3, 4, 5 })))), is(new short[] { 1, 2, 3, 4, 5 }));
  }

  @Test public void itIntCollectionTest() {
    azzert.that(it(cantBeNull(Arrays.asList(box(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 })))), is(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
  }

  @Test public void unboxDoubleTest() {
    for (double i = -10; i < 10; i += 0.1)
      azzert.that(unbox(cantBeNull(box(i))), is(i));
  }

  @Test public void unboxDoubleArrayTest() {
    for (int ¢ = 0; ¢ < 10; ++¢)
      assert (¢ + 1) / 10.0f == unbox(box(new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1d }))[¢];
  }

  @Test public void itDoubleArrayTest() {
    for (int ¢ = 0; ¢ < 10; ++¢)
      assert (¢ + 1) / 10.0f == it(box(new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1d }))[¢];
  }

  @Test public void unboxFloatTest() {
    for (float i = -10f; i < 10; i += 0.1f)
      azzert.that(unbox(cantBeNull(box(i))), is(i));
  }

  @Test public void unboxFloatArrayTest() {
    azzert.that(unbox(box(new float[] { 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1f })),
        is(new float[] { 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1f }));
  }

  @Test public void itFloatArrayTest() {
    azzert.that(it(box(new float[] { 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1f })),
        is(new float[] { 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1f }));
  }

  @Test public void unboxIntTest() {
    for (int ¢ = -10; ¢ < 10; ++¢)
      azzert.that(unbox(cantBeNull(box(¢))), is(¢));
  }

  @Test public void unboxIntArrayTest() {
    azzert.that(unbox(box(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 })), is(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
  }

  @Test public void itIntArrayTest() {
    azzert.that(it(box(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 })), is(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
  }

  @Test public void unboxLongTest() {
    for (long ¢ = -10; ¢ < 10; ++¢)
      azzert.that(unbox(box(¢)), is(¢));
  }

  @Test public void unboxLongArrayTest() {
    azzert.that(unbox(box(new long[] { 0l, 1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l })), is(new long[] { 0l, 1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l }));
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
