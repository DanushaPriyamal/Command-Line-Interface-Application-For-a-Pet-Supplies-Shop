package ShopSystem;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class CashierUserAccountCreation extends ManagerTask {
    // Text file to enter cashier usernames and passwords
    private static final String UserAccount = "CashierUsernameandPassword.txt";

    public void CreateNewUserAccount() {
        Scanner CNUA = new Scanner(System.in);

        System.out.println();

        System.out.print("Enter a username: ");
        String username = CNUA.nextLine(); // Assign input value to 'username'

        System.out.print("Enter a password: ");
        String password = CNUA.nextLine(); // Assign input value to 'password'

        if (writeToFile(username, password)) {
            System.out.println();
            System.out.println("Username and password saved successfully.....");
            System.out.println();
        }

        else {
            System.out.println("An error occurred while saving username and password.....");
        }

        CNUA.close();
    }

    private static boolean writeToFile(String username, String password) {
        try (FileWriter ADDPS = new FileWriter(UserAccount, true)) { // 'true' enables append mode
            ADDPS.write(username + " " + password + "\n");
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.....");
            e.printStackTrace();
            return false;
        }
    }

}
