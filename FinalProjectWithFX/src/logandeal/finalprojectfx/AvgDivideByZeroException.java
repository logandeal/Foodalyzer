package logandeal.finalprojectfx;

/**
 *
 * @author logan
 */

// Exception for when an invalid meal char is given
public class AvgDivideByZeroException extends RuntimeException {

  @Override
  public String getMessage() {
      return "Unable to compute average due to division by zero.";
  }
}
