import java.util.Scanner;

public class RestaurantSystem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;
        int grandTotal = 0;

        
        do {
            System.out.println("\n------ Menu ------");
            System.out.println("1. Pizza - ₹250");
            System.out.println("2. Burger - ₹150");
            System.out.println("3. Pasta - ₹200");
            System.out.println("4. Coffee - ₹100");
            System.out.println("0. Exit");

            System.out.print("Enter item number: ");
            choice = sc.nextInt();

            if(choice == 0) {
                break; 
            }

            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            String itemName = "";
            int price = 0;

            
            switch(choice) {
                case 1: itemName = "Pizza"; price = 250; break;
                case 2: itemName = "Burger"; price = 150; break;
                case 3: itemName = "Pasta"; price = 200; break;
                case 4: itemName = "Coffee"; price = 100; break;
                default: 
                    System.out.println("Invalid choice!");
                    continue; 
            }

            
            if(qty > 5) {
                System.out.println("Kitchen: Large order received!");
            } else {
                System.out.println("Kitchen: Preparing " + qty + " " + itemName + "(s)");
            }

            
            int total = price * qty;
            grandTotal += total;

            System.out.println("Item: " + itemName + " | Quantity: " + qty + " | Total: ₹" + total);

        } while(true); 

        
        int discount = 0;
        if(grandTotal >= 500) {
            discount = 50;
        }

        int finalAmount = grandTotal - discount;

        System.out.println("\n------ FINAL BILL ------");
        System.out.println("Grand Total: ₹" + grandTotal);
        System.out.println("Discount: ₹" + discount);
        System.out.println("Final Payable Amount: ₹" + finalAmount);
        System.out.println("Order Status: Sent to Kitchen ");

        sc.close();
    }
}

    

