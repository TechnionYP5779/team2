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
  Integer getCost();
  
  /**
   * This method is used to update the price data to a new value
   * @param Integer which represents the new price.
   */
  void update(Integer newPrice);
}
