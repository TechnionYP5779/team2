package fluent.ly;

import org.junit.*;

@SuppressWarnings({"static-access","static-method"})
public class stringTest {
  @Test public void testAtod() {
    azzert.assertEquals(string.atod("5.534534534"),5.534534534,0.00001);
  }
  @Test public void testAtof() {
    azzert.assertEquals(string.atof("5.534534534"),5.534534534f,0.00001f);
  }
  @Test public void testAtoi() {
    azzert.assertEquals(string.atoi("5"),5);
  }
  @Test public void testAtol() {
    azzert.assertEquals(string.atol("5234234234234234"),5234234234234234l);
  }
  @Test public void testCapitelize() {
    azzert.assertEquals(string.capitalize("capital"),"Capital");
  }
  @Test public void testEmptyCapitelize() {
    azzert.assertEquals(string.capitalize(""),"");
  }
  @Test public void testCat1() {
    azzert.assertEquals(string.cat("a","b","c","d","e"),"abcde");
  }
  @SuppressWarnings("null") @Test public void testCat2() {
    azzert.assertEquals(string.cat(new String[]{"a","b","c"}, new String[] {"d","e"}),"abcde");
  }
  @Test public void testDelta1() {
    azzert.assertEquals(string.delta(12,12),0,0);
  }
  @Test public void testDelta2() {
    azzert.assertEquals(string.delta(12,-11), Double.NaN,0);
  }
  @Test public void testDelta3() {
    azzert.assertEquals(string.delta(1,2),2.0/3,0);
  }
  @Test public void testDtoa() {
    azzert.assertEquals(string.dtoa(5.534534534),"5.534534534");
  } 
  @Test public void testEq1() {
    azzert.assertTrue(string.eq(box.it(5),box.it(5)));
  }
  @Test public void testEq2() {
    azzert.assertFalse(string.eq(box.it(6),box.it(5)));
  }
  @Test public void testEq3() {
    azzert.assertTrue(string.eq(null,null));
  }
  @Test public void testEq4() {
    azzert.assertFalse(string.eq(null,box.it(6)));
  }
  @Test public void testEsc1() {
    azzert.assertEquals(string.esc('\n'),"\\n");
  }
  @Test public void testEsc2() {
    azzert.assertEquals(string.esc('\r'),"\\r");
  }
  @Test public void testEsc3() {
    azzert.assertEquals(string.esc('\t'),"\\t");
  }
  @Test public void testEsc4() {
    azzert.assertEquals(string.esc('\f'),"\\f");
  }
  @Test public void testEsc5() {
    azzert.assertEquals(string.esc('\b'),"\\b");
  }
  @Test public void testEsc6() {
    azzert.assertEquals(string.esc('\\'),"\\\\");
  }
  @Test public void testEsc7() {
    azzert.assertEquals(string.esc('x'),"x");
  }
  @Test public void testEsc8() {
    azzert.assertEquals(string.esc(null),"(null)");
  }
  @Test public void testEsc9() {
    azzert.assertEquals(string.esc("hello world\n"),"hello world\\n");
  }
  @Test public void testexpandLeadingTabs1() {
    azzert.assertEquals(string.expandLeadingTabs("\thello world"),"    hello world");
  }
  @Test public void testexpandLeadingTabs2() {
   
  }
}
