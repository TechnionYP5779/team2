package fluent.ly;

import java.util.*;

import static fluent.ly.unbox.*;
import static fluent.ly.box.*;

import static il.org.spartan.Utils.*;

public class BigInteger {
  private List<String> number;
  private static final int chunkSize = 5;
  private Boolean negative = box(false);
  private String stringNumber;

  public BigInteger(final String string) {
    String absString = absoluteVal(string);
    stringNumber = absString;
    number = breakStringToList(absString);
    negative = isStringNegative(string);
  }
  
  public Boolean isNegative() {
    return negative;
  }
  
  public Boolean isZero() {
    return box(number.size() == 1 && "0".equals(number.get(0)));
  }
  
  private static Boolean isZero(List<String> $) {
    return box($.size() == 1 && "0".equals($.get(0)));
  }
  
  private static Boolean isFirstBiggerThanSecond(String number1, String number2) {
    return box(number1.length() == number2.length() ? number1.compareTo(number2) < 0 : number1.length() > number2.length());
  }
  
  public Boolean isBiggerThan(BigInteger $) {
    cantBeNull($);
    String firstStr = stringNumber;
    String secondStr = $.getStringNumber();
    if (firstStr.length() != secondStr.length()) {
      if (firstStr.length() > secondStr.length()) {
        return box(!unbox(cantBeNull(this.negative)));
      }
      return $.isNegative();
    }
    if (firstStr.compareTo(secondStr) > 0) {
      return box(!unbox(cantBeNull(this.negative)));
    }
    if (firstStr.compareTo(secondStr) == 0)
      return box(!unbox(cantBeNull(this.negative)) && unbox(cantBeNull($.isNegative())));
    return box(!unbox(cantBeNull($.isNegative())));
  }
  
  private String getStringNumber() {
    return stringNumber;
  }
  
  private static Boolean isStringNegative(String ¢){
    return box(¢.charAt(0) == '-');
  }
  
  

  private static String absoluteVal(String ¢) {
    return !unbox(cantBeNull(isStringNegative(¢))) ? ¢ : ¢.substring(1);
  }

  public BigInteger( final List<String> stringList,Boolean isNegative) {
    negative = isNegative;
    number = stringList;
    this.stringNumber = stringList.stream().reduce("", (str1, str2)->str1.concat(str2));
  }

  @Override public int hashCode() {
    return Objects.hash(number);
  }

  @Override public boolean equals(final Object ¢) {
    return ¢ == this || ¢ != null && ¢ instanceof BigInteger && Objects.equals(number, ((BigInteger) ¢).number) && (negative == ((BigInteger) ¢).negative);
  }
  
  public static Boolean isFinalAnswerNegativeAdd(Boolean firstSignIsNagative, Boolean isZero) {
    return box(!unbox(cantBeNull(isZero)) && unbox(cantBeNull(firstSignIsNagative)));
  }

  public BigInteger add(final BigInteger bigInteger) {
    final List<String> $ = new ArrayList<>();
    int carry = 0;
    boolean isAdd = (negative == bigInteger.isNegative());
    boolean isThisBiggerThanOther = unbox(cantBeNull(isFirstBiggerThanSecond(this.stringNumber, bigInteger.getStringNumber())));
    final List<String> biggerTmp = new ArrayList<>(isThisBiggerThanOther ? this.number : bigInteger.getValueAsStringList());
    final List<String> smallerTmp = new ArrayList<>(!isThisBiggerThanOther ? this.number : bigInteger.getValueAsStringList());
    
    Collections.reverse(biggerTmp);
    Collections.reverse(smallerTmp);
    
    for (int i = 0; i < smallerTmp.size(); ++i) {
      final StringWithCarry sc = addOrRemoveStringWithCarry(biggerTmp.get(i), smallerTmp.get(i), carry, box(isAdd));
      carry = sc.carry;
      $.add(sc.string);
    }
    
    for (int i = smallerTmp.size(); i < biggerTmp.size(); ++i) {
      final StringWithCarry sc = addOrRemoveStringWithCarry(biggerTmp.get(i), "0", carry, box(isAdd));
      carry = sc.carry;
      $.add(sc.string);
    }
    
     
    if (carry != 0)
      $.add(String.valueOf(carry));
    Collections.reverse($);
    return new BigInteger($, isFinalAnswerNegativeAdd(this.isNegative(),isZero($)));
  }
  
  private static StringWithCarry addOrRemoveStringWithCarry(final String s1, final String s2, final int carry, Boolean isAdd) {
    return unbox(cantBeNull(isAdd)) ? addStringWithCarry(s1, s2, carry) : removeStringWithCarry(s1, s2, carry);
  }

  private static String addStringsSimple(final String s1, final String s2, final int carry) {
    return String.valueOf(Integer.parseInt(s1) + Integer.parseInt(s2) + carry);
  }

  private static StringWithCarry addStringWithCarry(final String s1, final String s2, final int carry) {
    final String $ = addStringsSimple(s1, s2, carry);
    return $.length() <= chunkSize ? new StringWithCarry($, 0) : new StringWithCarry($.substring(1), Character.getNumericValue($.charAt(0)));
  }
  
  private static String removeStringsSimple(final String s1, final String s2, final int carry) {
    return String.valueOf(Integer.parseInt(s1) - carry - Integer.parseInt(s2));
  }

  private static StringWithCarry removeStringWithCarry(final String s1, final String s2, final int carry) {
    String $ = removeStringsSimple(s1, s2, carry);
    return new StringWithCarry($, 0);
   
  }

  private List<String> getValueAsStringList() {
    return number;
  }

  private static List<String> breakStringToList(final String s) {
    final List<String> $ = new ArrayList<>();
    for (int ¢ = s.length(); ¢ > 0; ¢ -= chunkSize)
      $.add(s.substring(¢ - chunkSize <= 0 ? 0 : ¢ - chunkSize, ¢));
    Collections.reverse($);
    return $;
  }

  static class StringWithCarry {
    public String string;
    public int carry;

    public StringWithCarry(final String string, final int carry) {
      this.string = string;
      this.carry = carry;
    }
  }

  public BigInteger negate() {
    
    return new BigInteger(this.number, box(!unbox(cantBeNull(this.isZero())) && !unbox(cantBeNull(this.isNegative()))));
  }
  
  public void print() {
    System.out.println(unbox(cantBeNull(negative))? "-" : "+");
    for(String ¢: number)
      System.out.println(¢);
  }

  public BigInteger subtract(BigInteger bigInteger) {
    return this.add(bigInteger.negate());
  }
}
