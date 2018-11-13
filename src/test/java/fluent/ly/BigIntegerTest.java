package fluent.ly;

import static fluent.ly.azzert.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.idiomatic;
import fluent.ly.idiomatic.*;
import java.io.IOException;
import java.util.function.*;

public class BigIntegerTest {
  @Test
  public void testCreateFromString() {
    BigInteger bi = new BigInteger("123");
    azzert.assertNotEquals(bi, null);
  }
}
