package il.org.spartan.tables;

import static fluent.ly.azzert.*;

import static fluent.ly.box.*;

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

    @Ignore @Test public void renderTest() {
      // TODO:
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

  @Ignore @Test public void cellRealTest() {
    // TODO:
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

  @Ignore @Test public void cellArrayTest() {
    // TODO:
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

  @Ignore @Test public void renderTest() {
    // TODO:
  }

  @Ignore @Test public void renderRowTest() {
    // TODO:
  }

  @Test public void stringFieldTest() {
    azzert.that(txt.stringField("some string"), is("some string"));
  }
}
