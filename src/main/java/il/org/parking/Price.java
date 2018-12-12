package il.org.parking;

/**
 * This interface describes price
 * @version 1.0
 * @author Addir Abasker
 */
public interface Price {
  /**
   * This method is used to inform the user of the price of 
   * some object.
   * @return Double which represents the price of the object
   */
  Double getCost();
  
  /**
   * This method is used to update the price data to a new value
   * @param Double which represents the new price.
   */
  void update(Double newPrice);
}