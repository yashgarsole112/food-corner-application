import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class VC {
    String name;
    double price;
int Qty;

    VC(String name, double price, int Qty) {
        this.name = name;
        this.price = price;
        this.Qty=Qty;
    }

    void display() {
        System.out.println(name + " - Rs " + price );
        System.out.println(Qty + " quantity avaliable " );
    }
}

class Order {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        VC[] menus = {
                new VC("Onion Pizza", 349,5),
                new VC("Cheese Pizza", 299,5),
                new VC("Corn Pizza", 249,5),
                new VC("Chicken Pizza", 349,5),
                new VC("Paneer Pizza", 449,5)
        };

        List<VC> cart = new ArrayList<>();

        int choice;

        System.out.println("Welcome to Yash's Pizza Corner!");

        do {
            System.out.println("MENU ");
            for (int i = 0; i < menus.length; i++) {
                System.out.print((i + 1) + ". ");
                menus[i].display();
            }
            System.out.println("6. View Your Order");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 5) {
                cart.add(menus[choice - 1]);
                System.out.println(menus[choice - 1].name + " added to your cart.");
            } else if (choice == 6) {
                if (cart.isEmpty()) {
                    System.out.println("Your cart is empty!");
                } else {
                    System.out.println("Your Current Order:");
                    double total = 0;
                    for (VC v : cart) {
                        System.out.println(v.name + " - Rs " + v.price);
                        total += v.price;
                    }
                    System.out.println("Total Price: Rs " + total);
                }
            } else if (choice != 0) {
                System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 0);


        System.out.println(" Final Bill ");
        if (cart.isEmpty()) {
            System.out.println("You did not order anything.");
        } else {
            double total = 0;
            for (VC v : cart) {
                System.out.println(v.name + " Rs " + v.price);
                total += v.price;
            }
            System.out.println("Total Price: Rs " + total);
        }

        System.out.println("Thank you for ordering from Yash's Pizza Corner!");
    }
}
