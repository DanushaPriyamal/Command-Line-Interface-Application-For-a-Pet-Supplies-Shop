import ShopSystem.CashierTask;
import ShopSystem.ManagerTask;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        MainMenuDisplay();
    }

    // This for choosing user types and run functions of the system
    public static void MainMenuDisplay() {
        try {
            System.out.println(); // Line spacing
            System.out.println("-----Welcome to the Paws shop system-----");
            System.out.println();
            System.out.println("User types to login.....");
            System.out.println("1.Manager");
            System.out.println("2.Cashier");
            System.out.println("3.Enter number 3 to exit");
            System.out.println();
            System.out.print("Enter the user type number to login: ");

            Scanner choice = new Scanner(System.in);
            int x = choice.nextInt(); // Get user input

            if (x == 1) {
                ManagerTask MT = new ManagerTask(); // Run "ManagerTask" class
                MT.ManagerLogin();
            }

            else if (x == 2) {
                CashierTask Cash_Task = new CashierTask(); // Run "CashierTask" class
                Cash_Task.CashierLoginSystem();
            }

            // This for exiting from the system
            else if (x == 3) {
                System.out.println();
                System.out.println("Exiting from the system.....");
                System.out.println();
            }

            else {
                System.out.println();
                System.out.println("Invalid input. Please try again.....");

                MainMenuDisplay();
            }

            choice.close();

        } catch (Exception e) {
            System.out.println();
            System.out.println("Invalid input. Please try again.....");

            MainMenuDisplay();
        }
    }
}
