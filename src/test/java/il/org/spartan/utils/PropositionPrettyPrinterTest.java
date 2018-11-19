package il.org.spartan.utils;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import java.util.function.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.PropositionPrettyPrinter.*;

@SuppressWarnings("static-method")
public class PropositionPrettyPrinterTest {
  
  static class MockListener implements Listener<BooleanSupplier>{
    
    public int downCalled = 0;
    public int upCalled = 0;
    public int nextCalled = 0;
    public int inTrueCalled = 0;
    public int inFalseCalled = 0;
    
    @Override public void down(){
      downCalled++;
    }
    @Override public void up(){
      upCalled++;
    }
    @Override public void next(){
      nextCalled++;
    }
    @Override public void in(final BooleanSupplier __){
      if(__.getAsBoolean()) {
        inTrueCalled++;
      }else {
        inFalseCalled++;
      }
    }
    
    public void print() {
      System.out.println("downCalled = "+downCalled);
      System.out.println("upCalled = "+upCalled);
      System.out.println("nextCalled = "+nextCalled);
      System.out.println("inTrueCalled = "+inTrueCalled);
      System.out.println("inFalseCalled = "+inFalseCalled);
    }
    
  }
  
  MockListener listener;
  
  @Before public void createListener() {
    this.listener = new MockListener();
  }
  

  
  @Test public void testCreate() {
    PropositionTreeTraversal propositionTreeTraversal = new PropositionTreeTraversal(listener);
    propositionTreeTraversal.topDown(Proposition.AND(()->true, ()->true));
    azzert.that(listener.downCalled, is(1));
    azzert.that(listener.upCalled, is(1));
    azzert.that(listener.nextCalled, is(2));
    azzert.that(listener.inTrueCalled, is(3));
    listener.print();
  }
}
