package il.org.spartan.utils;

import org.junit.*;
import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import fluent.ly.*;

@SuppressWarnings({ "static-access", "static-method" }) public class LongestCommonSubsequenceTest {
  @Test public void testCtor() {
    azzert.assertNotNull(new LongestCommonSubsequence("czxczabcddgsfgfdgsfd", "Hdghetwrgwfvabcdrdf"));
  }

  @Test public void testSimilarity1() {
    azzert.assertThat(box(new LongestCommonSubsequence("a", "a").similarity()), is(1.0));
  }

  @Test public void testSimilarity2() {
    azzert.assertThat(box(new LongestCommonSubsequence("", "a").similarity()), is(0.0));
  }

  @Test public void testSimilarity3() {
    azzert.assertThat(box(new LongestCommonSubsequence("a", "").similarity()), is(0.0));
  }

  @Test public void testCompute() {
    azzert.assertThat(box(new LongestCommonSubsequence("1234abcd5678", "5678abcd1234").similarity()), is(8.0 / 24));
  }
}
