package logandeal.finalprojectfx;

/**
 *
 * @author logan
 */

// Exception for when an empty is given
public class EmptyTextBoxException extends RuntimeException {

  @Override
  public String getMessage() {
      return "Empty fields are not valid submissions.";
  }
}
