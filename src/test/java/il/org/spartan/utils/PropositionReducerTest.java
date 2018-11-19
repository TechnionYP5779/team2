package il.org.spartan.utils;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;
import static fluent.ly.unbox.*;

import java.util.function.*;

import org.junit.*;

import fluent.ly.*;


public class PropositionReducerTest {
  
  class MyReduce extends Reduce<Integer>{

    @Override public Integer reduce() {
      return Integer.valueOf(0);
    }

    @Override public Integer reduce(Integer r1, Integer r2) {
      if(r1 == null || r2 == null)
        return null;
      return box(unbox(r1) +unbox(r2));
    }

    
    
  }
  
  class MyPropositionReducer extends PropositionReducer<Integer>{

    public MyPropositionReducer(Reduce<Integer> inner) {
      super(inner);
    }
    
    @Override
    protected Integer map(BooleanSupplier ¢) {
      return ¢.getAsBoolean() ?  Integer.valueOf(1) : Integer.valueOf(-1); 
    }
    
  }
  
  MyPropositionReducer myPropositionReducer = new MyPropositionReducer(new MyReduce());
  
  
   @Test public void testReduce1() {
     azzert.that(myPropositionReducer.reduce(), is(Integer.valueOf(0)));
  }
   
   @Test public void testReduce2() {
     azzert.that(myPropositionReducer.reduce(()->true), is(Integer.valueOf(1)));
   }
   
   @Test public void testReducePropositionAND() {
     azzert.that(myPropositionReducer.reduce(Proposition.AND(()->true,()->true)), is(Integer.valueOf(2)));
   }
   
   @Test public void testReducePropositionOR() {
     azzert.that(myPropositionReducer.reduce(Proposition.OR(()->true,()->true)), is(Integer.valueOf(2)));
   }
   
   @Test public void testReducePropositionNot() {
     azzert.that(myPropositionReducer.reduce(Proposition.not(()->true)), is(Integer.valueOf(1)));
   }
   
   @Test public void testReducePropositionThat() {
     azzert.that(myPropositionReducer.reduce(Proposition.that(()->true)), is(Integer.valueOf(1)));
   }
}
