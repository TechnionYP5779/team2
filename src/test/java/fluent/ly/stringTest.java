package fluent.ly;

import java.io.*;
import java.util.*;

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
  @Test public void testfill1() {
    azzert.assertEquals(string.fill(5,'a'),"aaaaa");
  }
  @Test public void testfill2() {
    azzert.assertEquals(string.fill(5,"ab"),"ababababab");
  }
  @Test public void testfirst() {
    azzert.assertEquals(string.first("abcde"),'a');
  }
  @Test public void testftoa() {
    azzert.assertEquals(string.ftoa(5.42342f),"5.42342");
  }
  @Test public void testIsDouble1() {
    azzert.assertTrue(string.isDouble("5.42342"));
  }
  @Test public void testIsDouble2() {
    azzert.assertFalse(string.isDouble("not double"));
  }
  @Test public void testIsFloat1() {
    azzert.assertTrue(string.isFloat("5.42342"));
  }
  @Test public void testIsFloat2() {
    azzert.assertFalse(string.isFloat("not float"));
  }
  @Test public void testIsInt1() {
    azzert.assertTrue(string.isInt("5"));
  }
  @Test public void testIsInt2() {
    azzert.assertFalse(string.isInt("5.243"));
  }
  @Test public void testIsLong1() {
    azzert.assertTrue(string.isLong("42342343423425"));
  }
  @Test public void testIsLong2() {
    azzert.assertFalse(string.isLong("5.243"));
  }
  @Test public void testitoa() {
    azzert.assertEquals(string.itoa(5),"5");
  }
  @Test public void testJavaCase1() {
    azzert.assertEquals(string.javaCase(""),"");
  }
  @Test public void testJavaCase2() {
    azzert.assertEquals(string.javaCase("Hello"),"hello");
  }
  @Test public void testLast() {
    azzert.assertEquals(string.last("Hello"),'o');
  }
  @Test public void testLowCounter1() {
    azzert.assertEquals(string.lowCounter(-1),"");
  }
  @Test public void testLowCounter2() {
    azzert.assertEquals(string.lowCounter(0),"a");
  }
  @Test public void testLowCounter3() {
    azzert.assertEquals(string.lowCounter(1),"b");
  }
  @Test public void testLtoa() {
    azzert.assertEquals(string.ltoa(123456789),"123456789");
  }
  @Test public void testOrdinal1() {
    azzert.assertEquals(string.ordinal(1),"1st");
  }
  @Test public void testOrdinal2() {
    azzert.assertEquals(string.ordinal(11),"11th");
  }
  @Test public void testOrdinal3() {
    azzert.assertEquals(string.ordinal(2),"2nd");
  }
  @Test public void testOrdinal4() {
    azzert.assertEquals(string.ordinal(12),"12th");
  }
  @Test public void testOrdinal5() {
    azzert.assertEquals(string.ordinal(13),"13th");
  }
  @Test public void testParen() {
    azzert.assertEquals(string.paren("hello"),"(hello)");
  }
  @Test public void testPluralize0() {
    azzert.assertEquals(string.pluralize(0,"apple"),"no apples");
  }
  @Test public void testPluralize1() {
    azzert.assertEquals(string.pluralize(1,"apple"),"apple");
  }
  @Test public void testPluralize2() {
    azzert.assertEquals(string.pluralize(2,"apple"),"two apples");
  }
  @Test public void testPluralize3() {
    azzert.assertEquals(string.pluralize(3,"apple"),"three apples");
  }
  @Test public void testPluralize4() {
    azzert.assertEquals(string.pluralize(4,"apple"),"four apples");
  }
  @Test public void testPluralize5() {
    azzert.assertEquals(string.pluralize(5,"apple"),"five apples");
  }
  @Test public void testPluralize6() {
    azzert.assertEquals(string.pluralize(6,"apple"),"six apples");
  }
  @Test public void testPluralize7() {
    azzert.assertEquals(string.pluralize(7,"apple"),"seven apples");
  }
  @Test public void testPluralize8() {
    azzert.assertEquals(string.pluralize(8,"apple"),"eight apples");
  }
  @Test public void testPluralize9() {
    azzert.assertEquals(string.pluralize(9,"apple"),"nine apples");
  }
  @Test public void testPluralize10() {
    azzert.assertEquals(string.pluralize(10,"apple"),"10 apples");
  }
  @SuppressWarnings("null") @Test public void testPretty1() {
    azzert.assertEquals(string.pretty("apple",null),"");
  }
  @Test public void testPretty2() {
    azzert.assertEquals(string.pretty("apple",new ArrayList<Integer>()),"");
  }
  @Test public void testPretty3() {
    azzert.assertEquals(string.pretty("apple",new ArrayList<>(Arrays.asList(box.it(1)))),"1 apple: 1\n");
  }
  @Test public void testPretty4() {
    azzert.assertEquals(string.pretty("apple",new ArrayList<>(Arrays.asList(box.it(1),box.it(2)))),"2 apples:\n\t1) 1\n\t2) 2\n");
  }
  @Test public void testPretty5() {    
    azzert.assertEquals(string.pretty("apple"
        ,new ArrayList<>(Arrays.asList(box.it(1),box.it(2),box.it(3),box.it(4),box.it(5),box.it(6),box.it(7)
            ,box.it(8),box.it(9),box.it(10),box.it(11),box.it(12),box.it(13),box.it(14),box.it(15),box.it(16)
            ,box.it(17),box.it(18),box.it(19),box.it(20),box.it(21),box.it(22),box.it(23),box.it(24),box.it(25)
            ,box.it(26),box.it(27),box.it(28),box.it(29),box.it(30),box.it(31))))
        ,"31 apples:\n\t1) 1\n\t2) 2\n\t3) 3\n\t4) 4\n\t5) 5\n\t6) 6\n\t7) 7\n\t8) 8\n\t9) 9\n\t10) 10\n"
        +"\t11) 11\n\t12) 12\n\t13) 13\n\t14) 14\n\t15) 15\n\t16) 16\n\t17) 17\n\t18) 18\n\t19) 19\n\t20) 20\n"
        + "\t...\n\t22) 22\n\t23) 23\n\t24) 24\n\t25) 25\n\t26) 26\n\t27) 27\n\t28) 28\n\t29) 29\n\t30) 30\n\t31) 31\n");
  }
  @Test public void testQuote() {
    azzert.assertEquals(string.quote("apple"),"\'apple\'");
  }
  @Test public void testRepeat() {
    azzert.assertEquals(string.repeat(2,'a'),"aa");
  }
  @Test public void testSignum1() {
    azzert.assertEquals(string.signum(0),0);
  }
  @Test public void testSignum2() {
    azzert.assertEquals(string.signum(1),1);
  }
  @Test public void testSignum3() {
    azzert.assertEquals(string.signum(-1),-1);
  }
  @Test public void testSprintf1() {
    azzert.assertEquals(string.sprintf("%d",box.it(3)),"3");
  }
  @SuppressWarnings("null") @Test public void testSprintf2() {
    azzert.assertEquals(string.sprintf(new String[] {}),"");
  }
  @SuppressWarnings("null") @Test public void testSprintf3() {
    azzert.assertEquals(string.sprintf(new String[] {"1"}),"1");
  }
  @SuppressWarnings("null") @Test public void testSprintf4() {
    azzert.assertEquals(string.sprintf(new String[] {"%s","2"}),"2");
  }
  @Test(expected = RuntimeException.class) public void testStrip1() {
    azzert.assertEquals(string.strip(""),"");
  }
  @Test public void testStrip2() {
    azzert.assertEquals(string.strip("123"),"2");
  }
  @Test public void testToLines() throws IOException {    
    azzert.assertEquals(string.toLines("1\n2\n3\n"),new ArrayList<>(Arrays.asList("1","2","3")));
  }
  @Test public void testUpCounter1() {    
    azzert.assertEquals(string.upCounter(-1),"");
  }
  @Test public void testUpCounter2() {    
    azzert.assertEquals(string.upCounter(0),"A");
  }
  @Test public void testUpCounter3() {    
    azzert.assertEquals(string.upCounter(1),"B");
  }
  @Test public void testVisualize() {  
    azzert.assertEquals(string.visualize("hello world\n"),"hellosworld\\n");
  }
  @Test public void testWrap() {  
    azzert.assertEquals(string.wrap("1","2"),"121");
  }
}
