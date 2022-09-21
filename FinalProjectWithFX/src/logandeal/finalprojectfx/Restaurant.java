package logandeal.finalprojectfx;

import java.util.*;

/**
 *
 * @author logan
 */

// Restaurant class that holds information about the restaurant, including name and Menus 
public class Restaurant {
  String m_name;
  Menu breakfast = null;
  Menu lunch_dinner = null;

  public Restaurant(String name) {
    breakfast = new Menu();
    lunch_dinner = new Menu();
    setName(name);
  }

  public final void setName(String name) {
    m_name = name;
  }

  // All methods provided below are encapsulator or auxiliary methods 
  
  public ArrayList<MenuItem> getAllMenuItems() {
      ArrayList<MenuItem> entire_menu = new ArrayList<>();
      entire_menu.addAll(breakfast.GetAllMenuItems());
      entire_menu.addAll(lunch_dinner.GetAllMenuItems());
      return entire_menu;
  }

  public Object getMenuItemAt(int index, char meal) {
      switch (meal) {
          case 'b' -> {
              return breakfast.MenuItemAt(index);
          }
          case 'd' -> {
              return lunch_dinner.MenuItemAt(index);
          }
          default -> throw new InvalidMealException(meal);
      }
  }

  public void addMenuItem(MenuItem item, char meal) {
      switch (meal) {
          case 'b' -> breakfast.AddMenuItem(item);
          case 'd' -> lunch_dinner.AddMenuItem(item);
          default -> throw new InvalidMealException(meal);
      }
  }

  public void addNewMenuItem(String name, float price, int calories, char meal) {
    MenuItem item = new MenuItem(name, price, calories, true);
      switch (meal) {
          case 'b' -> breakfast.AddMenuItem(item);
          case 'd' -> lunch_dinner.AddMenuItem(item);
          default -> throw new InvalidMealException(meal);
      }
  }

  public Object [] asArray(char meal) {
      switch (meal) {
          case 'b' -> {
              return breakfast.AsArray();
          }
          case 'd' -> {
              return lunch_dinner.AsArray();
          }
          default -> throw new InvalidMealException(meal);
      }
  }

  public Object [] asReversedArray(char meal) {
      switch (meal) {
          case 'b' -> {
              return breakfast.AsReversedArray();
          }
          case 'd' -> {
              return lunch_dinner.AsReversedArray();
          }
          default -> throw new InvalidMealException(meal);
      }
  }

  public Object [] asSortedArray(char meal) {
      switch (meal) {
          case 'b' -> {
              return breakfast.AsSortedArray();
          }
          case 'd' -> {
              return lunch_dinner.AsSortedArray();
          }
          default -> throw new InvalidMealException(meal);
      }
  }

  public float avgPrice() {
      if (breakfast.isEmptyMenu()) {
          return lunch_dinner.AvgPrice();
      }
      else if (lunch_dinner.isEmptyMenu()) {
          return breakfast.AvgPrice();
      }
      float breakfast_weight = getBreakfastWeight();
      float lunch_dinner_weight = getLunch_DinnerWeight();
      
      return ((breakfast.AvgPrice()*breakfast_weight) + (lunch_dinner.AvgPrice()*lunch_dinner_weight));
  }

  public int avgCaloriesPerDollar() {
      if (breakfast.isEmptyMenu()) {
          return lunch_dinner.AvgCaloriesPerDollar();
      }
      else if (lunch_dinner.isEmptyMenu()) {
          return breakfast.AvgCaloriesPerDollar();
      }
      float breakfast_weight = getBreakfastWeight();
      float lunch_dinner_weight = getLunch_DinnerWeight();
      
      return (int)((breakfast.AvgCaloriesPerDollar()*breakfast_weight) + (lunch_dinner.AvgCaloriesPerDollar()*lunch_dinner_weight));
  }
  
  public float getBreakfastWeight() {
      float breakfast_size = breakfast.getSize();
      float lunch_dinner_size = lunch_dinner.getSize();
      float total = breakfast_size + lunch_dinner_size;
      return breakfast_size/total;
  }
  
    public float getLunch_DinnerWeight() {
      float breakfast_size = breakfast.getSize();
      float lunch_dinner_size = lunch_dinner.getSize();
      float total = breakfast_size + lunch_dinner_size;
      return lunch_dinner_size/total;
  }

  public Object [] getMenuItemsForDollarAmount(float amount, char meal) throws InvalidAmountException {
      switch (meal) {
          case 'b' -> {
              return breakfast.GetMenuItemsForDollarAmount(amount);
          }
          case 'd' -> {
              return lunch_dinner.GetMenuItemsForDollarAmount(amount);
          }
          default -> throw new InvalidMealException(meal);
      }
  }

    public Object [] getMenuItemsForCalorieAmount(int amount, char meal) throws InvalidAmountException {
      switch (meal) {
          case 'b' -> {
              return breakfast.GetMenuItemsForCalorieAmount(amount);
          }
          case 'd' -> {
              return lunch_dinner.GetMenuItemsForCalorieAmount(amount);
          }
          default -> throw new InvalidMealException(meal);
      }
    }
  
    public Object [] valueMealForDollars(float amount, char meal) {
      switch (meal) {
          case 'b' -> {
              return breakfast.ValueMealForDollars(amount);
          }
          case 'd' -> {
              return lunch_dinner.ValueMealForDollars(amount);
          }
          default -> throw new InvalidMealException(meal);
      }
    }
  
    public Object [] valueMealForCalories(int amount, char meal) {
      switch (meal) {
          case 'b' -> {
              return breakfast.ValueMealForCalories(amount);
          }
          case 'd' -> {
              return lunch_dinner.ValueMealForCalories(amount);
          }
          default -> throw new InvalidMealException(meal);
      }
    }
    
    public ArrayList<MenuItem> getValueMealForDollars(float amount, char meal) {
        ArrayList<MenuItem> value_meal_list = new ArrayList<>();
        Object [] object_array = valueMealForDollars(amount, meal);
        MenuItem [] menu_array = objectToMenuItem(object_array, meal);
        value_meal_list.addAll(Arrays.asList(menu_array));
        return value_meal_list;
    }
    
    public ArrayList<MenuItem> getValueMealForCalories(int amount, char meal) {
        ArrayList<MenuItem> value_meal_list = new ArrayList<>();
        Object [] object_array = valueMealForCalories(amount, meal);
        MenuItem [] menu_array = objectToMenuItem(object_array, meal);
        value_meal_list.addAll(Arrays.asList(menu_array));
        return value_meal_list;        
    }
    
    public MenuItem [] objectToMenuItem(Object [] object_items, char meal) {
      switch (meal) {
          case 'b' -> {
              return breakfast.ObjectToMenuItem(object_items);
          }
          case 'd' -> {
              return lunch_dinner.ObjectToMenuItem(object_items);
          }
          default -> throw new InvalidMealException(meal);
      }
  }
    
    @Override 
    public String toString() {
      return m_name;
    }
}