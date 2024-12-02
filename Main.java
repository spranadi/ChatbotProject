import java.util.Scanner;




public class Main {
   static String[] yes = {"yes", "yeah", "yea"};
   static String[] no = {"no", "nope"};
   static String[] generalMenu = {"Burgers", "Fries", "Shakes", "Beverages"};
   static String[] randomResponses = {
       "I'm not sure what you mean, can you rephrase that?",
       "Sorry, I didn't catch that. Could you try again?",
       "Hmm, I'm not familiar with that. Please input a valid response.",
       "Sorry, I don't understand. Could you clarify?",
       "Sorry, that's not a valid option. Could you try again?"
   };
    public static void displayImage() {
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String YELLOW = "\u001B[33m";
        final String WHITE = "\u001B[37m";
        final String BROWN = "\u001B[38;5;94m"; 


        System.out.println();
        System.out.println(YELLOW + "        ______________" + RESET);
        System.out.println(YELLOW + "       /              \\" + RESET);
        System.out.println(YELLOW + "      /~~~~~~~~~~~~~~~~\\" + RESET);
        System.out.println(GREEN + "     |   ~~~~~~~~~~~~   |" + RESET);
        System.out.println(GREEN + "     |   Lettuce Layer  |" + RESET);
        System.out.println(RED + "     |   Tomato Layer   |" + RESET);
        System.out.println(BROWN + "     |    Beef Patty    |" + RESET);
        System.out.println(GREEN + "     |   Pickle Layer   |" + RESET);
        System.out.println(YELLOW + "      \\________________/" + RESET);
        System.out.println(YELLOW + "        ``````````````" + RESET);
        System.out.println(WHITE + "      Thank you for your order!" + RESET);
        System.out.println();
    }








   public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       System.out.println("Type 'exit' at any point to end the conversation.");
       System.out.println("When ordering, please type in the exact name of the item you would like to order.");
       System.out.println(" ");
       String welcome = "Welcome to In-N-Out! I'll be assisting you with your order today. Would you like to see our menu?(yes/no)";
       System.out.println(welcome);




       String[] orderItems = new String[10];
       double totalPrice = 0;
       int totalCalories = 0;
       int currentIndex = 0;




   while (true) {
   String userResp1 = in.nextLine().toLowerCase();




   if (userResp1.equals("exit")) {
     System.out.println("Thank you for coming to In-N-Out, see you next time!");
     System.exit(0);
    }




   if (userResp1.equals("no")) {
       System.out.println("Thank you for coming to In-N-Out, see you next time!");
       System.exit(0);
    }




   if (userResp1.equals("yes") || userResp1.indexOf("y") != -1) {
       String menuQuestion = "Here's what's on our menu today. Select from:";
       System.out.println(menuQuestion);
   for (String item : generalMenu) {
       System.out.println("- " + item);
   }




     while (true) {
       // System.out.println("What would you like to order?");
     String userResp2 = in.nextLine().toLowerCase();




    if (userResp2.equals("exit")) {
       System.out.println("Thank you for coming to In-N-Out, see you next time!");
       System.exit(0);
   }




     boolean orderMade = false;




    if (userResp2.indexOf("burger") >= 0) {
    if (currentIndex < orderItems.length) {
       orderItems[currentIndex] = orderBurger(in);
       totalPrice += Food.burgers[currentIndex].getPrice();
       totalCalories += Food.burgers[currentIndex].getCalories();
       currentIndex++;
       orderMade = true;
       }
   else {
       System.out.println("Sorry, you've reached the maximum order limit.");
         }
       }
   else if (userResp2.indexOf("fries") >= 0) {
       if (currentIndex < orderItems.length) {
       orderItems[currentIndex] = orderFries(in);
       totalPrice += Food.fries[currentIndex].getPrice();
       totalCalories += Food.fries[currentIndex].getCalories();
       currentIndex++;
       orderMade = true;
       }
   else {
       System.out.println("Sorry, you've reached the maximum order limit.");
       }
       }
   else if (userResp2.indexOf("shake") >= 0) {
       if (currentIndex < orderItems.length) {
       orderItems[currentIndex] = orderShake(in);
       totalPrice += Food.shakes[currentIndex].getPrice();
       totalCalories += Food.shakes[currentIndex].getCalories();
       currentIndex++;
       orderMade = true;
       }
       else {
       System.out.println("Sorry, you've reached the maximum order limit.");
                       }
                   }
       else if (userResp2.indexOf("beverage") >= 0) {
           if (currentIndex < orderItems.length) {
        orderItems[currentIndex] = orderSoda(in);
        totalPrice += Food.beverage[currentIndex].getPrice();
        totalCalories += Food.beverage[currentIndex].getCalories();
        currentIndex++;
        orderMade = true;
           }
       else {
       System.out.println("Sorry, you've reached the maximum order limit.");
       }
       }
       else {
       randomResponse("What would you like to order?");
       }
       if (orderMade) {
       while (true) {
       System.out.println("Would you like to order anything else? (yes/no)");
       String continueOrder = in.nextLine().toLowerCase();
       if (continueOrder.equals("no") || continueOrder.equals("exit")) {
        System.out.println("Thank you for your order! Here's your summary:");
        showOrderSummary(orderItems);
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("Total Calories: " + totalCalories + " cal");
        System.out.println("Have a nice day, and enjoy your food! Come back soon!");
        displayImage();
         break;
           }
       else if (continueOrder.equals("yes") || continueOrder.indexOf("y") != -1) {
        System.out.println("Here's what's on our menu today. Select from:");
       for (String item : generalMenu) {
        System.out.println("- " + item);
           }
       break;
            }
       else {
        randomResponse("Would you like to order anything else? (yes/no)");
                        }
                    }
                 }
             }
           }
       else {
        randomResponse("Would you like to see our menu? (yes/no)");
           }
       }
   }




   //METHODS




   public static void randomResponse(String prevQ) {
       int randomIndex = (int) (Math.random() * randomResponses.length);
       System.out.println(randomResponses[randomIndex]);
      // System.out.println("Here's the previous question:");
      // System.out.println(prevQ);
   }




   public static String orderBurger(Scanner in) {
       System.out.println("What kind of burger would you like? Please select from the options below:");
       for (int i = 0; i < Food.burgers.length; i++) {
           System.out.println("- " + Food.burgers[i]);
       }
       String input = in.nextLine().toLowerCase();
       while (true) {
           boolean valid = false;
           for (int i = 0; i < Food.burgers.length; i++) {
               if (input.equals(Food.burgers[i].getName().toLowerCase())) {
                   System.out.println("You ordered a " + Food.burgers[i].getName() + ".");
                   valid = true;
                   return Food.burgers[i].getName();
               }
           }
           if (valid) {
               break;
           }
           randomResponse("What kind of burger would you like to order? Please select from one of our options.");
           input = in.nextLine().toLowerCase();
       }
       return "";
   }




   public static String orderFries(Scanner in) {
       System.out.println("What kind of fries would you like? Please select from the options below:");
       for (int i = 0; i < Food.fries.length; i++) {
           System.out.println("- " + Food.fries[i]);
       }
       String input = in.nextLine().toLowerCase();
       while (true) {
           boolean valid = false;
           for (int i = 0; i < Food.fries.length; i++) {
               if (input.equals(Food.fries[i].getName().toLowerCase())) {
                   System.out.println("You ordered " + Food.fries[i].getName() + ".");
                   valid = true;
                   return Food.fries[i].getName();
               }
           }
           if (valid) {
               break;
           }
           randomResponse("What kind of fries would you like to order? Please select from one of our options.");
           input = in.nextLine().toLowerCase();
       }
       return "";
   }



   
   public static String orderShake(Scanner in) {
       System.out.println("What kind of shake would you like? Please select from the options below:");
       for (int i = 0; i < Food.shakes.length; i++) {
           System.out.println("- " + Food.shakes[i]);
       }
       String input = in.nextLine().toLowerCase();
       while (true) {
           boolean valid = false;
           for (int i = 0; i < Food.shakes.length; i++) {
               if (input.equals(Food.shakes[i].getName().toLowerCase())) {
                   System.out.println("You ordered a " + Food.shakes[i].getName() + ".");
                   valid = true;
                   return Food.shakes[i].getName();
               }
           }
           if (valid) {
               break;
           }
           randomResponse("What kind of shake would you like to order? Please select from one of our options.");
           input = in.nextLine().toLowerCase();
       }
       return "";
   }




   public static String orderSoda(Scanner in) {
       System.out.println("What kind of beverage would you like? Please select from the options below:");
       for (int i = 0; i < Food.beverage.length; i++) {
           System.out.println("- " + Food.beverage[i]);
       }
       String input = in.nextLine().toLowerCase();
       while (true) {
           boolean valid = false;
           for (int i = 0; i < Food.beverage.length; i++) {
               if (input.equals(Food.beverage[i].getName().toLowerCase())) {
                   System.out.println("You ordered a " + Food.beverage[i].getName() + ".");
                   valid = true;
                   return Food.beverage[i].getName();
               }
           }
           if (valid) {
               break;
           }
           randomResponse("What kind of beverage would you like to order? Please select from one of our options.");
           input = in.nextLine().toLowerCase();
       }
       return "";
   }




   public static void showOrderSummary(String[] orderItems) {
       for (String item : orderItems) {
           if (item != null) {
               System.out.println("- " + item);
           }
       }
   }
}

//    public static String orderSecret(Scanner in) {
//     System.out.println("You've selected to order from our Secret menu. Please select from the options below:");
//     for (int i = 0; i < secretBurger.length; i++) {
//         System.out.println("- " + secretBurger[i]);
//     }




//     Scanner x = new Scanner (System.in);
//     String input = x.nextLine().toLowerCase();




//     if (input.equals(secretBurger[0]) || input.equals(secretBurger[1]) || input.equals(secretBurger[2]) || input.equals(secretBurger[3]) || input.equals(secretBurger[4]) || input.equals(secretBurger[5])) {
//         System.out.println("You ordered a "+ input+".");
//     }
//     return "Sorry, I didn't understand. Please select from the items listed above.";
//  }
