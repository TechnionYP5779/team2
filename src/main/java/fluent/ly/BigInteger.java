package fluent.ly;

import java.util.*;

public class BigInteger {
  
  private List<String> number;
  private static final int chunkSize = 5;

  public BigInteger(String string) {
    number = breakStringToList(string);
  }
  
  public BigInteger(List<String> stringList) {
    number = stringList;
  }
  
  @Override public int hashCode() {
    return Objects.hash(number);
  }

  @Override public boolean equals(Object ¢) {
    return ¢ == this || (¢ != null && ¢ instanceof BigInteger && Objects.equals(number, ((BigInteger) ¢).number));
  }

  public BigInteger add(BigInteger bigInteger) {
    List<String> $ = new ArrayList<>();
    
    int carry = 0, len = Math.min(number.size(), bigInteger.getValueAsStringList().size());
    
    List<String> tmp1 = new ArrayList<>(number), tmp2 = new ArrayList<>(bigInteger.getValueAsStringList());
    Collections.reverse(tmp1);
    Collections.reverse(tmp2);
    
    for (int i = 0; i < len; ++i) {
      
      StringWithCarry sc = addStringWithCarry(tmp1.get(i), tmp2.get(i), carry);
      
      carry = sc.carry;
      $.add(sc.string);
    }
    
    if(tmp1.size()>len)
      for (int i = len; i < tmp1.size(); ++i) {
        StringWithCarry sc = addStringWithCarry(tmp1.get(i), "0", carry);
        carry = sc.carry;
        $.add(sc.string);
      }
    else
      for (int i = len; i < tmp2.size(); ++i) {
        StringWithCarry sc = addStringWithCarry(tmp2.get(i), "0", carry);
        carry = sc.carry;
        $.add(sc.string);
      }
    
    if(carry != 0)
      $.add(String.valueOf(carry));
    
    Collections.reverse($);
    return new BigInteger($);
  }
  
  private static String addStringsSimple(String s1, String s2, int carry) {
    return String.valueOf(Integer.parseInt(s1)+Integer.parseInt(s2)+ carry);
  }
  
  private static StringWithCarry addStringWithCarry(String s1, String s2, int carry) {
    String $ = addStringsSimple(s1, s2, carry);
    return $.length() <= chunkSize ? new StringWithCarry($, 0) : new StringWithCarry($.substring(1), Character.getNumericValue($.charAt(0)));
  }
  
  private List<String> getValueAsStringList() {
    return number;
  }
  
  private static List<String> breakStringToList(String s){
    List<String> $ = new ArrayList<>();
    
    for (int ¢ = s.length() ; ¢ > 0; ¢-=chunkSize)
      $.add(s.substring(¢ - chunkSize <= 0 ? 0 : ¢ - chunkSize, ¢));
    Collections.reverse($);
    return $;
  }
  
  @SuppressWarnings("unused") private void printStringArray() {
    for(String ¢ : number)
      System.out.println(¢);
    System.out.println("------------------------");
  }
  
  static class StringWithCarry{
    public String string;
    public int carry;
    
    public StringWithCarry(String string, int carry) {
      this.string = string;
      this.carry = carry;
    }
    
  }
}
