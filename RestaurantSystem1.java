import java.util.Scanner;

public class RestaurantSystem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("------ Welcome to Restaurant ------");
        System.out.println("Menu:");
        System.out.println("1. Pizza - ₹250");
        System.out.println("2. Burger - ₹150");
        System.out.println("3. Pasta - ₹200");
        System.out.println("4. Coffee - ₹100");

        
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter item number (1-4): ");
        int item = sc.nextInt();

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        
        String itemName = "";
        int price = 0;

        if(item == 1) {
            itemName = "Pizza"; price = 250;
        } else if(item == 2) {
            itemName = "Burger"; price = 150;
        } else if(item == 3) {
            itemName = "Pasta"; price = 200;
        } else if(item == 4) {
            itemName = "Coffee"; price = 100;
        } else {
            System.out.println("Invalid choice!");
            sc.close();
            return;
        }

        int total = price * qty;
        int discount = 0;
        if(total >= 500) {
            discount = 50;
        }
        int finalAmount = total - discount;

        
        System.out.println("\n------ BILL ------");
        System.out.println("Customer: " + name);
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + qty);
        System.out.println("Total Amount: ₹" + total);
        System.out.println("Discount: ₹" + discount);
        System.out.println("Final Payable Amount: ₹" + finalAmount);
        System.out.println("Order Status: Sent to Kitchen ");

        sc.close();
    }
}
