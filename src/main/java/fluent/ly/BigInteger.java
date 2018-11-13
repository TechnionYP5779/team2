package fluent.ly;

import java.util.*;

public class BigInteger {
  
  private List<String> number;
  final static private int chunkSize = 5;

  public BigInteger(String string) {
    number = breakStringToList(string);
  }
  
  public BigInteger(List<String> stringList) {
    number = stringList;
  }
  
  @Override public int hashCode() {
    return Objects.hash(number);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof BigInteger))
      return false;
    BigInteger other = (BigInteger) obj;
    return Objects.equals(number, other.number);
  }

  public BigInteger add(BigInteger bigInteger) {
    List<String> finalList = new ArrayList<>();
    
    int carry = 0;
    
    int len = Math.min(number.size(), bigInteger.getValueAsStringList().size());
    
    List<String> tmp1 = new ArrayList(number);
    List<String> tmp2 = new ArrayList(bigInteger.getValueAsStringList());
    Collections.reverse(tmp1);
    Collections.reverse(tmp2);
    
    for (int i = 0; i < len; i++) {
      
      String first = tmp1.get(i);
      String second = tmp2.get(i);
      StringWithCarry sc = addStringWithCarry(first, second, carry);
      
      carry = sc.carry;
      finalList.add(sc.string);
    }
    
    if(tmp1.size()>len) {
      for (int i = len; i < tmp1.size(); i++) {
        
        StringWithCarry sc = addStringWithCarry(tmp1.get(i), "0", carry); 
        carry = sc.carry;
        
        finalList.add(sc.string);
      }
    }else {
      for (int i = len; i < tmp2.size(); i++) {
        StringWithCarry sc = addStringWithCarry(tmp2.get(i), "0", carry); 
        carry = sc.carry;
        
        finalList.add(sc.string);
      }
    }
    
    if(carry != 0) {
      finalList.add(String.valueOf(carry));
    }
    
    Collections.reverse(finalList);
    BigInteger bi = new BigInteger(finalList);
    return bi;
  }
  
  private static String addStringsSimple(String s1, String s2, int carry) {
    return String.valueOf(Integer.parseInt(s1)+Integer.parseInt(s2)+ carry);
  }
  
  private static StringWithCarry addStringWithCarry(String s1, String s2, int carry) {
    String added = addStringsSimple(s1, s2, carry);
    
    if(added.length() > chunkSize) {
      return new StringWithCarry(added.substring(1), Character.getNumericValue(added.charAt(0)));
    }
    
    return new StringWithCarry(added, 0);
    
  }
  
  private List<String> getValueAsStringList() {
    return number;
  }
  
  private static List<String> breakStringToList(String s){
    List<String> ret = new ArrayList<>();
    
    for (int i = s.length() ; i > 0; i-=chunkSize) {
      int startIndex = i - chunkSize <= 0 ? 0 : i - chunkSize;
      
      String chunk = s.substring(startIndex, i);
      ret.add(chunk);
    }
    Collections.reverse(ret);
    return ret;
  }
  
  @SuppressWarnings("unused") private void printStringArray() {
    for(String s : number) {
      System.out.println(s);
    }
    System.out.println("------------------------");
  }
  
  static class StringWithCarry{
    public String string;
    public int carry = 0;
    
    public StringWithCarry(String string, int carry) {
      this.string = string;
      this.carry = carry;
    }
    
  }
}
