package fluent.ly;

import java.util.*;

import org.junit.*;

public class asTest {
  @Test @SuppressWarnings({ "null", "static-method", "boxing" }) public void asIterableTest() {
    int[] res = new int[] { 1, 2, 3, 2, 4, 6, 3, 6, 9, 4, 8, 12, 5, 10, 15 };
    int i = 0;
    for (Integer f : as.asIterable(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5)))
      for (Integer p : as.asIterable(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)))
        azzert.assertEquals(f * p, res[i++]);
    i = 0;
    for (Integer f : as.asIterableLambda(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5)))
      for (Integer p : as.asIterableLambda(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)))
        azzert.assertEquals(f * p, res[i++]);
  }
  
  @Test @SuppressWarnings({ "static-method", "boxing" }) public void bitTest() {
    azzert.assertEquals(as.bit(true), 1);
    azzert.assertEquals(as.bit(false), 0);
    int x = 5;
    float y = 0.05f;
    azzert.assertEquals(as.bit(x), 1);
    azzert.assertEquals(as.bit(y), 1);
    azzert.assertEquals(as.bit(null), 0);
  }
  
  @Test @SuppressWarnings({ "static-method", "boxing" }) public void listTest() {
    //intergerList:
    List<Integer> lst1 = as.ingeterList(-1, -2, -3);
    azzert.assertEquals(lst1.get(0), -1);
    azzert.assertEquals(lst1.get(1), -2);
    azzert.assertEquals(lst1.get(2), -3);
    List<Integer> lst2 = as.ingeterList(1, 2, 3, 4, 5, 6);
    azzert.assertEquals(lst2.get(0), 1);
    azzert.assertEquals(lst2.get(1), 2);
    azzert.assertEquals(lst2.get(2), 3);
    azzert.assertEquals(lst2.get(3), 4);
    azzert.assertEquals(lst2.get(4), 5);
    azzert.assertEquals(lst2.get(5), 6);
    azzert.assertEquals(as.ingeterList().isEmpty(), true);
    
    //list:
    List<Integer> lst4 = as.list(-1, -2, -3);
    azzert.assertEquals(lst4.get(0), -1);
    azzert.assertEquals(lst4.get(1), -2);
    azzert.assertEquals(lst4.get(2), -3);
    List<Integer> lst5 = as.list(1, 2, 3, 4, 5, 6);
    azzert.assertEquals(lst5.get(0), 1);
    azzert.assertEquals(lst5.get(1), 2);
    azzert.assertEquals(lst5.get(2), 3);
    azzert.assertEquals(lst5.get(3), 4);
    azzert.assertEquals(lst5.get(4), 5);
    azzert.assertEquals(lst5.get(5), 6);
    
    //list-generic:
    List<String> lst6 = as.list("a", "abc", "test");
    azzert.assertEquals("a".equals(lst6.get(0)), true);
    azzert.assertEquals("b".equals(lst6.get(0)), false);
    azzert.assertEquals("abc".equals(lst6.get(1)), true);
    azzert.assertEquals("axc".equals(lst6.get(1)), false);
    azzert.assertEquals("abd".equals(lst6.get(1)), false);
    azzert.assertEquals("test".equals(lst6.get(2)), true);
    azzert.assertEquals("tast".equals(lst6.get(2)), false);
    
    List<Boolean> lst7 = as.list(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE);
    azzert.assertEquals(lst7.get(0), true);
    azzert.assertEquals(lst7.get(1), false);
    azzert.assertEquals(lst7.get(2), false);
    azzert.assertEquals(lst7.get(3), true);
    azzert.assertEquals(lst7.get(4), false);
    azzert.assertEquals(lst7.get(5), true);

    ArrayList<Integer> al = new ArrayList<>();
    for(int ¢ = 0; ¢ < 10; ++¢)
      al.add(¢ + 1);
    List<Integer> al_lst = as.list(al);
    for(int ¢ = 0; ¢ < 10; ++¢)
      azzert.assertEquals(al_lst.get(¢), ¢ + 1);
  }
  
  @Test @SuppressWarnings("static-method") public void intArrayTest() {
    int[] array1 = as.intArray(1, 2, 3, 4, 5, 6);
    for(int ¢ = 0; ¢ < 6; ++¢)
      azzert.assertEquals(array1[¢], ¢ + 1);
    
    int[] array2 = as.intArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    for(int ¢ = 0; ¢ < 10; ++¢)
      azzert.assertEquals(array2[¢], ¢ + 1);
    
    @SuppressWarnings("null") int[] array3 = as.intArray(as.list(1, 2, 3, 4, 5, 6, 7));
    for(int ¢ = 0; ¢ < 7; ++¢)
      azzert.assertEquals(array3[¢], ¢ + 1);
    
    @SuppressWarnings("null") int[] array4 = as.intArray(as.list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
    for(int ¢ = 0; ¢ < 11; ++¢)
      azzert.assertEquals(array4[¢], ¢ + 1);
  }
  
  /*
  @Test @SuppressWarnings("static-method") public void iteratorTest() {
    
  }
  */
  
  @Test @SuppressWarnings({ "static-method", "boxing", "null" }) public void setTest() {
    @SuppressWarnings("unchecked") Set<Integer> s1 = (Set<Integer>) as.set(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    for(int ¢ = 0; ¢ < 10; ++¢) {
      azzert.assertContains(s1, ¢ + 1);
      azzert.assertNotContains(s1, 500 * ¢);
    }
    
    @SuppressWarnings("unchecked") Set<String> s2 = (Set<String>) as.set("abcdefg", "hijklmnop", "qrstuv", "wxyz");
    azzert.assertContains(s2, "abcdefg");
    azzert.assertNotContains(s2, "lkgfnf");
    azzert.assertContains(s2, "hijklmnop");
    azzert.assertNotContains(s2, "ertyuvbnm");
    azzert.assertContains(s2, "qrstuv");
    azzert.assertNotContains(s2, "543asdfnlj");
    azzert.assertContains(s2, "wxyz");
    azzert.assertNotContains(s2, "asdasd");
    
    @SuppressWarnings("unchecked") Set<Boolean> s3 = (Set<Boolean>) as.set(true, false, true, true, false, false);
    azzert.assertContains(s3, true);
    azzert.assertContains(s3, false);
    
    @SuppressWarnings("unchecked") Set<Boolean> s4 = (Set<Boolean>) as.set(true, true, true, true);
    azzert.assertContains(s4, true);
    azzert.assertNotContains(s4, false);
    
    @SuppressWarnings("unchecked") Set<Boolean> s5 = (Set<Boolean>) as.set(false, false);
    azzert.assertContains(s5, false);
    azzert.assertNotContains(s5, true);
  }
  
  @Test @SuppressWarnings({ "static-method", "boxing", "static-access" }) public void stringsTest() {
    //object string func:
    azzert.assertEquals(as.string(null), "null");
    azzert.assertEquals(as.string(5), "5");
    Integer x1 = 10;
    azzert.assertEquals(as.string(x1), x1 + "");
    azzert.assertEquals(as.string(654.654f), "654.654");
    Float y1 = 0.44645f;
    azzert.assertEquals(as.string(y1), y1 + "");
    azzert.assertEquals(as.string(true), "true");
    Boolean b1 = false;
    azzert.assertEquals(as.string(b1), b1 + "");
    
    //char string func:
    azzert.assertEquals(as.string('a'), "a");
    azzert.assertEquals(as.string('b'), "b");
    azzert.assertEquals(as.string('c'), "c");
    azzert.assertEquals(as.string('d'), "d");
    azzert.assertEquals(as.string('e'), "e");
    azzert.assertEquals(as.string('f'), "f");
    azzert.assertEquals(as.string('+'), "+");
    azzert.assertEquals(as.string('*'), "*");
    azzert.assertEquals(as.string('_'), "_");
    azzert.assertEquals(as.string('='), "=");
    azzert.assertEquals(as.string('\\'), "\\");
    azzert.assertEquals(as.string('\n'), "\n");
    azzert.assertEquals(as.string('\t'), "\t");
    azzert.assertEquals(as.string('1'), "1");
    azzert.assertEquals(as.string('2'), "2");
    azzert.assertEquals(as.string('3'), "3");
    azzert.assertEquals(as.string('4'), "4");
    azzert.assertEquals(as.string('5'), "5");
    
    azzert.assertEquals(as.string(null), "null");
    azzert.assertEquals(as.string("abc"), "abc");
    String str1 = "abc";
    azzert.assertEquals(as.string(str1), str1);
    String str2 = "supercalifragilisticexpialidocious";
    azzert.assertEquals(as.string(str2), str2);
    azzert.assertEquals(as.strings(null).length, 0);
    ArrayList<Integer> al = new ArrayList<>();
    azzert.assertEquals(as.strings(al).length, 0);
    for(int ¢ = 0; ¢ < 10; ++¢)
      al.add(¢ + 1);
    String[] intarr = as.strings(al);
    for(int ¢ = 0; ¢ < 10; ++¢)
      azzert.assertEquals(intarr[¢], ¢ + 1 + "");
    
    ArrayList<String> al1 = new ArrayList<>();
    azzert.assertEquals(as.strings(al1).length, 0);
    al1.add("abcd");
    al1.add("efg");
    al1.add("hijklmonp");
    al1.add("qrstuv");
    al1.add("wxyz");
    al1.add("+_-*/\n\t");
    azzert.assertEquals(as.strings(al1)[0], "abcd");
    azzert.assertEquals(as.strings(al1)[1], "efg");
    azzert.assertEquals(as.strings(al1)[2], "hijklmonp");
    azzert.assertEquals(as.strings(al1)[3], "qrstuv");
    azzert.assertEquals(as.strings(al1)[4], "wxyz");
    azzert.assertEquals(as.strings(al1)[5], "+_-*/\n\t");
  }
  
  @Test @SuppressWarnings("static-method") public void asIterableEssenceTest() {
    //azzert.assertEquals(iter.iterator().hasNext(), true);
    @SuppressWarnings("boxing") Iterable<Integer> iter = as.asIterableEssence(1, 2, 3, 4, 5);
    /*for(int ¢ = 0; ¢ < 5; ++¢) {
      System.out.println(iter.iterator().next());
    }
    */
    // next should return the current member and only than proceed to the next one
    azzert.assertEquals(iter.iterator().hasNext(), true);
    azzert.assertEquals(iter.iterator().next(), 1);
    /*azzert.assertEquals(iter.iterator().hasNext(), true);
    azzert.assertEquals(iter.iterator().next(), 2);
    azzert.assertEquals(iter.iterator().hasNext(), true);
    azzert.assertEquals(iter.iterator().next(), 3);
    azzert.assertEquals(iter.iterator().hasNext(), true);
    azzert.assertEquals(iter.iterator().next(), 4);
    azzert.assertEquals(iter.iterator().hasNext(), false);
    azzert.assertEquals(iter.iterator().next(), 5);
    */
  }
}