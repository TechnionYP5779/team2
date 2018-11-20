package il.org.spartan.utils;

import static il.org.spartan.Utils.*;

import static fluent.ly.azzert.*;

import java.io.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class FileUtilsTest {
  @Test public void testfindAllJavaFilesPathNull() {
    final String path = null;
    azzert.that(FileUtils.findAllJavaFiles(path).size(), is(0));
  }

  @Test public void testfindAllJavaFilesPathNullBoth() {
    final String path1 = null;
    final String path2 = null;
    azzert.that(FileUtils.findAllJavaFiles(path1, path2).size(), is(0));
  }

  @Test public void testfindAllJavaFilesPathEmpty() {
    azzert.that(FileUtils.findAllJavaFiles().size(), is(0));
  }

  @Test public void testfindAllJavaFilesPathsNullAndNotNull() {
    final String path1 = "src/main/java/a";
    final String path2 = "src/main/java/an";
    azzert.that(FileUtils.findAllJavaFiles(path1, path2).size(), is(3));
  }

  @Test public void testFindAllJavaFilesIterate() {
    azzert.that(FileUtils.findAllJavaFiles("src/main/java").size(), not(is(2)));
  }

  @Test public void testFindAllJavaFilesNotExists() {
    azzert.that(FileUtils.findAllJavaFiles("src/main/java/aaa").size(), is(0));
  }

  @Test public void testFindAllJavaFilesNotDirectory() {
    azzert.that(FileUtils.findAllJavaFiles("src/main/java/a/empty.java").size(), is(0));
  }

  @Test public void testReadFromFile() {
    try {
      azzert.that(FileUtils.readFromFile("src/main/java/an/empty.java"), cantBeNull(containsString("public enum empty")));
    } catch (final IOException ¢) {
      forget.it(¢);
      fail();
    }
  }

  @Test(expected = FileNotFoundException.class) public void testWriteToFileTestNotExisting() throws FileNotFoundException {
    FileUtils.writeToFile("File does not exists at all", "Text");
  }

  @Test public void testWriteToFile() {
    try {
      FileUtils.writeToFile("src/test/resources/my_file.txt", "Text");
    } catch (final FileNotFoundException ¢) {
      forget.it(¢);
      fail();
    }
  }
}