package fluent.ly;

import static il.org.spartan.Utils.*;

import static org.junit.Assert.assertEquals;

import static fluent.ly.azzert.*;
import static fluent.ly.azzert.assertEquals;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class asTest {
  @SuppressWarnings("null") @Test public void asIterableTest1() {
    final int[] res = new int[] { 1, 2, 3, 2, 4, 6, 3, 6, 9, 4, 8, 12, 5, 10, 15 };
    int i = 0;
    for (final Integer f : as.asIterable(fluent.ly.box.it(1), fluent.ly.box.it(2), fluent.ly.box.it(3), fluent.ly.box.it(4), fluent.ly.box.it(5)))
      for (final Integer p : as.asIterable(fluent.ly.box.it(1), fluent.ly.box.it(2), fluent.ly.box.it(3)))
        assertEquals(unbox.it(cantBeNull(f)) * unbox.it(cantBeNull(p)), res[i++]);
  }

  @Test @SuppressWarnings("null") public void asIterableTest2() {
    final int[] res = new int[] { 1, 2, 3, 2, 4, 6, 3, 6, 9, 4, 8, 12, 5, 10, 15 };
    int i = 0;
    for (final Integer f : as.asIterableLambda(fluent.ly.box.it(1), fluent.ly.box.it(2), fluent.ly.box.it(3), fluent.ly.box.it(4),
        fluent.ly.box.it(5)))
      for (final Integer p : as.asIterableLambda(fluent.ly.box.it(1), fluent.ly.box.it(2), fluent.ly.box.it(3)))
        assertEquals(unbox.it(f) * unbox.it(p), res[i++]);
  }

  @Test public void bitTrueTest() {
    assertEquals(as.bit(true), 1);
  }

  @Test public void bitFalseTest() {
    assertEquals(as.bit(false), 0);
  }

  @Test public void bitNullTest() {
    assertEquals(as.bit(null), 0);
  }

  @Test public void bitIntTest() {
    assertEquals(as.bit(fluent.ly.box.it(5)), 1);
  }

  @Test public void bitFloatTest() {
    assertEquals(as.bit(fluent.ly.box.it(0.05f)), 1);
  }

  @Test public void listTest1() {
    final List<Integer> lst1 = as.ingeterList(-1, -2, -3);
    assertEquals(lst1.get(0), -1);
    assertEquals(lst1.get(1), -2);
    assertEquals(lst1.get(2), -3);
    assertEquals(as.ingeterList().isEmpty(), true);
  }

  @Test public void listTest2() {
    final List<Integer> lst2 = as.ingeterList(1, 2, 3, 4, 5, 6);
    assertEquals(lst2.get(0), 1);
    assertEquals(lst2.get(1), 2);
    assertEquals(lst2.get(2), 3);
    assertEquals(lst2.get(3), 4);
    assertEquals(lst2.get(4), 5);
    assertEquals(lst2.get(5), 6);
    assertEquals(as.ingeterList().isEmpty(), true);
  }

  @Test public void listTest3() {
    final List<String> lst6 = as.list("a", "abc", "test");
    assertEquals("a".equals(lst6.get(0)), true);
    assertEquals("b".equals(lst6.get(0)), false);
    assertEquals("abc".equals(lst6.get(1)), true);
    assertEquals("axc".equals(lst6.get(1)), false);
    assertEquals("abd".equals(lst6.get(1)), false);
    assertEquals("test".equals(lst6.get(2)), true);
    assertEquals("tast".equals(lst6.get(2)), false);
  }

  @Test public void listTest4() {
    final List<Boolean> lst7 = as.list(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE);
    assertEquals(lst7.get(0), true);
    assertEquals(lst7.get(1), false);
    assertEquals(lst7.get(2), false);
    assertEquals(lst7.get(3), true);
    assertEquals(lst7.get(4), false);
    assertEquals(lst7.get(5), true);
  }

  @Test public void listTest5() {
    final ArrayList<Integer> al = new ArrayList<>();
    for (int ¢ = 0; ¢ < 10; ++¢)
      al.add(fluent.ly.box.it(¢ + 1));
    final List<Integer> al_lst = as.list(al);
    for (int ¢ = 0; ¢ < 10; ++¢)
      assertEquals(al_lst.get(¢), ¢ + 1);
  }

  @Test public void intArrayTest() {
    final int[] array1 = as.intArray(1, 2, 3, 4, 5, 6);
    for (int ¢ = 0; ¢ < 6; ++¢)
      assertEquals(array1[¢], ¢ + 1);
    final int[] array2 = as.intArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    for (int ¢ = 0; ¢ < 10; ++¢)
      assertEquals(array2[¢], ¢ + 1);
  }

  @Test public void iteratorTest1() {
    final Iterator<Integer> int_iter = as.iterator(fluent.ly.box.it(1), fluent.ly.box.it(2), fluent.ly.box.it(3), fluent.ly.box.it(4),
        fluent.ly.box.it(5));
    for (int ¢ = 1; ¢ < 6; ++¢) {
      assertEquals(int_iter.next(), ¢);
      assert ¢ != 5 ? int_iter.hasNext() : !int_iter.hasNext();
    }
  }

  @Test public void iteratorTest2() {
    final Iterator<Boolean> bool_iter = as.iterator(fluent.ly.box.it(true), fluent.ly.box.it(false), fluent.ly.box.it(true), fluent.ly.box.it(false));
    boolean b = true;
    for (int ¢ = 1; ¢ < 5; ++¢) {
      assertEquals(bool_iter.next(), b);
      b = !b;
      assert ¢ != 4 ? bool_iter.hasNext() : !bool_iter.hasNext();
    }
  }

  @Test @SuppressWarnings("null") public void setTest() {
    @SuppressWarnings("unchecked") final Set<Integer> s1 = (Set<Integer>) as.set(fluent.ly.box.it(1), fluent.ly.box.it(2), fluent.ly.box.it(3),
        fluent.ly.box.it(4), fluent.ly.box.it(5), fluent.ly.box.it(6), fluent.ly.box.it(7), fluent.ly.box.it(8), fluent.ly.box.it(9),
        fluent.ly.box.it(10));
    for (int ¢ = 0; ¢ < 10; ++¢) {
      assertContains(s1, fluent.ly.box.it(¢ + 1));
      assertNotContains(s1, fluent.ly.box.it(500 * ¢));
    }
    @SuppressWarnings("unchecked") final Set<String> s2 = (Set<String>) as.set("abcdefg", "hijklmnop", "qrstuv", "wxyz");
    assertContains(s2, "abcdefg");
    assertNotContains(s2, "lkgfnf");
    assertContains(s2, "hijklmnop");
    assertNotContains(s2, "ertyuvbnm");
    assertContains(s2, "qrstuv");
    assertNotContains(s2, "543asdfnlj");
    assertContains(s2, "wxyz");
    assertNotContains(s2, "asdasd");
    @SuppressWarnings("unchecked") final Set<Boolean> s3 = (Set<Boolean>) as.set(fluent.ly.box.it(true), fluent.ly.box.it(false),
        fluent.ly.box.it(true), fluent.ly.box.it(true), fluent.ly.box.it(false), fluent.ly.box.it(false));
    assertContains(s3, fluent.ly.box.it(true));
    assertContains(s3, fluent.ly.box.it(false));
    @SuppressWarnings("unchecked") final Set<Boolean> s4 = (Set<Boolean>) as.set(fluent.ly.box.it(true), fluent.ly.box.it(true),
        fluent.ly.box.it(true), fluent.ly.box.it(true));
    assertContains(s4, fluent.ly.box.it(true));
    assertNotContains(s4, fluent.ly.box.it(false));
    @SuppressWarnings("unchecked") final Set<Boolean> s5 = (Set<Boolean>) as.set(fluent.ly.box.it(false), fluent.ly.box.it(false));
    assertContains(s5, fluent.ly.box.it(false));
    assertNotContains(s5, fluent.ly.box.it(true));
  }

  @Test public void stringsNullTest() {
    assertEquals(as.string(null), "null");
  }

  @Test public void stringTest1() {
    assertEquals(as.string(fluent.ly.box.it(5)), "5");
  }

  @Test public void stringTest2() {
    final Integer x1 = fluent.ly.box.it(10);
    assertEquals(as.string(x1), x1 + "");
  }

  @Test public void stringTest3() {
    assertEquals(as.string(fluent.ly.box.it(654.654f)), "654.654");
  }

  @Test public void stringTest4() {
    final Float y1 = fluent.ly.box.it(0.44645f);
    assertEquals(as.string(y1), y1 + "");
  }

  @Test public void stringTest5() {
    assertEquals(as.string(fluent.ly.box.it(true)), "true");
  }

  @Test public void stringTest6() {
    final Boolean b1 = fluent.ly.box.it(false);
    assertEquals(as.string(b1), b1 + "");
  }

  @Test public void stringCharTest1() {
    assertEquals(as.string('a'), "a");
  }

  @Test public void stringCharTest2() {
    assertEquals(as.string('b'), "b");
  }

  @Test public void stringCharTest3() {
    assertEquals(as.string('c'), "c");
  }

  @Test public void stringCharTest4() {
    assertEquals(as.string('d'), "d");
  }

  @Test public void stringCharTest5() {
    assertEquals(as.string('e'), "e");
  }

  @Test public void stringCharTest6() {
    assertEquals(as.string('f'), "f");
  }

  @Test public void stringSignCharTest1() {
    assertEquals(as.string('+'), "+");
  }

  @Test public void stringSignCharTest2() {
    assertEquals(as.string('*'), "*");
  }

  @Test public void stringSignCharTest3() {
    assertEquals(as.string('_'), "_");
  }

  @Test public void stringSignCharTest4() {
    assertEquals(as.string('='), "=");
  }

  @Test public void stringSignCharTest5() {
    assertEquals(as.string('\\'), "\\");
  }

  @Test public void stringSignCharTest6() {
    assertEquals(as.string('\n'), "\n");
  }

  @Test public void stringSignCharTest7() {
    assertEquals(as.string('\t'), "\t");
  }

  @Test public void stringNumCharTest1() {
    assertEquals(as.string('1'), "1");
  }

  @Test public void stringNumCharTest2() {
    assertEquals(as.string('2'), "2");
  }

  @Test public void stringNumCharTest3() {
    assertEquals(as.string('3'), "3");
  }

  @Test public void stringNumCharTest4() {
    assertEquals(as.string('4'), "4");
  }

  @Test public void stringNumCharTest5() {
    assertEquals(as.string('5'), "5");
  }

  @Test public void stringNullInputTest() {
    assertEquals(as.string(null), "null");
  }

  @Test public void stringStrTest1() {
    assertEquals(as.string("abc"), "abc");
  }

  @Test public void stringStrTest2() {
    assertEquals(as.string("abc"), "abc");
  }

  @Test public void stringStrTest3() {
    assertEquals(as.string("supercalifragilisticexpialidocious"), "supercalifragilisticexpialidocious");
  }

  @Test public void stringsStrTest1() {
    assertEquals(as.strings(null).length, 0);
  }

  @Test public void stringsTest2() {
    assertEquals(as.strings(new ArrayList<>()).length, 0);
  }

  @Test public void stringsTest3() {
    final ArrayList<Integer> al = new ArrayList<>();
    assertEquals(as.strings(al).length, 0);
    for (int ¢ = 0; ¢ < 10; ++¢)
      al.add(fluent.ly.box.it(¢ + 1));
    final String[] intarr = as.strings(al);
    for (int ¢ = 0; ¢ < 10; ++¢)
      assertEquals(intarr[¢], ¢ + 1 + "");
  }

  @Test public void stringsTest4() {
    final ArrayList<String> al1 = new ArrayList<>();
    al1.add("abcd");
    al1.add("efg");
    al1.add("hijklmonp");
    al1.add("qrstuv");
    al1.add("wxyz");
    al1.add("+_-*/\n\t");
    assertEquals(as.strings(al1)[0], "abcd");
    assertEquals(as.strings(al1)[1], "efg");
    assertEquals(as.strings(al1)[2], "hijklmonp");
    assertEquals(as.strings(al1)[3], "qrstuv");
    assertEquals(as.strings(al1)[4], "wxyz");
    assertEquals(as.strings(al1)[5], "+_-*/\n\t");
  }

  @Test @SuppressWarnings("null") public void asIterableEssenceTest() {
    // assertEquals(iter.iterator().hasNext(), true);
    final Iterable<Integer> iter = as.asIterableEssence(fluent.ly.box.it(1), fluent.ly.box.it(2), fluent.ly.box.it(3), fluent.ly.box.it(4),
        fluent.ly.box.it(5));
    /* for(int ¢ = 0; ¢ < 5; ++¢) { System.out.println(iter.iterator().next()); } */
    // next should return the current member and only than proceed to the next one
    assertEquals(iter.iterator().hasNext(), true);
    assertEquals(iter.iterator().next(), 1);
    /* assertEquals(iter.iterator().hasNext(), true);
     * assertEquals(iter.iterator().next(), 2);
     * assertEquals(iter.iterator().hasNext(), true);
     * assertEquals(iter.iterator().next(), 3);
     * assertEquals(iter.iterator().hasNext(), true);
     * assertEquals(iter.iterator().next(), 4);
     * assertEquals(iter.iterator().hasNext(), false);
     * assertEquals(iter.iterator().next(), 5); */
  }
}