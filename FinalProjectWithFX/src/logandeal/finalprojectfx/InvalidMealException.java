package logandeal.finalprojectfx;

/**
 *
 * @author logan
 */

// Exception for when an invalid meal char is given
public class InvalidMealException extends RuntimeException {
  char invalid_meal;

  public InvalidMealException(char meal) {
    invalid_meal = meal;
  }

  @Override
  public String getMessage() {
      return "The char " + invalid_meal + " does not represent a valid meal.";
  }
}
