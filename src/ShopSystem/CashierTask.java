package ShopSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CashierTask extends ManagerTask {
    private static final String C_Login = "CashierUsernameandPassword.txt";

    // This is for cashier login
    public void CashierLoginSystem() {
        Scanner CL = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter username: ");
        String username = CL.nextLine();

        System.out.print("Enter password: ");
        String password = CL.nextLine();

        if (UserAuthentication(username, password)) {
            System.out.println();
            System.out.println("Login successfully.....");

            CashierTaskDisplay();
        }

        else {
            System.out.println();
            System.out.println("Invalid username or password.....");
            System.out.println();
        }

        CL.close();

    }

    @SuppressWarnings("resource")
    private static boolean UserAuthentication(String username, String password) {
        BufferedReader CUA_Reader;

        try {
            CUA_Reader = new BufferedReader(new FileReader(C_Login));

            String Cashier_L_Line;

            while ((Cashier_L_Line = CUA_Reader.readLine()) != null) {
                String[] User_Login_Credentials = Cashier_L_Line.split(" "); // Split the line by space

                if (User_Login_Credentials.length == 2) {
                    String Cashier_Username = User_Login_Credentials[0];
                    String Cashier_Password = User_Login_Credentials[1];

                    if (Cashier_Username.equals(username) && Cashier_Password.equals(password)) {
                        return true; // Authentication successful
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file for username and password.....");
            e.printStackTrace();
        }

        return false;
    }

    // This is for cashier task functions
    public void CashierTaskDisplay() {
        try {
            System.out.println();
            System.out.println("Logged as Cashier.....");
            System.out.println();
            System.out.println("Cashier level functionalities.....");
            System.out.println("1. View all the pet supplies details");
            System.out.println("2. Add new pet supplies details");
            System.out.println("3. Search pet supplies details");
            System.out.println("4. Enter number 4 to exit");
            System.out.println();
            System.out.print("Enter the function number to proceed: ");

            Scanner Cashier_Level_Functions = new Scanner(System.in);
            int z = Cashier_Level_Functions.nextInt();

            if (z == 1) {
                System.out.println();
                
                ViewPetSupplies V_Pet_S = new ViewPetSupplies();
                V_Pet_S.ViewSupplies();
            }

            else if (z == 2) {
                AddPetSupplies A_Pet_S = new AddPetSupplies();
                A_Pet_S.AddSupplies();
            }

            else if (z == 3) {
                SearchPetSupplies S_Pet_S = new SearchPetSupplies();
                S_Pet_S.SearchSupplies();
            }

            else if (z == 4) {
                System.out.println();
                System.out.println("Exiting from the system.....");
                System.out.println();
            }

            else {
                System.out.println();
                System.out.println("Invalid input. Please try again.....");

                CashierTaskDisplay();
            }

            Cashier_Level_Functions.close();

        } catch (Exception e) {
            System.out.println();
            System.out.println("Invalid input. Please try again.....");

            CashierTaskDisplay();
        }
    }
}
