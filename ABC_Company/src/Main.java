import com.sjprogramming.abccompany.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create a Scanner object to get input from the user
        Scanner scanner = new Scanner(System.in);

        // Display choices to the user
        System.out.println("--------------------------------------");
        System.out.println("What type of  service you are looking for Choose an option:");
        System.out.println("1. Customer Management\n"+
                           "2. Product Management\n"+
                           "3. Generate Invoice \n");


        // Get user input
        int userInput = scanner.nextInt();

        // Check user input with if conditions
        if (userInput == 1) {
            System.out.println("Customer Management Services");
            System.out.println("--------------------------------");
            CustomerManagement customer1 = new CustomerManagement();
            customer1.manageCustomer();
        } else if (userInput == 2) {
            System.out.println("Product Management Services");
            System.out.println("--------------------------------");
            ProductManagement product1 = new ProductManagement();
            product1.manageProduct();

        } else if (userInput == 3) {
            System.out.println("Invoice Generation Services");
            System.out.println("--------------------------------");
            InvoiceGenerator invoice= new InvoiceGenerator();
            InvoiceGenerator.generateInvoice();
        } else {
            System.out.println("Invalid choice");
        }


        scanner.close();

    }


}
