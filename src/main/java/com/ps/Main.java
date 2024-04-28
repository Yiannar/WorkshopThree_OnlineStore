package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.ps.ProductSearch;

public class Main {

    public static void main(String[] args) {

        ArrayList<Product> storeInventory = new ArrayList<>();
        ArrayList<Product> cart = new ArrayList<>();

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

                        while ((input = bufReader.readLine()) != null){
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
                    System.out.println("Please select from one of the following options.");
                    System.out.println("\t1) Search through the list of products");
                    System.out.println("\t2) Add a product to cart");
                    System.out.println("\t3) Return to the HOME menu");

                    int command = scanner.nextInt();

                    switch (command) {
                        case 1:
                            // Search option
                            System.out.println("Please select your budget range: ");
                            System.out.println("\t1) Less than $20");
                            System.out.println("\t2) Between $20 and $50");
                            System.out.println("\t3) Greater than $50");

                            int userPrice = scanner.nextInt();

                            for (Product product : storeInventory) {
                                if (userPrice == 1) {
                                    if(product.getPrice()<=20){
                                        System.out.println(product);
                                    }

                                } else if (userPrice == 2) {
                                    if(product.getPrice()>=20 && product.getPrice()<=50){
                                        System.out.println(product);
                                    }

                                } else if (userPrice == 3) {
                                    if(product.getPrice()>= 50) {
                                        System.out.println(product);
                                    }
                                } else {
                                }
                            }
                            break;
                        case 2:
                            String addItem;
                            // Add a product to cart
                            System.out.println("Enter the SKU number of the product you would like to add to cart");
                            addItem = scanner.next();


                                for(Product product: storeInventory) {
                                    if(addItem.equals(product.getSku())){
                                        cart.add(product);
                                        System.out.println("Item was successfully added to cart!");
                                    }

                                }

                            System.out.println(cart);

                            break;
                        case 3:
                            // Return to home menu
                            System.out.println("Returning back to HOME menu...");
                            break;
                    }

                    break;

                case 2:

                    System.out.println("Items in your cart:" + cart);
                    float cartTotal = 0;
                    for(Product product : cart) {
                        cartTotal += product.getPrice();
                    }
                    System.out.println("Your total cost is:" + "$" + cartTotal);
                    System.out.println("\nWhat would you like to do? ");
                    System.out.println("\t1) Check Out");
                    System.out.println("\t2) Remove a product from cart");
                    System.out.println("\t3) Go to home menu");

                    int checkOutMenu = scanner.nextInt();

                    switch (checkOutMenu){
                        case 1:

                            System.out.println("Are you sure you want to checkout?");

                            String checkout = scanner.next();
                                if(checkout.equalsIgnoreCase("yes")){
                                    System.out.println("You have successfully checked out!");
                                } else {
                                    continue;
                                }

                            break;
                        case 2:
                            String cartItemRemoved;

                            System.out.println("Which item would you like to remove from your cart? Please type Sku number");
                            cartItemRemoved = scanner.next();

                            for(Product product: cart) {
                                if(cartItemRemoved.equals(product.getSku())){
                                    cart.remove(product);
                                    System.out.println("Item was successfully removed to cart!");
                                }

                            }

                            break;
                        case 3:
                        continue;



                    }



                    break;
            }

        } while (option != 3);







    }

}