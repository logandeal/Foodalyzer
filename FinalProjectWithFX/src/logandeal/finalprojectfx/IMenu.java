package logandeal.finalprojectfx;

/**
 *
 * @author logan
 */

// Menu interface for the basic methods a menu requires
public interface IMenu {
  Object MenuItemAt(int index);
  void AddMenuItem(MenuItem item);
  Object [] AsArray();
  Object [] AsReversedArray();
  Object [] AsSortedArray();
}
