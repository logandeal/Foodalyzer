package logandeal.finalprojectfx;

// import org.w3c.dom.NameList;

/**
 *
 * @author logan
 */

// MenuItem class that holds information about an individual item to be put on the menu
public class MenuItem extends Item implements Comparable<MenuItem> {
    int m_calories;
    int m_calories_per_dollar;

    // Keeps track of what the best value MenuItem is
    static MenuItem currentBestValueMenuItem = null;

    public MenuItem(String name, float price, int calories, Boolean call_best_value) {
      super(name, price);
      try {
        setCalories(calories);
      }
      catch (InvalidAmountException err) {
        System.out.println("***Error: Calorie amount not allowed.***");
        System.out.println(err.getMessage());
        System.out.println();
      }
      setCaloriesPerDollar(name, price, calories);
      if (call_best_value)
        setCurrentBestValueMenuItem(name, price, calories);
    }

    public final void setCalories(int calories) throws InvalidAmountException {
      if (calories < 0)
        throw new InvalidAmountException(calories);
      m_calories = calories;
    }    

    public final void setCaloriesPerDollar(String name, float price, int calories) {
      m_calories_per_dollar = CalculateCaloriesPerDollar(price, calories);
    }

    public int CalculateCaloriesPerDollar(float price, int calories) {
      return Math.round(calories/price);
    }

    public final void setCurrentBestValueMenuItem(String name, float price, int calories) {
      if (currentBestValueMenuItem == null) 
        currentBestValueMenuItem = new MenuItem(name, price, calories, false);
      else {
        if (m_calories_per_dollar > currentBestValueMenuItem.m_calories_per_dollar) {
          currentBestValueMenuItem.m_name = name;
          currentBestValueMenuItem.m_price = price;
          currentBestValueMenuItem.m_calories = calories;
          currentBestValueMenuItem.m_calories_per_dollar = m_calories_per_dollar;
        }
      }
    }

    public final int getCalories() {
      return m_calories;
    }

    public final int getCaloriesPerDollar() {
      return m_calories_per_dollar;
    }

    @Override 
    public String toString() {
      return String.format("%s: $%.2f, %d calories, %d calories/$\n", m_name, m_price, m_calories, m_calories_per_dollar);
    }
    
    // Comparable by m_calories_per_dollar
    @Override
    public int compareTo(MenuItem item) {
        return Integer.compare(m_calories_per_dollar, item.m_calories_per_dollar);
    }
}
