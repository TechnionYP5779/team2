package il.org.parking;
import static fluent.ly.box.*;
public class ParkingPrice implements Price{
  private Double price=box(0.0);
  
  public ParkingPrice(Double price){
    this.price=price;
  }
  @Override public Double getCost() {
    return price;
  }

  @Override public void update(Double newPrice) {
    price=newPrice;
  }
}