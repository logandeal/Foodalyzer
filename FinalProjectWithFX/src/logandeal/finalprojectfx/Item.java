package logandeal.finalprojectfx;

/**
 *
 * @author logan
 */

// Basic abstract class representing a generic item
public abstract class Item {
  String m_name;
  float m_price;

  public Item(String name, float price) {
    setName(name);
    try {
      setPrice(price);
    }
    catch (InvalidPriceException err) { 
      System.out.println("***Error: Negative price not allowed.***");
      System.out.println(err.getMessage());
      System.out.println();
    }
  }

  public final void setName(String name) {
    m_name = name;
  }

  public final void setPrice(float price) throws InvalidPriceException {
    if (price < 0) 
      throw new InvalidPriceException(price);
    m_price = price;  
  }

  public final String getName() {
    return m_name;
  }

  public final float getPrice() {
    return m_price;
  }
}
