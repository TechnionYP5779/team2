package fluent.ly;

import static org.junit.Assert.*;

import java.util.function.*;

import org.junit.*;

public class anonymousTest {
  @Test public void booleanTest() {
    BooleanSupplier bt = ()->true;
    assert anonymous.ly(bt) == true;
    
    BooleanSupplier bf = ()->false;
    assert anonymous.ly(bf) == false;
  }
  
  @Test public void doubleTest() {
    DoubleSupplier b1 = ()->1.5;
    assert anonymous.ly(b1) == 1.5;
    
    DoubleSupplier b500 = ()->500;
    assert anonymous.ly(b500) == 500;
  }
  
  @Test public void intTest() {
    IntSupplier b1 = ()->1;
    assert anonymous.ly(b1) == 1;
    
    IntSupplier b500 = ()->500;
    assert anonymous.ly(b500) == 500;
  }
  
  @Test public void longTest() {
    LongSupplier b1 = ()->1325489434;
    assert anonymous.ly(b1) == 1325489434;
    
    LongSupplier b500 = ()->500548943;
    assert anonymous.ly(b500) == 500548943;
  }
  
  @Test public void tTest() {
    Supplier<Boolean> bt = ()->Boolean.valueOf(true);
    assert anonymous.ly(bt) == Boolean.valueOf(true);
    
    Supplier<Integer> b1 = ()->Integer.valueOf(1);
    assert anonymous.ly(b1) == Integer.valueOf(1);
    
    Supplier<Double> b15 = ()->Double.valueOf(1.5);
    assert anonymous.ly(b15) == 1.5;
    
    Long l = Long.valueOf(1325489434);
    Supplier<Long> b132 = ()->l;
    assert anonymous.ly(b132) == l;
  }
}
