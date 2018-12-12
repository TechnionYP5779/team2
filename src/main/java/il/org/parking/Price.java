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
   * @return Integer which represents the price of the object
   */
  double getCost();
  
  /**
   * This method is used to update the price data to a new value
   * @param Integer which represents the new price to set
   */
  void update(double newPrice);
  
  /**
   * This method is used to update the price data to a new value
   * by another Price object
   * @param Integer which represents the new price to set
   */
  void update(Price newPrice);
}
