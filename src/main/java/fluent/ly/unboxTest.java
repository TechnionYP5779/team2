package fluent.ly;

import org.junit.*;

public class unboxTest {
  @Test @SuppressWarnings("static-method")public void itIntTest() {
    for(int i=-100;i<100;i++) {
      Integer x = new Integer(i);
      Assert.assertEquals(unbox.it(x),i);
    }
  }
  
  @SuppressWarnings({ "boxing", "static-method" }) @Test public void unboxBoolTest() {
     Boolean x = new Boolean(true);
     Assert.assertEquals(unbox.unbox(x),true);
     x = new Boolean(false);
     Assert.assertEquals(unbox.unbox(x),false);
  }
  
  @SuppressWarnings({ "boxing", "static-method" }) @Test public void unboxBoolArrayTest() {
    Boolean [] arr = new Boolean[10];
    for(int i=0; i < arr.length ; i++) {
      arr[i] = new Boolean(true);
    }
    @SuppressWarnings("null") boolean newArr[] = unbox.unbox(arr);
    for(int i=0; i < arr.length ; i++) {
      Assert.assertEquals(arr[i],newArr[i]);
    }
 }
  
  @Test @SuppressWarnings("static-method")public void unboxByteTest() {
    for(byte i=-100;i<100;i++) {
      Byte x = new Byte(i);
      Assert.assertEquals(unbox.unbox(x),i);
    }
  }
  
  @SuppressWarnings({ "static-method" }) @Test public void unboxByteArrayTest() {
    Byte [] arr = new Byte[10];
    for(byte i=0; i < arr.length ; i++) {
      arr[i] = new Byte(i);
    }
    @SuppressWarnings("null") byte newArr[] = unbox.unbox(arr);
    for(int i=0; i < arr.length ; i++) {
      Assert.assertEquals(arr[i].byteValue(),newArr[i]);
    }
 }
  
  @Test @SuppressWarnings("static-method")public void unboxCharTest() {
    for(char i=0;i<128;i++) {
      Character x = new Character(i);
      Assert.assertEquals(unbox.unbox(x),i);
    }
  }
  
  @SuppressWarnings({ "static-method" }) @Test public void unboxCharArrayTest() {
    Character [] arr = new Character[128];
    for(char i=0; i < arr.length ; i++) {
      arr[i] = new Character(i);
    }
    @SuppressWarnings("null") char newArr[] = unbox.unbox(arr);
    for(int i=0; i < arr.length ; i++) {
      Assert.assertEquals(arr[i].charValue(),newArr[i]);
    }
 }
  
}
