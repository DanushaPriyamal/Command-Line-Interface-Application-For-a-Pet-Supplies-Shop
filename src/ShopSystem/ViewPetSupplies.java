package ShopSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ViewPetSupplies extends CashierTask {
    // Text file for pet supplies details
    private static final String APSR = "AddPetSuppliesdetails.txt";

    public void ViewSupplies() {

        try (BufferedReader View_PS = new BufferedReader(new FileReader(APSR))) {
            String APS_Line;

            Scanner VPS = new Scanner(APSR);

            while (VPS.hasNextLine()) {

                while ((APS_Line = View_PS.readLine()) != null) {
                    String[] APS_Credentials = APS_Line.split(" "); // Split line by space

                    if (APS_Credentials.length == 3) {
                        String category = APS_Credentials[0];
                        String supply = APS_Credentials[1];
                        String price = APS_Credentials[2];

                        System.out.println("Pet supply category: " + category);
                        System.out.println("Pet supply name: " + supply);
                        System.out.println("Pet supply price: " + price);
                        System.out.println();
                    }
                }
            }

            VPS.close();

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.....");
            e.printStackTrace();
        }
    }

}
