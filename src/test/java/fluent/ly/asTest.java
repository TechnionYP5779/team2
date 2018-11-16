package fluent.ly;

import java.util.*;

import org.junit.*;

import il.org.spartan.*;

import static fluent.ly.azzert.*;

import static fluent.ly.box.*;

@SuppressWarnings({ "static-method", "static-access" }) public class asTest {
  @Test public void asIterableTest1() {
    final int[] res = new int[] { 1, 2, 3, 2, 4, 6, 3, 6, 9, 4, 8, 12, 5, 10, 15 };
    int i = 0;
    for (final Integer f : as.asIterable(Utils.cantBeNull(box(1)), Utils.cantBeNull(box(2)), Utils.cantBeNull(box(3)), 
        Utils.cantBeNull(box(4)), Utils.cantBeNull(box(5))))
      for (final Integer p : as.asIterable(Utils.cantBeNull(box(1)), Utils.cantBeNull(box(2)), Utils.cantBeNull(box(3))))
        azzert.assertEquals(unbox.it(Utils.cantBeNull(f)) * unbox.it(Utils.cantBeNull(p)), res[i++]);
  }

  @Test public void asIterableTest2() {
    final int[] res = new int[] { 1, 2, 3, 2, 4, 6, 3, 6, 9, 4, 8, 12, 5, 10, 15 };
    int i = 0;
    for (final Integer f : as.asIterable(Utils.cantBeNull(box(1)), Utils.cantBeNull(box(2)), Utils.cantBeNull(box(3)), 
        Utils.cantBeNull(box(4)), Utils.cantBeNull(box(5))))
      for (final Integer p : as.asIterable(Utils.cantBeNull(box(1)), Utils.cantBeNull(box(2)), Utils.cantBeNull(box(3))))
        azzert.assertEquals(unbox.it(Utils.cantBeNull(f)) * unbox.it(Utils.cantBeNull(p)), res[i++]);
  }

  @Test public void bitTrueTest() {
    azzert.assertEquals(as.bit(true), 1);
  }

  @Test public void bitFalseTest() {
    azzert.assertEquals(as.bit(false), 0);
  }

  @Test public void bitNullTest() {
    azzert.assertEquals(as.bit(null), 0);
  }

  @Test public void bitIntTest() {
    azzert.assertEquals(as.bit(box(5)), 1);
  }

  @Test public void bitFloatTest() {
    azzert.assertEquals(as.bit(box(0.05f)), 1);
  }

  @Test public void listTest1() {
    azzert.that(as.ingeterList(-1, -2, -3), is(Arrays.asList(new Integer[] { box(-1), box(-2), box(-3) })));
  }

  @Test public void listTest2() {
    azzert.that(as.ingeterList(1, 2, 3, 4, 5, 6), is(Arrays.asList(new Integer[] { box(1), box(2), box(3), box(4), box(5), box(6) })));
  }

  @Test public void listTest3() {
    azzert.that(as.list("a", "abc", "test"), is(Arrays.asList(new String[] { "a", "abc", "test" })));
  } 

  @Test public void listTest4() {
    azzert.that(as.list(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE),
        is(Arrays.asList(new Boolean[] { box(true), box(false), box(false), box(true), box(false), box(true) })));
  }

  @Test public void listTest5() {
    final ArrayList<Integer> al = new ArrayList<>();
    for (int ¢ = 0; ¢ < 10; ++¢)
      al.add(box(¢ + 1));
    final List<Integer> al_lst = as.list(al);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.assertEquals(al_lst.get(¢), ¢ + 1);
  }

  @Test public void intArrayTest() {
    final int[] array1 = as.intArray(1, 2, 3, 4, 5, 6);
    for (int ¢ = 0; ¢ < 6; ++¢)
      azzert.assertEquals(array1[¢], ¢ + 1);
    final int[] array2 = as.intArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.assertEquals(array2[¢], ¢ + 1);
  }
  
  @Test public void intArrayTest1() {
    final int[] array = as.intArray(new ArrayList<>(Arrays.asList(new Integer[] { box(10), box(20), box(30), box(40), box(50) })));
    for (int ¢ = 10; ¢ < 6; ¢+=10)
      azzert.assertEquals(array[¢], ¢);
  }

  @Test public void iteratorTest1() {
    final Iterator<Integer> int_iter = as.iterator(box(1), box(2), box(3), box(4), box(5));
    for (int ¢ = 1; ¢ < 6; ++¢) {
      azzert.assertEquals(int_iter.next(), ¢);
      assert ¢ != 5 ? int_iter.hasNext() : !int_iter.hasNext();
    }
  }

  @Test public void iteratorTest2() {
    final Iterator<Boolean> bool_iter = as.iterator(box(true), box(false), box(true), box(false));
    boolean b = true;
    for (int ¢ = 1; ¢ < 5; ++¢) {
      azzert.assertEquals(bool_iter.next(), b);
      b = !b;
      assert ¢ != 4 ? bool_iter.hasNext() : !bool_iter.hasNext();
    }
  }
  
  @Test public void setTest1() {
    @SuppressWarnings("unchecked") final Set<Integer> s1 = (Set<Integer>) as.set(box(1), box(2), box(3),
        box(4), box(5), box(6), box(7), box(8), box(9), box(10));
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.assertContains(Utils.cantBeNull(s1), box(¢ + 1));
  }
  
  @Test public void setTest2() {
    @SuppressWarnings("unchecked") final Set<String> s2 = (Set<String>) as.set("abcdefg", "hijklmnop", "qrstuv", "wxyz");
    Set<String> s = new LinkedHashSet<>(Arrays.asList(new String[] { "abcdefg", "hijklmnop", "qrstuv", "wxyz" }));
    azzert.assertSubset(s, Utils.cantBeNull(s2));
    azzert.assertSubset(Utils.cantBeNull(s2), s);
  }
  
  @Test public void setTest3() {
    @SuppressWarnings("unchecked") final Set<Boolean> s3 = (Set<Boolean>) as.set(box(true), box(false),
        box(true), box(true), box(false), box(false));
    azzert.assertContains(Utils.cantBeNull(s3), box(true));
    azzert.assertContains(Utils.cantBeNull(s3), box(false));
  }
  
  @Test public void setTest4() {
    @SuppressWarnings("unchecked") final Set<Boolean> s4 = (Set<Boolean>) as.set(box(true), box(true),
        box(true), box(true));
    azzert.assertContains(Utils.cantBeNull(s4), box(true));
    azzert.assertNotContains(Utils.cantBeNull(s4), box(false));
  }
  
  @Test public void setTest5() {
    @SuppressWarnings("unchecked") final Set<Boolean> s5 = (Set<Boolean>) as.set(box(false), box(false));
    azzert.assertContains(Utils.cantBeNull(s5), box(false));
    azzert.assertNotContains(Utils.cantBeNull(s5), box(true));
  }

  @Test public void stringsNullTest() {
    azzert.assertEquals(as.string(null), "null");
  }

  @Test public void stringTest1() {
    azzert.assertEquals(as.string(box(5)), "5");
  }

  @Test public void stringTest2() {
    final Integer x1 = box(10);
    azzert.assertEquals(as.string(x1), x1 + "");
  }

  @Test public void stringTest3() {
    azzert.assertEquals(as.string(box(654.654f)), "654.654");
  }

  @Test public void stringTest4() {
    final Float y1 = box(0.44645f);
    azzert.assertEquals(as.string(y1), y1 + "");
  }

  @Test public void stringTest5() {
    azzert.assertEquals(as.string(box(true)), "true");
  }

  @Test public void stringTest6() {
    final Boolean b1 = box(false);
    azzert.assertEquals(as.string(b1), b1 + "");
  }

  @Test public void stringCharTest1() {
    azzert.assertEquals(as.string('a'), "a");
  }

  @Test public void stringCharTest2() {
    azzert.assertEquals(as.string('b'), "b");
  }

  @Test public void stringCharTest3() {
    azzert.assertEquals(as.string('c'), "c");
  }

  @Test public void stringCharTest4() {
    azzert.assertEquals(as.string('d'), "d");
  }

  @Test public void stringCharTest5() {
    azzert.assertEquals(as.string('e'), "e");
  }

  @Test public void stringCharTest6() {
    azzert.assertEquals(as.string('f'), "f");
  }

  @Test public void stringSignCharTest1() {
    azzert.assertEquals(as.string('+'), "+");
  }

  @Test public void stringSignCharTest2() {
    azzert.assertEquals(as.string('*'), "*");
  }

  @Test public void stringSignCharTest3() {
    azzert.assertEquals(as.string('_'), "_");
  }

  @Test public void stringSignCharTest4() {
    azzert.assertEquals(as.string('='), "=");
  }

  @Test public void stringSignCharTest5() {
    azzert.assertEquals(as.string('\\'), "\\");
  }

  @Test public void stringSignCharTest6() {
    azzert.assertEquals(as.string('\n'), "\n");
  }

  @Test public void stringSignCharTest7() {
    azzert.assertEquals(as.string('\t'), "\t");
  }

  @Test public void stringNumCharTest1() {
    azzert.assertEquals(as.string('1'), "1");
  }

  @Test public void stringNumCharTest2() {
    azzert.assertEquals(as.string('2'), "2");
  }

  @Test public void stringNumCharTest3() {
    azzert.assertEquals(as.string('3'), "3");
  }

  @Test public void stringNumCharTest4() {
    azzert.assertEquals(as.string('4'), "4");
  }

  @Test public void stringNumCharTest5() {
    azzert.assertEquals(as.string('5'), "5");
  }

  @Test public void stringNullInputTest() {
    azzert.assertEquals(as.string(null), "null");
  }

  @Test public void stringStrTest1() {
    azzert.assertEquals(as.string("abc"), "abc");
  }

  @Test public void stringStrTest2() {
    azzert.assertEquals(as.string("abc"), "abc");
  }

  @Test public void stringStrTest3() {
    azzert.assertEquals(as.string("supercalifragilisticexpialidocious"), "supercalifragilisticexpialidocious");
  }

  @Test public void stringsStrTest1() {
    azzert.assertEquals(as.strings(null).length, 0);
  }

  @Test public void stringsTest2() {
    azzert.assertEquals(as.strings(new ArrayList<>()).length, 0);
  }

  @Test public void stringsTest3() {
    final ArrayList<Integer> al = new ArrayList<>();
    azzert.assertEquals(as.strings(al).length, 0);
    for (int ¢ = 0; ¢ < 10; ++¢)
      al.add(box(¢ + 1));
    final String[] intarr = as.strings(al);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.assertEquals(intarr[¢], ¢ + 1 + "");
  }

  @Test public void stringsTest4() {
    final ArrayList<String> al1 = new ArrayList<>();
    al1.add("abcd");
    al1.add("efg");
    al1.add("hijklmonp");
    al1.add("qrstuv");
    al1.add("wxyz");
    al1.add("+_-*/\n\t");
    azzert.that(al1, is(Arrays.asList(new String[]{"abcd", "efg", "hijklmonp", "qrstuv", "wxyz", "+_-*/\n\t"})));
    
  }
  
  @Test public void asIterableLambdaTest() {
    final Iterable<Integer> iter = as.asIterableLambda(Utils.cantBeNull(box(1)), Utils.cantBeNull(box(2)), 
        Utils.cantBeNull(box(3)), Utils.cantBeNull(box(4)), Utils.cantBeNull(box(5)));
    //for(int ¢ = 0; ¢ < 5; ++¢) System.out.println(iter.iterator().next());
    // next should return the current member and only than proceed to the next one
    azzert.assertEquals(iter.iterator().hasNext(), true);
    azzert.assertEquals(iter.iterator().next(), 1);
    /* azzert.assertEquals(iter.iterator().hasNext(), true);
     * azzert.assertEquals(iter.iterator().next(), 2);
     * azzert.assertEquals(iter.iterator().hasNext(), true);
     * azzert.assertEquals(iter.iterator().next(), 3);
     * azzert.assertEquals(iter.iterator().hasNext(), true);
     * azzert.assertEquals(iter.iterator().next(), 4);
     * azzert.assertEquals(iter.iterator().hasNext(), false);
     * azzert.assertEquals(iter.iterator().next(), 5); */
  }

  @Test public void asIterableEssenceTest() {
    // azzert.assertEquals(iter.iterator().hasNext(), true);
    final Iterable<Integer> iter = as.asIterableEssence(Utils.cantBeNull(box(1)), Utils.cantBeNull(box(2)), 
        Utils.cantBeNull(box(3)), Utils.cantBeNull(box(4)), Utils.cantBeNull(box(5)));
    /* for(int ¢ = 0; ¢ < 5; ++¢) { System.out.println(iter.iterator().next()); } */
    // next should return the current member and only than proceed to the next one
    azzert.assertEquals(iter.iterator().hasNext(), true);
    azzert.assertEquals(iter.iterator().next(), 1);
    /* azzert.assertEquals(iter.iterator().hasNext(), true);
     * azzert.assertEquals(iter.iterator().next(), 2);
     * azzert.assertEquals(iter.iterator().hasNext(), true);
     * azzert.assertEquals(iter.iterator().next(), 3);
     * azzert.assertEquals(iter.iterator().hasNext(), true);
     * azzert.assertEquals(iter.iterator().next(), 4);
     * azzert.assertEquals(iter.iterator().hasNext(), false);
     * azzert.assertEquals(iter.iterator().next(), 5); */
  }
  
  @Test public void arrayTest() {
    final Integer[] array = as.array(box(new int[] {1, 2, 3, 4, 5}));
    for(int ¢ = 0; ¢ < 5; ++¢)
      azzert.assertEquals(array[¢], ¢ + 1);
  }
}