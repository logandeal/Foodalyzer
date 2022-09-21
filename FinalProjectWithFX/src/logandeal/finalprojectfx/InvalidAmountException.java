package logandeal.finalprojectfx;

/**
 *
 * @author logan
 */

// Exception for when an invalid 'generic' amount is given
public class InvalidAmountException extends Exception {
  Amount<Integer> invalid_int;
  Amount<Float> invalid_float;

  public InvalidAmountException (int price) {
    invalid_int = new Amount<>(price);
  }

  public InvalidAmountException (float price) {
    invalid_float = new Amount<>(price);
  }

  @Override
  public String getMessage() {
    if (invalid_int != null)
      return invalid_int + " is not a valid amount.";
    if (invalid_float != null) 
      return String.format("$%.2f is not a valid amount.", invalid_float);
    return "Invalid amount.";
  }
}
