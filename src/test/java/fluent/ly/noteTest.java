package fluent.ly;

import org.junit.*;

import static fluent.ly.note.*;

import java.io.*;
import java.util.logging.*;

@SuppressWarnings("static-method")
public class noteTest {
   @Test public void testTrace() {
    String real_trace = __.trace();
    
    assert real_trace.contains("fluent.ly.note$__.trace");
  }
   

   static class MyHandler extends Handler{
     
     public String str;

     @Override public void publish(final LogRecord ¢) {
       str = ¢.getMessage();
     }
     
     @Override public void flush(){
       //empty
     }

     @Override public void close(){
       //empty
     } 
     
     public String get() {
       return str;
     }
   }
   
   MyHandler myHandler;
   final ByteArrayOutputStream outContent = new ByteArrayOutputStream(), errContent = new ByteArrayOutputStream();
   final PrintStream originalOut = System.out, originalErr = System.err;
   
   @Before
   public void beforeEach() {
     
     System.setOut(new PrintStream(outContent));
     System.setErr(new PrintStream(errContent));
     
     myHandler = new MyHandler();    
     
     Logger.getGlobal().addHandler(myHandler);
     
     note.set(Level.SEVERE);
     note.unset();
     note.set(Level.WARNING);
     note.set(Level.WARNING);
     note.unset();
     note.unset();
     
   }
   
   @After
   public void afterEach() {
     System.setOut(originalOut);
     System.setErr(originalErr);
   }
   
   @Test public void testBug() { 
     
     bug("hello","a_string");
     System.out.println(myHandler.get());
     assert myHandler.get().contains("A bug was detected in the vicinty of fluent.ly.note$__.trace");
     assert myHandler.get().contains("hello");
     
    
   }
   
   
   @Test(expected=StackOverflowError.class) public void testBugIndefinite() {
     bug();
   }
   
   @Test(expected=StackOverflowError.class) public void testBugIndefinite2() {
     bug("123");
   }
   
   @Test(expected=StackOverflowError.class) public void testBugIndefinite3() {
     bug("123", new Throwable());
   }
   
   @Test(expected=StackOverflowError.class) public void testBugIndefinite4() {
     bug(new Throwable());
   }
   
   @Test(expected=StackOverflowError.class) public void testCancel() {
     cancel(new Exception());
   }
  
}
