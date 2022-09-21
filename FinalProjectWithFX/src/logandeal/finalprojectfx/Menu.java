package logandeal.finalprojectfx;

import java.util.*;

/**
 *
 * @author logan
 */

// Menu class that holds MenuItems and implements the basic interface plus additional methods and functionality
public class Menu implements IMenu {
  ArrayList<MenuItem> menu_items = null;

  public Menu() {
    menu_items =  new ArrayList<>();
  }
  
  // Returns whether or not menu is empty
  public boolean isEmptyMenu() {
      return menu_items.isEmpty();
  }
  
  // Returns size of menu
  public int getSize() {
      return menu_items.size();
  }
  
  // Gets all menu items in an array list form
  public ArrayList<MenuItem> GetAllMenuItems() {
      return menu_items;
  }

  // Gets the MenuItem at a specified index
  @Override
  public Object MenuItemAt(int index) {
    return menu_items.get(index);    
  }

  // Adds the specified MenuItem to the menu
  @Override
  public void AddMenuItem(MenuItem item) {
    if (item == null) 
      throw new NullMenuItemException();
    else
      menu_items.add(item);
  }

  // Adds a new specified MenuItem to the menu
  public void AddNewMenuItem(String name, float price, int calories) throws InvalidAmountException {
    MenuItem item = new MenuItem(name, price, calories, true);
    AddMenuItem(item);
  }

  // Returns the menu as an array
  @Override
  public Object [] AsArray() {
    return menu_items.toArray();
  }

  // Returns the menu as a reversed array
  @Override
  public Object [] AsReversedArray() {
    return reverseArray(menu_items.toArray());
  }

  // Helper method to reverse the array
  public Object [] reverseArray(Object [] arr) {
    for(int i = 0; i < arr.length / 2; i++) {
        Object temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;
    }
    return arr;
  }

  // Returns the menu as a sorted array (descending in terms of cal/dollar)
  @Override
  public Object [] AsSortedArray() {
    return sortArray(menu_items);
  }

  // Helper method to sort a specified array
  public Object [] sortArray(ArrayList<MenuItem> items) {
    Object [] regular_arr = items.toArray();
    Arrays.sort(regular_arr);
    regular_arr = reverseArray(regular_arr);
    return regular_arr;
  }

  // Returns the average price of MenuItems in the menu
  public float AvgPrice() {
    if (menu_items.isEmpty())
        throw new AvgDivideByZeroException();
    float total_cost = 0;
    for (MenuItem item : menu_items) {
      total_cost += item.m_price;
    }
    return total_cost/menu_items.size();
  }

  // Returns the average calories per dollar for the menu
  public int AvgCaloriesPerDollar() {
    if (menu_items.isEmpty())
        throw new AvgDivideByZeroException();
    int total_cal_per_dollar = 0;
    for (MenuItem item : menu_items) {
      total_cal_per_dollar += item.m_calories_per_dollar;
    }
    return total_cal_per_dollar/menu_items.size();
  }

  // Returns a sorted array of individual MenuItems for a specified dollar amount
  public Object [] GetMenuItemsForDollarAmount(float amount) throws InvalidAmountException {
    if (amount < 0)
      throw new InvalidAmountException(amount);
    ArrayList<MenuItem> items = new ArrayList<>();
    for (MenuItem item : menu_items) {
      if (item.m_price <= amount) {
        items.add(item);
      }
    }
    return sortArray(items);
  }

  // Returns a sorted array of individual MenuItems for a specified calorie amount
  public Object [] GetMenuItemsForCalorieAmount(int amount) throws InvalidAmountException {
    if (amount < 0)
      throw new InvalidAmountException(amount);
    ArrayList<MenuItem> items = new ArrayList<>();
    for (MenuItem item : menu_items) {
      if (item.m_calories <= amount) {
        items.add(item);
      }
    }
    return sortArray(items);
  }

  // Returns a sorted array of grouped MenuItems for a specified dollar amount
  public Object [] ValueMealForDollars(float amount) {
    float left_to_spend = amount;
    Object [] object_items = null;
    try {
      object_items = GetMenuItemsForDollarAmount(amount);
    }
    catch (InvalidAmountException err) {
      System.out.println("***Error: Dollar amount not allowed.***");
      System.out.println(err.getMessage());
      System.out.println();
    }
    MenuItem items[] = ObjectToMenuItem(object_items);
    ArrayList<MenuItem> value_meal = new ArrayList<>();
    for (var item : items) {
      if (item.m_price <= left_to_spend) {
        value_meal.add(item);
        left_to_spend -= item.m_price;
        if (amount == 0) {
          break;
        }
      }
    }
    return value_meal.toArray();
  }

  // Returns a sorted array of grouped MenuItems for a specified calorie amount
  public Object [] ValueMealForCalories(int amount) {
    float left_to_spend = amount;
    Object [] object_items = null;
    try {
      object_items = GetMenuItemsForCalorieAmount(amount);
    }
    catch (InvalidAmountException err) {
      System.out.println("***Error: Calorie amount not allowed.***");
      System.out.println(err.getMessage());
      System.out.println();      
    }
    MenuItem items[] = ObjectToMenuItem(object_items);
    ArrayList<MenuItem> value_meal = new ArrayList<>();
    for (var item : items) {
      if (item.m_calories <= left_to_spend) {
        value_meal.add(item);
        left_to_spend -= item.m_calories;
        if (amount == 0) {
          break;
        }
      }
    }
    return value_meal.toArray();
  }

  // Helper method for converting Object array to MenuItem array
  public MenuItem [] ObjectToMenuItem(Object [] object_items) {
    MenuItem items[] = new MenuItem[object_items.length];
    for (int i = 0; i < object_items.length; i++){
      items[i] = (MenuItem)object_items[i];
    }
    return items;
  }
}


