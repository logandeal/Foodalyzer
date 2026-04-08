# Foodalyzer

Hello! The project I have created is called **Foodalyzer**.
Hopefully, that name is intriguing enough to make you want to read past this introductory
sentence, but if not, keep reading anyway (please)!
I. Overview
According to colby.edu, over a quarter of American adults eat fast food daily.
That information should be enough to grasp the widespread popularity of fast food. However,
fast food isn’t always cheap, and with prices ever increasing, it can be hard to tell if you’re
getting your money’s worth.
This is only a bigger problem for college students, given that we typically have less to spend
than an average working-class adult. This problem has motivated me to create **Foodalyzer** , a
fast food analyzer application. **Foodalyzer** allows you to discover what menu items and
combinations of menu items get you the most bang for your buck based on calorie and
monetary amounts, so that you can spend less on fast food meals while putting more in your
belly.
II. Purpose
The purpose of this project is to provide users with a simple and quick computational tool for
getting your money’s worth at fast food restaurants. Here are some notable advantages of my
application:

- Flexible
    - New fast food restaurants and menu items can be easily added
    - Both breakfast and non-breakfast items are organized in the system
- User-focused
    - Users can easily specify exact calorie and monetary amounts that fit their diet
       and budget
- Analytical
    - Restaurants can be easily compared based on stats like average price and
       calories per dollar through menu items and restaurants entered in the system


III. Functionalities and How To Use
The main functionalities of my application consist of inserting and viewing data, and interacting
with the data.
**Inserting and viewing data:**
When the program starts, you can only interact with one button in the window: the new
restaurant button. Once you have clicked that button, you are prompted to specify the name of
the restaurant and then click done.
Once you have entered a restaurant, you are then able to create menu items that correlate with
created restaurants. When you create a new menu item, you are prompted to enter in the name,
price, and calories of the item, and select if it is part of the breakfast menu or not.
You must also select (click) what restaurant the menu item corresponds to before you can enter
it into the system by clicking done. Restaurants are shown on the left list view and menu items
are shown on the right list view once they have been created.
Important note: the menu items on the right list view only correlate to the selected restaurant on
the left list view (i.e. not all menu items in the system may be shown at once).
**Interacting with the data:**
Once restaurants and menu items are entered in the system, users have the full ability to
interact with them.
Here is what you can do:

- Select restaurants to view corresponding menu items
    - As referred to previously, you can select a restaurant on the left list view to view
       what menu items correspond to that restaurant
- Get average price for a restaurant
    - You can click the get average price button to compute the average price for a
       selected restaurant
- Get average calories per dollar for a restaurant
    - You can click the get average cal/$ button to compute the average calories per
       dollar for a selected restaurant
- Get value meal
    - You can retrieve a customized value meal for a specified number of dollars or
       calories
    - As its name suggests, the value meal computes a bang-for-your-buck meal that
       prioritizes the highest value menu items for the selected restaurant
    - Once you have entered an amount into the text field and selected an option from
       the dropdown, you can click the get value meal for button to compute the value
       meal and view it in the list view below


Note: I planned to include more functionality in the JavaFX application, but due to time
constraints, I did not implement all of the functionality in my source code in the JavaFX
application.
For example, I wrote the code to keep track of the highest value menu item, but I did not
incorporate that into the JavaFX application. That is why there are some unused methods in the
source code.
IV. Elements

1. Classes
    a. Amount.java
    b. Foodalyzer.java
    c. Item.java
    d. Menu.java
    e. MenuItem.java
    f. MyFXController.java
    g. Restaurant.java
2. Subclasses
    a. MenuItem.java is a subclass of Item.java
    b. AvgDivideByZeroException.java is a subclass of RuntimeException
    c. EmptyTextBoxException.java is a subclass of RuntimeException
    d. Foodalyzer.java is a subclass of Application
    e. InvalidAmountException.java is a subclass of Exception
    f. InvalidMealException.java is a subclass of RuntimeException
    g. InvalidPriceException.java is a subclass of Exception
    h. NullMenuItemException.java is a subclass of RuntimeException
3. Abstract class
    a. Item.java
4. Interface
    a. IMenu.java
5. Collections
    a. Restaurant ArrayList in Foodalyzer.java, line 21
    b. MenuItem ArrayList in Menu.java, line 12, 116, 129, 151, 177 and
       Restaurant.java, line 29, 189, 197
    c. ListView uses collections in MyFXController.java, lines 41-
6. Exceptions
    a. AvgDivideByZeroException.java
    b. EmptyTextBoxException.java
    c. InvalidAmountException.java
    d. InvalidMealException.java
    e. InvalidPriceException.java
    f. NullMenuItemException.java


7. Exception Handling
Handled exception classes (non-runtime exceptions):
a. InvalidAmountException.java
b. InvalidPriceException.java
Where they are used:
a. setPrice() throws InvalidPriceException in Item.java, line 31
i. Try-catch statement in Item.java, lines 15-
b. AddNewMenuItem() throws InvalidAmountException in Menu.java, line 43
i. Try-catch statement in MenuItem.java, lines 20-
c. GetMenuItemsForDollarAmount() throws InvalidAmountException in Menu.java,
line 115
i. Try-catch statement in Menu.java, lines 142-
d. GetMenuItemsForCalorieAmount() throws InvalidAmountException in Menu.java,
line 128
i. Try-catch statement in Menu.java, lines 168-
e. setCalories() throws InvalidAmountException in MenuItem.java, line 35
i. Try-catch statement in MenuItem.java, lines 20-
V. Special Implementation
- The generic Amount.java class was used in InvalidAmountException.java to allow
both integers and floats to be handled when that exception is thrown
- Floats for prices
- Integers for calories
- MenuItem is comparable by calories per dollar, which is used to deduce the value
of the menu item combinations
More implementation notes are provided in the source code comments.
VI. Rubric Efforts
See next page.


User experience:

- Some functionality is disabled (grayed out) until it is relevant, making it clear what the
    user needs to do to begin interacting with the application
- Users are unlikely to make mistakes; data can only be entered if it meets intuitive criteria
    (e.g. text fields cannot be blank)
       - Likewise, functions can only be computed if they meet intuitive criteria (e.g. there
          is at least one menu item corresponding to a restaurant in order to compute
          average price)
- JavaFX GUI elements are intuitively spaced on screen for minimal confusion
- Extraneous elements are kept to a minimum
    - Everything in the application serves a purpose
- Application was created with the idea that form follows function to ensure design
    aesthetics do not get in the way of the functionality of the application
Consistent design:
- All JavaFX GUI design elements are visually coherent
- All JavaFX GUI elements were given intuitive placements on the screen
Well-structured:
- Encapsulation is heavily used in the source code, making it easy to make design
changes if needed


- Repeated code is kept to a minimum (helper methods are used as needed)
- Code comments are used, but not overused
- m_ variable naming was used as needed
Purpose and novelty:
- I thought of the idea for this application when I was having trouble figuring out how to get
the best value meal when I went to go get fast food, so it not only solves my own
problem, but has the potential to solve the same problem for others
- The application is presented professionally and compactly (i.e. not too much and not too
little functionality)


