package fluent.ly;

import java.util.*;

public class BigInteger {
  private final List<String> number;
  private static final int chunkSize = 5;

  public BigInteger(final String string) {
    number = breakStringToList(string);
  }

  public BigInteger(final List<String> stringList) {
    number = stringList;
  }

  @Override public int hashCode() {
    return Objects.hash(number);
  }

  @Override public boolean equals(final Object ¢) {
    return ¢ == this || ¢ != null && ¢ instanceof BigInteger && Objects.equals(number, ((BigInteger) ¢).number);
  }

  public BigInteger add(final BigInteger bigInteger) {
    final List<String> $ = new ArrayList<>();
    int carry = 0;
    final int len = Math.min(number.size(), bigInteger.getValueAsStringList().size());
    final List<String> tmp1 = new ArrayList<>(number), tmp2 = new ArrayList<>(bigInteger.getValueAsStringList());
    Collections.reverse(tmp1);
    Collections.reverse(tmp2);
    for (int i = 0; i < len; ++i) {
      final StringWithCarry sc = addStringWithCarry(tmp1.get(i), tmp2.get(i), carry);
      carry = sc.carry;
      $.add(sc.string);
    }
    if (tmp1.size() > len)
      for (int i = len; i < tmp1.size(); ++i) {
        final StringWithCarry sc = addStringWithCarry(tmp1.get(i), "0", carry);
        carry = sc.carry;
        $.add(sc.string);
      }
    else
      for (int i = len; i < tmp2.size(); ++i) {
        final StringWithCarry sc = addStringWithCarry(tmp2.get(i), "0", carry);
        carry = sc.carry;
        $.add(sc.string);
      }
    if (carry != 0)
      $.add(String.valueOf(carry));
    Collections.reverse($);
    return new BigInteger($);
  }

  private static String addStringsSimple(final String s1, final String s2, final int carry) {
    return String.valueOf(Integer.parseInt(s1) + Integer.parseInt(s2) + carry);
  }

  private static StringWithCarry addStringWithCarry(final String s1, final String s2, final int carry) {
    final String $ = addStringsSimple(s1, s2, carry);
    return $.length() <= chunkSize ? new StringWithCarry($, 0) : new StringWithCarry($.substring(1), Character.getNumericValue($.charAt(0)));
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
}
