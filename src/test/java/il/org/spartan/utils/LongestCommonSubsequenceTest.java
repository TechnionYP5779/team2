package il.org.spartan.utils;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import org.junit.*;

@SuppressWarnings("static-method" ) public class LongestCommonSubsequenceTest {
  @Test public void testCtor() {
    Assert.assertNotNull(new LongestCommonSubsequence("czxczabcddgsfgfdgsfd", "Hdghetwrgwfvabcdrdf"));
  }

  @Test public void testSimilarity1() {
    Assert.assertThat(box(new LongestCommonSubsequence("a", "a").similarity()), is(1.0));
  }

  @Test public void testSimilarity2() {
    Assert.assertThat(box(new LongestCommonSubsequence("", "a").similarity()), is(0.0));
  }

  @Test public void testSimilarity3() {
    Assert.assertThat(box(new LongestCommonSubsequence("a", "").similarity()), is(0.0));
  }

  @Test public void testCompute() {
    Assert.assertThat(box(new LongestCommonSubsequence("1234abcd5678", "5678abcd1234").similarity()), is(8.0 / 24));
  }
}
