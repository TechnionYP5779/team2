package fluent.ly;

public class BigInteger {
  
  String number;
  
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof BigInteger)) {
      return false;
    }
    BigInteger bi = (BigInteger)o;
    return true;
  }

  public BigInteger(String string) {
    number = string;
    // TODO Auto-generated constructor stub
  }
  
  private String getValueAsString() {
    return number;
  }

  public BigInteger add(BigInteger bigInteger) {
    // TODO Auto-generated method stub
    return new BigInteger(String.valueOf(Integer.parseInt(number)+Integer.parseInt(bigInteger.getValueAsString())));
  }
}
