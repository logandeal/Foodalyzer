package logandeal.finalprojectfx;

/**
 *
 * @author logan
 */

// Generic Amount T type
public class Amount<T> {
  T m_object;

  Amount(T object) {
    m_object = object;
  }

  public T getObject() {
    return m_object;
  }
}
