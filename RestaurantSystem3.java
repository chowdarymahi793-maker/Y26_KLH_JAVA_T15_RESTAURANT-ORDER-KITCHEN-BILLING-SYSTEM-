import java.util.Scanner;

public class RestaurantSystem3 {

    
    static int calculateBill(int price, int qty) {
        return price * qty;
    }

    
    static int calculateBill(int[] prices, int[] qtys) {
        int total = 0;
        for(int i=0; i<prices.length; i++) {
            total += prices[i] * qtys[i];
        }
        return total;
    }

    
    static int factorial(int n) {
        if(n == 0 || n == 1) return 1;   
        return n * factorial(n-1);       
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        String[] items = {"Pizza", "Burger", "Pasta", "Coffee"};
        int[] prices = {250, 150, 200, 100};

        
        System.out.println("------ Menu ------");
        for(int i=0; i<items.length; i++) {
            System.out.println((i+1) + ". " + items[i] + " - ₹" + prices[i]);
        }

        
        System.out.print("Enter item number (1-4): ");
        int choice = sc.nextInt();
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        
        int total = calculateBill(prices[choice-1], qty);
        System.out.println("Total Bill: ₹" + total);

        
        int orderID = factorial(choice);
        System.out.println("Generated Kitchen Order ID: " + orderID);

        
        int[] bills = {total, 400, 600};
        int sum = 0;
        for(int b : bills) {   
            sum += b;
        }
        double avg = (double) sum / bills.length;
        System.out.println("Average Bill Amount: ₹" + avg);

        
        int[][] billMatrix1 = {{100,200},{300,400}};
        int[][] billMatrix2 = {{10,20},{30,40}};
        int[][] result = new int[2][2];

        for(int i=0; i<2; i++) {
            for(int j=0; j<2; j++) {
                result[i][j] = billMatrix1[i][j] + billMatrix2[i][j];
            }
        }

        System.out.println("Matrix Addition Result:");
        for(int i=0; i<2; i++) {
            for(int j=0; j<2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}

    

