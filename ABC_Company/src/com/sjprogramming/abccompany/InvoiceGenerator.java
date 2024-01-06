package com.sjprogramming.abccompany;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InvoiceGenerator {
    static Connection con;
    // Create a loop to allow generating multiple invoices
    public static void iterateInvoiceGeneration() {
        try {
            Scanner scanner = new Scanner(System.in);


            // Ask the user if they want to generate another invoice
            System.out.print("Do you want to generate another invoice? (yes/no): ");
            String response = scanner.next().toLowerCase();

            while (true) {

                if (response.equals("yes")) {
                    generateInvoice();
                }
                else {
                    break;
                }
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void generateInvoice() {
        con = DBConnection.createDBConnection();
        try {
            Scanner scanner = new Scanner(System.in);

            // Get customer ID from user input
            System.out.print("Enter Customer ID: ");
            int customerId = scanner.nextInt();

            // Get the last generated invoice number from the database
            int lastGeneratedInvoiceNumber = getLastGeneratedInvoiceNumber(con);

            // Increment the last generated invoice number for the next invoice
            int nextInvoiceNumber = lastGeneratedInvoiceNumber + 1;

            // Database connection
            try {
                // Map to store product IDs and quantities
                Map<Integer, Integer> productQuantityMap = new HashMap<>();

                // Create a while loop to allow the customer to add products
                while (true) {
                    // Get product ID from user input
                    System.out.print("Enter Product ID (type '0' to finish): ");
                    int productId = scanner.nextInt();

                    if (productId == 0) {
                        break; // Exit the loop if the user enters '0'
                    }

                    // Get quantity from user input
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();

                    // Store product ID and quantity in the map
                    productQuantityMap.put(productId, quantity);
                }

                // Display the invoice  with date and invoice number
                Date currentDate = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println("Invoice Date: " + dateFormat.format(currentDate));
                System.out.println("Invoice Number: " + nextInvoiceNumber);
                System.out.printf("%-30s%-20s%-20s%-20s\n", "PRODUCT", "QUANTITY", "PRICE", "SUBTOTAL");

                double totalPrice = 0;

                // Iterate through the map to display product details, calculate total price, and update the database
                for (Map.Entry<Integer, Integer> entry : productQuantityMap.entrySet()) {
                    int productId = entry.getKey();
                    int quantity = entry.getValue();

                    // Query the database to get the details of the product
                    product product = getProductDetails(con, productId);

                    if (product != null) {
                        // Calculate and display the subtotal for the current product
                        double subtotal = quantity * product.getSellingPrice();
                        System.out.printf("%-30s%-20s%-20s%-20s\n", product.getProductName(), quantity, product.getSellingPrice(), subtotal);

                        // Update the database: reduce product quantity
                        updateProductQuantity(con, productId, quantity);

                        // Update the total price
                        totalPrice += subtotal;
                    } else {
                        System.out.println("Product not found in the database.");
                    }
                }

                // Display the total price
                System.out.printf("%-70s%-20s\n", "Total", totalPrice);

                // Insert the invoice data into the database
                insertInvoiceData(con, nextInvoiceNumber, currentDate, customerId, totalPrice);
                iterateInvoiceGeneration();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static int getLastGeneratedInvoiceNumber(Connection connection) {
        try {
            String query = "SELECT MAX(invoice_number) AS last_generated_invoice_number FROM invoice";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                if (resultSet.next()) {
                    return resultSet.getInt("last_generated_invoice_number");
                } else {
                    return 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static void insertInvoiceData(Connection connection, int invoiceNumber, Date date, int customerId, double totalPrice) {
        try {
            String insertQuery = "INSERT INTO invoice (invoice_number, invoice_date, customer_id, total_price) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, invoiceNumber);
                preparedStatement.setTimestamp(2, new Timestamp(date.getTime()));
                preparedStatement.setInt(3, customerId);
                preparedStatement.setDouble(4, totalPrice);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static product getProductDetails(Connection connection, int productId) throws SQLException {
        String query = "SELECT Product_name, Selling_price FROM product WHERE Product_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String productName = resultSet.getString("Product_name");
                double sellingPrice = resultSet.getDouble("Selling_price");
                return new product(productName, sellingPrice);
            } else {
                return null;
            }
        }
    }

    private static void updateProductQuantity(Connection connection, int productId, int quantity) {
        try {
            String updateQuery = "UPDATE product SET Quantity = Quantity - ? WHERE Product_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setInt(1, quantity);
                preparedStatement.setInt(2, productId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
