package ShopSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddPetSupplies extends CashierTask {
    private static final String APS = "AddPetSuppliesdetails.txt";

    public void AddSupplies() {
        Scanner AS = new Scanner(System.in);

        System.out.println();

        System.out.print("Enter category name: ");
        String category = AS.nextLine();

        System.out.print("Enter pet supply name: ");
        String supply = AS.nextLine();

        System.out.print("Enter pet supply price(RS): ");
        String price = AS.nextLine();

        if (writeToFile(category, supply, price)) {
            System.out.println();
            System.out.println("Data saved successfully.....");
            System.out.println();
            
            try{
                System.err.print("Enter '1' to add another pet supply(If not, enter any other key): ");
                int anotherSupply=AS.nextInt();
    
                if(anotherSupply==1){
                    AddSupplies();
                }
    
                else{
                    System.out.println();
                    System.out.println("Exiting from the system.....");
                    System.out.println();
                }
            }catch(Exception e){
                System.out.println();
                System.out.println("Exiting from the system.....");
                System.out.println();
            }
            
        }

        else {
            System.out.println("An error occurred while saving the data.....");
        }

        AS.close();

    }

    private static boolean writeToFile(String category, String supply, String price) {
        try (FileWriter ADDPS = new FileWriter(APS, true)) { // 'true' enables append mode
            ADDPS.write(category + " " + supply + " " + price + "\n");
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.....");
            e.printStackTrace();
            return false;
        }
    }
}
