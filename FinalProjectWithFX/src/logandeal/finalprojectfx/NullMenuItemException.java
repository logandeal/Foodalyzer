package logandeal.finalprojectfx;

/**
 *
 * @author logan
 */

// Exception for when a null MenuItem is given
public class NullMenuItemException extends RuntimeException {

  @Override
  public String getMessage() {
    return "Null MenuItem is not allowed.";
  }
}
