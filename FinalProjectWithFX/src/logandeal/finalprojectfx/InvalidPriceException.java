package logandeal.finalprojectfx;

/**
 *
 * @author logan
 */

// Exception for when an invalid price is given
public class InvalidPriceException extends Exception {
  float invalid_price;

  public InvalidPriceException(float price) {
    invalid_price = price;
  }

  @Override
  public String getMessage() {
    return String.format("$%.2f is not a valid price.", invalid_price);
  }
}
