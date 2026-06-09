package ShopSystem;

import java.util.Scanner;

public class ManagerTask {

    // Manager login
    public void ManagerLogin() {
        String username = "admin"; // Manager username
        String password = "123"; // Manager password

        Scanner ML = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter username: ");
        String un = ML.nextLine();

        System.out.print("Enter password: ");
        String pass = ML.nextLine();

        if (un.equals(username) && pass.equals(password)) {
            System.out.println();
            System.out.println("Login Successfully......");

            ManagerTaskDisplay();
        }

        else {
            System.out.println();
            System.out.println("Inavalid username or password....");
            System.out.println();
        }

        ML.close();

    }

    public void ManagerTaskDisplay() {
        try {
            System.out.println();
            System.out.println("Logged as Manager.....");
            System.out.println();
            System.out.println("Manager level functionalities.....");
            System.out.println("1. Create new user account for cashier");
            System.out.println("2. View all the pet supplies details");
            System.out.println("3. Add new pet supplies details");
            System.out.println("4. Search pet supplies details");
            System.out.println("5. Enter number 5 to exit");
            System.out.println();
            System.out.print("Enter the function number to proceed: ");

            Scanner Function_Choice = new Scanner(System.in);
            int y = Function_Choice.nextInt();

            if (y == 1) {
                // Run "CashierUserAccountCreation" class
                CashierUserAccountCreation CUA = new CashierUserAccountCreation();
                CUA.CreateNewUserAccount();
            }

            else if (y == 2) {
                System.out.println();

                ViewPetSupplies V_Pet_S = new ViewPetSupplies(); // Run "ViewPetSupplies" class
                V_Pet_S.ViewSupplies();
            }

            else if (y == 3) {
                AddPetSupplies A_Pet_S = new AddPetSupplies(); // Run "AddPetSupplies" class
                A_Pet_S.AddSupplies();
            }

            else if (y == 4) {
                SearchPetSupplies S_Pet_S = new SearchPetSupplies(); // Run "SearchPetSupplies" class
                S_Pet_S.SearchSupplies();
            }

            else if (y == 5) {
                System.out.println();
                System.out.println("Exiting from the system.....");
                System.out.println();
            }

            else {
                System.out.println();
                System.out.println("Invalid input. Please try again.....");

                ManagerTaskDisplay();
            }

            Function_Choice.close();

        } catch (Exception e) {
            System.out.println();
            System.out.println("Invalid input. Please try again.....");

            ManagerTaskDisplay();
        }

    }
}
