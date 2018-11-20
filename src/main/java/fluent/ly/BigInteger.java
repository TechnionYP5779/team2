package fluent.ly;

import java.util.*;
import java.util.function.*;

import javax.sound.midi.*;
import javax.swing.plaf.basic.BasicTreeUI.*;

public class BigInteger {
  private List<String> number;
  private static final int chunkSize = 5;
  private Boolean negative = false;
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
    return number.size() == 1 && "0".equals(number.get(0));
  }
  
  private static Boolean isZero(List<String> $) {
    return $.size() == 1 && "0".equals($.get(0));
  }
  
  private static Boolean isFirstBiggerThanSecond(String number1, String number2) {
    return number1.length() == number2.length() ? number1.compareTo(number2) < 0 : number1.length() > number2.length();
  }
  
  public Boolean isBiggerThan(BigInteger $) {
    String firstStr = stringNumber;
    String secondStr = $.getStringNumber();
    if (firstStr.length() != secondStr.length()) {
      if (firstStr.length() > secondStr.length()) {
        System.out.println("1");
        return !this.negative;
      }
      System.out.println("2");
      return $.isNegative();
    }
    if (firstStr.compareTo(secondStr) > 0) {
      System.out.println("3");
      return !this.negative;
    }
    if (firstStr.compareTo(secondStr) == 0)
      return !this.negative && $.isNegative();
    System.out.println("4");
    return !$.isNegative();
  }
  
  private String getStringNumber() {
    return stringNumber;
  }
  
  private static Boolean isStringNegative(String ¢){
    return ¢.charAt(0) == '-';
  }
  
  

  private static String absoluteVal(String ¢) {
    return !isStringNegative(¢) ? ¢ : ¢.substring(1);
  }

  public BigInteger(final List<String> stringList,Boolean isNegative) {
    negative = isNegative;
    number = stringList;
  }

  @Override public int hashCode() {
    return Objects.hash(number);
  }

  @Override public boolean equals(final Object ¢) {
    return ¢ == this || ¢ != null && ¢ instanceof BigInteger && Objects.equals(number, ((BigInteger) ¢).number) && (negative == ((BigInteger) ¢).negative);
  }
  
  public static Boolean isFinalAnswerNegativeAdd(Boolean firstSignIsNagative, Boolean secondSignIsNegative, Boolean isZero) {
    return !isZero && firstSignIsNagative;
  }

  public BigInteger add(final BigInteger bigInteger) {
    final List<String> $ = new ArrayList<>();
    int carry = 0;
    boolean isAdd = (negative == bigInteger.isNegative());
    final List<String> biggerTmp = new ArrayList<>(isFirstBiggerThanSecond(this.stringNumber, bigInteger.getStringNumber()) ? this.number : bigInteger.getValueAsStringList());
    final List<String> smallerTmp = new ArrayList<>(!isFirstBiggerThanSecond(this.stringNumber, bigInteger.getStringNumber()) ? this.number : bigInteger.getValueAsStringList());
    
    Collections.reverse(biggerTmp);
    Collections.reverse(smallerTmp);
    
    for (int i = 0; i < smallerTmp.size(); ++i) {
      final StringWithCarry sc = addOrRemoveStringWithCarry(biggerTmp.get(i), smallerTmp.get(i), carry, isAdd);
      carry = sc.carry;
      $.add(sc.string);
    }
    
    for (int i = smallerTmp.size(); i < biggerTmp.size(); ++i) {
      final StringWithCarry sc = addOrRemoveStringWithCarry(biggerTmp.get(i), "0", carry, isAdd);
      carry = sc.carry;
      $.add(sc.string);
    }
    
     
    if (carry != 0)
      $.add(String.valueOf(carry));
    Collections.reverse($);
    return new BigInteger($, isFinalAnswerNegativeAdd(this.isNegative(), bigInteger.isNegative(),isZero($)));
  }
  
  private static StringWithCarry addOrRemoveStringWithCarry(final String s1, final String s2, final int carry, Boolean isAdd) {
    return isAdd ? addStringWithCarry(s1, s2, carry) : removeStringWithCarry(s1, s2, carry);
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
    if (!isStringNegative($))
      return new StringWithCarry($, 0);
    $ = $.substring(1);
    return new StringWithCarry($, 1);
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
    
    return new BigInteger(this.number, !this.isZero() && !this.isNegative());
  }
  
  public void print() {
    System.out.println(negative? "-" : "+");
    for(String ¢: number)
      System.out.println(¢);
  }
}
