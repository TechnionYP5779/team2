package fluent.ly;

import java.util.*;

public class BigInteger {
  
  private List<String> number;
  final static private int chunkSize = 10;

  public BigInteger(String string) {
    number = breakStringToList(string);
    // TODO Auto-generated constructor stub
  }
  
  public BigInteger(List<String> stringList) {
    number = stringList;
    // TODO Auto-generated constructor stub
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
    // TODO Auto-generated method stub
    List<String> finalList = new ArrayList<>();
    
    int carry = 0;
    
    int len = Math.min(number.size(), bigInteger.getValueAsStringList().size());
    for (int i = 0; i < len; i++) {
      
      String first = number.get(i);
      String second = bigInteger.getValueAsStringList().get(i);
      StringWithCarry sc = addStringWithCarry(first, second, carry);
      
      carry = sc.carry;
      finalList.add(sc.string);
    }
    
    if(number.size()>len) {
      for (int i = len; i < number.size(); i++) {
        finalList.add(number.get(i));
      }
    }else {
      for (int i = len; i < bigInteger.getValueAsStringList().size(); i++) {
        finalList.add(bigInteger.getValueAsStringList().get(i));
      }
    }
    
    Collections.reverse(finalList);
    return new BigInteger(finalList);
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
    
    for (int i = 0; i < s.length(); i+=chunkSize) {
      int endIndex = i + chunkSize >= s.length() ? s.length() : i + chunkSize;
      
      String chunk = s.substring(i, endIndex);
      ret.add(chunk);
    }
    
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
