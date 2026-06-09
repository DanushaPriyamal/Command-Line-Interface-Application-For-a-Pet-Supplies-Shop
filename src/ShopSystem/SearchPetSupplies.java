package ShopSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchPetSupplies extends CashierTask {
    private static final String APSS = "AddPetSuppliesdetails.txt";

    public void SearchSupplies() {
        Scanner SPS = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter category name to search: ");
        String categoryName = SPS.nextLine();

        System.out.println();

        ViewPetSuppliesByCategory(categoryName);

        SPS.close();
    }

    private void ViewPetSuppliesByCategory(String categoryName) {
        BufferedReader Search_PS;
        try {
            Search_PS = new BufferedReader(new FileReader(APSS));

            String APSS_Line;

            while ((APSS_Line = Search_PS.readLine()) != null) {
                String[] APSS_Credentials = APSS_Line.split(" "); // Split line by space

                if (APSS_Credentials.length == 3) {
                    String S_Category = APSS_Credentials[0];
                    String S_Supply = APSS_Credentials[1];
                    String S_Price = APSS_Credentials[2];

                    if (S_Category.equals(categoryName)) {
                        System.out.println("Pet supply category: " + S_Category);
                        System.out.println("Pet supply name: " + S_Supply);
                        System.out.println("Pet supply price: " + S_Price);
                        System.out.println();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file for searching..... ");
            e.printStackTrace();
        }
    }
}
