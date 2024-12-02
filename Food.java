public class Food {
    private String name;
    private double price;
    private int calories;
    public Food(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }
    public String toString() {
        return name + " - $" + price + " - " + calories + " cal";
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getCalories() {
        return calories;
    }
//menu(detailed)
    public static Food[] burgers = {
        new Food("Double-Double", 4.19, 670),
        new Food("Cheeseburger", 2.95, 480),
        new Food("Hamburger", 2.65, 390)
    };
    public static Food[] fries = {
        new Food("Normal Fries", 1.95, 370),
        new Food("Animal Style Fries", 2.50, 450)
    };
    public static Food[] beverage = {
        new Food("Coke", 1.50, 140),
        new Food("Diet Coke", 1.50, 0),
        new Food("Cherry Coke", 1.50, 150),
        new Food("7Up", 1.50, 150),
        new Food("Dr. Pepper", 1.50, 150),
        new Food("Root Beer", 1.50, 160),
        new Food("Pink Lemonade", 1.75, 120),
        new Food("Lite Pink Lemonade", 1.75, 90),
        new Food("Iced Tea", 1.25, 80),
        new Food("Milk", 1.75, 150),
        new Food("Coffee", 1.25, 0),
        new Food("Hot Cocoa", 2.00, 200)
    };
    public static Food[] shakes = {
    new Food("Strawberry Shake", 2.50, 590),
    new Food("Vanilla Shake", 2.50, 590),
    new Food("Chocolate Shake", 2.50, 590)
    };   
}