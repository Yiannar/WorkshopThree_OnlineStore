package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Product> storeInventory = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Please select from the following options: ");

            System.out.println("\t1) Display Products");
            System.out.println("\t2) Display Cart");
            System.out.println("\t3) Exit ");

             option = scanner.nextInt();


             switch (option){
                 case 1:
                     try {
                         BufferedReader bufReader = new BufferedReader(new FileReader("Products.txt"));
                         String input;

                         while ( (input = bufReader.readLine()) != null){
                             String[] splitInput = input.split("\\|");
                             String sku = splitInput[0];
                             String productName = splitInput[1];
                             float price = Float.parseFloat(splitInput[2]);
                             String department = splitInput[3];

                             Product tempProduct = new Product(sku, productName, price, department);
                             storeInventory.add(tempProduct);


                         }
                         bufReader.close();
                     } catch (IOException e){
                         e.printStackTrace();
                     }

                     for (Product product : storeInventory) {
                         System.out.println(product);
                     }
                     break;

                 case 2:


             }

        } while (option != 3);







    }

}