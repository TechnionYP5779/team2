package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class unboxTest {
  @Test @SuppressWarnings("null") public void itIntTest() {
    for (int ¢ = -100; ¢ < 100; ++¢)
      Assert.assertEquals(unbox.it(Integer.valueOf(¢)), ¢);
  }

  @Test @SuppressWarnings({ "boxing", "null" }) public void unboxBoolTest() {
    Boolean x = Boolean.TRUE;
    Assert.assertEquals(unbox.unbox(x), true);
    x = Boolean.FALSE;
    Assert.assertEquals(unbox.unbox(x), false);
  }

  @Test @SuppressWarnings("boxing") public void unboxBoolArrayTest() {
    Boolean[] arr = new Boolean[10];
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      arr[¢] = Boolean.TRUE;
    @SuppressWarnings("null") boolean newArr[] = unbox.unbox(arr);
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      Assert.assertEquals(arr[¢], newArr[¢]);
  }

  @Test @SuppressWarnings("null") public void unboxByteTest() {
    for (byte i = -100; i < 100; ++i)
      Assert.assertEquals(unbox.unbox(Byte.valueOf(i)), i);
  }

  @Test public void unboxByteArrayTest() {
    Byte[] arr = new Byte[10];
    for (byte i = 0; i < arr.length; ++i)
      arr[i] = Byte.valueOf(i);
    @SuppressWarnings("null") byte newArr[] = unbox.unbox(arr);
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      Assert.assertEquals(arr[¢].byteValue(), newArr[¢]);
  }

  @Test @SuppressWarnings("null") public void unboxCharTest() {
    for (char i = 0; i < 128; ++i)
      Assert.assertEquals(unbox.unbox(Character.valueOf(i)), i);
  }

  @Test public void unboxCharArrayTest() {
    Character[] arr = new Character[128];
    for (char i = 0; i < arr.length; ++i)
      arr[i] = Character.valueOf(i);
    @SuppressWarnings("null") char newArr[] = unbox.unbox(arr);
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      Assert.assertEquals(arr[¢].charValue(), newArr[¢]);
  }
}
