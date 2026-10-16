import java.io.*;
import java.nio.file.*;
import java.util.*;


class MenuEntry {
    private String name;
    private double price;

    public MenuEntry(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " - ₹" + price;
    }
}


class FoodItem extends MenuEntry {
    public FoodItem(String name, double price) {
        super(name, price);
    }
}


interface Billable {
    double calculateBill();
}


class Order implements Billable {
    private List<MenuEntry> items = new ArrayList<>();
    private String customerName;

    public Order(String customerName) {
        this.customerName = customerName;
    }

    public void addItem(MenuEntry item) {
        if (item == null) throw new NullPointerException("Item cannot be null!");
        items.add(item);
    }

    @Override
    public double calculateBill() {
        return items.stream().mapToDouble(MenuEntry::getPrice).sum();
    }

    public void printBill() {
        System.out.println("\n------ BILL ------");
        System.out.println("Customer: " + customerName);
        items.forEach(System.out::println);
        System.out.println("Total: ₹" + calculateBill());
    }

    
    public void saveBillToFile() {
        try {
            Path path = Paths.get("bill.txt");
            BufferedWriter writer = Files.newBufferedWriter(path);
            writer.write("Customer: " + customerName + "\n");
            for (MenuEntry item : items) {
                writer.write(item.toString() + "\n");
            }
            writer.write("Total: ₹" + calculateBill() + "\n");
            writer.close();
            System.out.println("Bill saved to bill.txt ✅");
        } catch (IOException e) {
            System.out.println("Error saving bill: " + e.getMessage());
        }
    }
}

public class MenuItem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        List<MenuEntry> menu = Arrays.asList(
            new FoodItem("Pizza", 250),
            new FoodItem("Burger", 150),
            new FoodItem("Pasta", 200),
            new FoodItem("Coffee", 100)
        );

        System.out.println("------ Welcome to Wonder's Restaurant ------");
        menu.forEach(System.out::println);

                System.out.print("Enter your name: ");
        String customerName = sc.nextLine();
        Order order = new Order(customerName);

        
        while (true) {
            System.out.print("Enter item name (or 'done' to finish): ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("done")) break;

                        Optional<MenuEntry> selected = menu.stream()
                    .filter(m -> m.getName().equalsIgnoreCase(choice))
                    .findFirst();

            if (selected.isPresent()) {
                order.addItem(selected.get());
                System.out.println(choice + " added!");
            } else {
                System.out.println("Item not found!");
            }
        }

        
        order.printBill();
        order.saveBillToFile();

                System.out.println("\nSorted Menu by Price:");
        menu.stream()
            .sorted(Comparator.comparingDouble(MenuEntry::getPrice))
            .forEach(System.out::println);

        sc.close();
    }
} 
    

