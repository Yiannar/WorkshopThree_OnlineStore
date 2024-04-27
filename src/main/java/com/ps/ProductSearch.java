package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductSearch {

    public static void searchRange(ArrayList<Product> storeInventory) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select your budget range: ");
        System.out.println("\t1) Less than $20");
        System.out.println("\t2) Between $20 and $50");
        System.out.println("\t3) Greater than $50");

        int userPrice = scanner.nextInt();

        for (Product product : storeInventory) {
            if (product.getPrice() <= userPrice) {
                System.out.println(product);
            }
        }
    }
}