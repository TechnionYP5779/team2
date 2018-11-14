package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;

public class BigInteger {
  private List<String> number;
  private static final int chunkSize = 5;
  private Boolean negative = Boolean.FALSE;

  public BigInteger(final String string) {
    String absString = absoluteVal(string);
    number = breakStringToList(absString);
    negative = box.box(Integer.parseInt(absString) < 0);
  }

  public Boolean isNegative() {
    return negative;
  }

  private static Boolean isStringNegative(String ¢) {
    return box.box(¢.charAt(0) == '-');
  }

  private static String absoluteVal (String ¢) {
    return !(isStringNegative(¢)) ? ¢ : ¢.substring(1);
  }

  public BigInteger(final List<String> stringList, Boolean isNegative) {
    negative = isNegative;
    number = stringList;
  }

  @Override public int hashCode() {
    return Objects.hash(number);
  }

  @Override public boolean equals(final Object ¢) {
    return ¢ == this
        || ¢ != null && ¢ instanceof BigInteger && Objects.equals(number, ((BigInteger) ¢).number) && (negative == ((BigInteger) ¢).negative);
  }

  public BigInteger add(final BigInteger bigInteger) {
    final List<String> $ = new ArrayList<>();
    int carry = 0;
    final int len = Math.min(number.size(), bigInteger.getValueAsStringList().size());
    @NotNull Boolean isAdd = box.box(negative == bigInteger.isNegative());
    final List<String> tmp1 = new ArrayList<>(number), tmp2 = new ArrayList<>(bigInteger.getValueAsStringList());
    Collections.reverse(tmp1);
    Collections.reverse(tmp2);
    for (int i = 0; i < len; ++i) {
      final StringWithCarry sc = addOrRemoveStringWithCarry(tmp1.get(i), tmp2.get(i), carry, isAdd);
      carry = sc.carry;
      $.add(sc.string);
    }
    if (tmp1.size() > len)
      for (int i = len; i < tmp1.size(); ++i) {
        final StringWithCarry sc = addOrRemoveStringWithCarry(tmp1.get(i), "0", carry, isAdd);
        carry = sc.carry;
        $.add(sc.string);
      }
    else
      for (int i = len; i < tmp2.size(); ++i) {
        final StringWithCarry sc = addOrRemoveStringWithCarry(tmp2.get(i), "0", carry, isAdd);
        carry = sc.carry;
        $.add(sc.string);
      }
    if (carry != 0)
      $.add(String.valueOf(carry));
    Collections.reverse($);
    return new BigInteger($, box.box(carry == 1));
  }

  private static StringWithCarry addOrRemoveStringWithCarry(final String s1, final String s2, final int carry, @NotNull Boolean isAdd) {
    return unbox.unbox(isAdd) ? addStringWithCarry(s1, s2, carry) : removeStringWithCarry(s1, s2, carry);
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
    return null;
  }
}
