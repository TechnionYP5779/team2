package fluent.ly;

import static il.org.spartan.Utils.*;

import static fluent.ly.box.*;
import static fluent.ly.unbox.*;

import java.util.*;

public class BigInteger {
  private final List<String> number;
  private static final int chunkSize = 5;
  private Boolean negative = box(false);
  private final String stringNumber;

  public BigInteger(final String string) {
    final String absString = absoluteVal(string);
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

  private static Boolean isZero(final List<String> $) {
    return box($.size() == 1 && "0".equals($.get(0)));
  }

  private static Boolean isFirstBiggerThanSecond(final String number1, final String number2) {
    return box(number1.length() == number2.length() ? number1.compareTo(number2) < 0 : number1.length() > number2.length());
  }

  public Boolean isBiggerThan(final BigInteger $) {
    cantBeNull($);
    final String firstStr = stringNumber;
    final String secondStr = $.getStringNumber();
    return firstStr.length() == secondStr.length()
        ? box(firstStr.compareTo(secondStr) > 0 ? !unbox(cantBeNull(negative))
            : firstStr.compareTo(secondStr) != 0 ? unbox(cantBeNull($.isNegative()))
                : !unbox(cantBeNull(negative)) && unbox(cantBeNull($.isNegative())))
        : firstStr.length() > secondStr.length() ? box(!unbox(cantBeNull(negative))) : $.isNegative();
  }

  private String getStringNumber() {
    return stringNumber;
  }

  private static Boolean isStringNegative(final String ¢) {
    return box(¢.charAt(0) == '-');
  }

  private static String absoluteVal(final String ¢) {
    return !unbox(cantBeNull(isStringNegative(¢))) ? ¢ : ¢.substring(1);
  }

  public BigInteger(final List<String> stringList, final Boolean isNegative) {
    negative = isNegative;
    number = stringList;
    stringNumber = stringList.stream().reduce("", (str1, str2) -> str1.concat(str2));
  }

  @Override public int hashCode() {
    return Objects.hash(number);
  }

  @Override public boolean equals(final Object ¢) {
    return ¢ == this
        || ¢ instanceof BigInteger && Objects.equals(number, ((BigInteger) ¢).number) && negative == ((BigInteger) ¢).negative;
  }

  public static Boolean isFinalAnswerNegativeAdd(final Boolean firstSignIsNagative, final Boolean isZero) {
    return box(!unbox(cantBeNull(isZero)) && unbox(cantBeNull(firstSignIsNagative)));
  }

  public BigInteger add(final BigInteger bigInteger) {
    final List<String> $ = new ArrayList<>();
    int carry = 0;
    final boolean isAdd = negative == bigInteger.isNegative();
    final boolean isThisBiggerThanOther = unbox(cantBeNull(isFirstBiggerThanSecond(stringNumber, bigInteger.getStringNumber())));
    final List<String> biggerTmp = new ArrayList<>(isThisBiggerThanOther ? number : bigInteger.getValueAsStringList());
    final List<String> smallerTmp = new ArrayList<>(!isThisBiggerThanOther ? number : bigInteger.getValueAsStringList());
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
    return new BigInteger($, isFinalAnswerNegativeAdd(isNegative(), isZero($)));
  }

  private static StringWithCarry addOrRemoveStringWithCarry(final String s1, final String s2, final int carry, final Boolean isAdd) {
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
    final String $ = removeStringsSimple(s1, s2, carry);
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
    return new BigInteger(number, box(!unbox(cantBeNull(this.isZero())) && !unbox(cantBeNull(isNegative()))));
  }

  public BigInteger subtract(final BigInteger ¢) {
    return add(¢.negate());
  }
}
