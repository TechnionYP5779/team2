package il.org.spartan.tables;

import static il.org.spartan.Utils.*;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.tables.TableRenderer.*;

@SuppressWarnings("static-method") public class TableRendererTest {
  static TableRenderer txt = builtin.TXT;
  static TableRenderer tex = builtin.TEX;
  static TableRenderer tex2 = builtin.TEX2;
  static TableRenderer csv = builtin.CSV;
  static TableRenderer markdown = builtin.MARKDOWN;
  static String NL = System.getProperty("line.separator");

  public static class Tex {
    @Test public void afterHeaderTest() {
      azzert.that(tex.afterHeader(), is("\\midrule" + NL));
    }

    @Test public void afterTableTest() {
      azzert.that(tex.afterTable(), is("\\bottomrule" + NL));
    }

    @Test public void arraySeparatorTest() {
      azzert.that(tex.arraySeparator(), is(", "));
    }

    @Test public void beforeFooterTest() {
      azzert.that(tex.beforeFooter(), is("\\midrule" + NL));
    }

    @Test public void beforeTableTest() {
      azzert.that(tex.beforeTable(), is("\\toprule" + NL));
    }

    @Test public void nilTest() {
      azzert.that(tex.nil(), is("$\\#$"));
    }

    @Test public void recordEndTest() {
      azzert.that(tex.recordEnd(), is(" \\\\" + NL));
    }

    @Test public void recordSeparatorTest() {
      azzert.that(tex.recordSeparator(), is("\t&\t"));
    }

    @Test public void renderΣTest() {
      azzert.that(tex.render(Statistic.Σ), is("\\hfill$\\Sum$"));
    }

    @Test public void renderσTest() {
      azzert.that(tex.render(Statistic.σ), is("\\hfill$\\sigma$"));
    }

    @Test public void renderMaxTest() {
      azzert.that(tex.render(Statistic.max), is("\\hfill$\\max$"));
    }

    @Test public void renderMinTest() {
      azzert.that(tex.render(Statistic.min), is("\\hfill$\\min$"));
    }

    @Test public void renderNTest() {
      azzert.that(tex.render(Statistic.N), is("\\hfillN"));
    }

    @Test public void renderNATest() {
      azzert.that(tex.render(Statistic.NA), is("\\hfillN/A"));
    }

    @Test public void renderMeanTest() {
      azzert.that(tex.render(Statistic.mean), is("\\hfillmean"));
    }

    @Test public void renderMedianTest() {
      azzert.that(tex.render(Statistic.median), is("\\hfillmedian"));
    }

    @Test public void renderMadTest() {
      azzert.that(tex.render(Statistic.MAD), is("\\hfillM.A.D"));
    }

    @Test public void renderRangeTest() {
      azzert.that(tex.render(Statistic.range), is("\\hfillrange"));
    }

    @Test public void renderQ1Test() {
      azzert.that(tex.render(Statistic.Q1), is("\\hfillQ1"));
    }

    @Test public void renderQ3Test() {
      azzert.that(tex.render(Statistic.Q3), is("\\hfillQ3"));
    }
  }

  public static class Tex2 {
    @Test public void afterHeaderTest() {
      azzert.that(tex2.afterHeader(), is("\\hline" + NL));
    }

    @Test public void afterTableTest() {
      azzert.that(tex2.afterTable(), is("\\hline" + NL));
    }

    @Test public void arraySeparatorTest() {
      azzert.that(tex2.arraySeparator(), is(", "));
    }

    @Test public void beforeFooterTest() {
      azzert.that(tex2.beforeFooter(), is("\\hline" + NL));
    }

    @Test public void beforeTableTest() {
      azzert.that(tex2.beforeTable(), is("\\hline" + NL));
    }

    @Test public void footerEndTest() {
      azzert.that(tex2.footerEnd(), is("\\\\" + NL));
    }

    @Test public void recordSeparatorTest() {
      azzert.that(tex2.recordSeparator(), is("\t&\t"));
    }
  }

  public static class Csv {
    @Test public void footerEndTest() {
      azzert.that(csv.footerEnd(), is(NL));
    }

    @Test public void recordSeparatorTest() {
      azzert.that(csv.recordSeparator(), is(","));
    }
  }

  public static class Markdown {
    @Test public void afterHeaderTest() {
      markdown.setHeaderCount(5);
      azzert.that(markdown.afterHeader(), is("| --- |--- |--- |--- |--- |" + NL));
    }

    @Test public void afterTableTest() {
      azzert.that(markdown.afterTable(), is(NL));
    }

    @Test public void beforeTableTest() {
      azzert.that(markdown.beforeTable(), is(NL));
    }

    @Test public void recordBeginTest() {
      azzert.that(markdown.recordBegin(), is("|"));
    }

    @Test public void recordEndTest() {
      azzert.that(markdown.recordEnd(), is(" |" + NL));
    }

    @Test public void recordSeparatorTest() {
      azzert.that(markdown.recordSeparator(), is(" | "));
    }
  }

  public static class txt {
    @Test public void cellRealTest1() {
      azzert.that(txt.cellReal(box(5642.0)), is("5642"));
    }

    @Test public void cellRealTest() {
      azzert.that(txt.cellReal(box(5642.859420000)), is("5642.85942"));
    }

    @Test public void emptyTest() {
      azzert.that(TableRenderer.empty(), is(""));
    }

    @Test public void tabTest() {
      azzert.that(TableRenderer.tab(), is("\t"));
    }

    @Test public void afterFooterTest() {
      azzert.that(txt.afterFooter(), is(""));
    }

    @Test public void afterHeaderTest() {
      azzert.that(txt.afterHeader(), is(""));
    }

    @Test public void afterTableTest() {
      azzert.that(txt.afterTable(), is(""));
    }

    @Test public void arraySeparatorTest() {
      azzert.that(txt.arraySeparator(), is("; "));
    }

    @Test public void beforeFooterTest() {
      azzert.that(txt.beforeFooter(), is(""));
    }

    @Test public void beforeHeaderTest() {
      azzert.that(txt.beforeHeader(), is(""));
    }

    @Test public void beforeTableTest() {
      azzert.that(txt.beforeTable(), is(""));
    }

    @Test public void cellArrayTest() {
      azzert.that(txt.cellArray(box(new int[] { 1, 2, 3, 4 })), is("1; 2; 3; 4"));
    }

    @Test public void cellIntTest() {
      azzert.that(txt.cellInt(box(85674L)), is("85674"));
    }

    @Test public void extensionTest() {
      azzert.that(txt.extension(), is("txt"));
    }

    @Test public void footerBeginTest() {
      azzert.that(txt.footerBegin(), is(""));
    }

    @Test public void footerEndTest() {
      azzert.that(txt.footerEnd(), is(NL));
    }

    @Test public void footerSeparatorTest() {
      azzert.that(txt.footerSeparator(), is("\t"));
    }

    @Test public void headerLineBeginTest() {
      azzert.that(txt.headerLineBegin(), is(""));
    }

    @Test public void headerLineEndTest() {
      azzert.that(txt.headerLineEnd(), is(NL));
    }

    @Test public void headerSeparatorTest() {
      azzert.that(txt.headerSeparator(), is("\t"));
    }

    @Test public void nilTest() {
      azzert.that(txt.nil(), is("Nº"));
    }

    @Test public void recordBeginTest() {
      azzert.that(txt.recordBegin(), is(""));
    }

    @Test public void recordEndTest() {
      azzert.that(txt.recordEnd(), is(NL));
    }

    @Test public void recordSeparatorTest() {
      azzert.that(txt.headerLineBegin(), is(""));
    }

    @Test public void renderΣTest() {
      azzert.that(txt.render(Statistic.Σ), is("Σ"));
    }

    @Test public void renderσTest() {
      azzert.that(txt.render(Statistic.σ), is("σ"));
    }

    @Test public void renderMaxTest() {
      azzert.that(txt.render(Statistic.max), is("max"));
    }

    @Test public void renderMinTest() {
      azzert.that(txt.render(Statistic.min), is("min"));
    }

    @Test public void renderNTest() {
      azzert.that(txt.render(Statistic.N), is("N"));
    }

    @Test public void renderNATest() {
      azzert.that(txt.render(Statistic.NA), is("N/A"));
    }

    @Test public void renderMeanTest() {
      azzert.that(txt.render(Statistic.mean), is("mean"));
    }

    @Test public void renderMedianTest() {
      azzert.that(txt.render(Statistic.median), is("median"));
    }

    @Test public void renderMadTest() {
      azzert.that(txt.render(Statistic.MAD), is("M.A.D"));
    }

    @Test public void renderRangeTest() {
      azzert.that(txt.render(Statistic.range), is("range"));
    }

    @Test public void renderQ1Test() {
      azzert.that(txt.render(Statistic.Q1), is("Q1"));
    }

    @Test public void renderQ3Test() {
      azzert.that(txt.render(Statistic.Q3), is("Q3"));
    }

    @Test public void renderRowTest() {
      azzert.that(txt.renderRow(Arrays.asList(new Object[] { box(12), box(34L) }, cantBeNull(box(56)), box(78L), cantBeNull(box(10.10)), "som")),
          is("12; 34\t56\t78\t10.1\tsom" + NL));
    }

    @Test public void stringFieldTest() {
      azzert.that(txt.stringField("some string"), is("some string"));
    }
  }
}
