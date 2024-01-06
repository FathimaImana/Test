package com.sjprogramming.abccompany;

import java.util.Scanner;

public class ProductManagement {
    public void manageProduct(){
        String productName;
        int  productId;

        //create object of product

        productDaoInterface dao=new productDaoImpl(); //Using this object we can access all CRUD methods
        System.out.println("Welcome to Product Management Application");

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("""
                    1.Add product
                    2.Show All products
                    3.Show product Based on ID
                    4.Update product
                    5.Delete product
                    """);
            System.out.println("Enter choice : ");
            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    var pro = new product();
                    System.out.println("Enter ID : ");
                    productId = sc.nextInt();
                    System.out.println("Enter name : ");
                    productName = sc.next();
                    System.out.println("Enter Description : ");
                    String description = sc.next();
                    System.out.println("Enter purchase Price : ");
                    double purchasePrice = sc.nextDouble();
                    System.out.println("Enter selling Price : ");
                    double sellingPrice = sc.nextDouble();
                    System.out.println("Enter Quantity : ");
                    int quantity = sc.nextInt();


                    //set all details to the Product
                    pro.setProductId(productId);
                    pro.setProductName(productName);
                    pro.setDescription(description);
                    pro.setPurchasePrice(purchasePrice);
                    pro.setSellingPrice(sellingPrice);
                    pro.setQuantity(quantity);


                    dao.createProduct(pro);
                    break;
                case 2 :
                    dao.showProductDetails();
                    break;
                case 3 :
                    System.out.println("Enter ID to show details");
                    productId = sc.nextInt();
                    dao.showProductBasedOnID(productId);
                    break;
                case 4 :
                    System.out.println("Enter Product ID to Update the details");
                    int productId1 = sc.nextInt();
                    System.out.println("Enter the new product name");
                    productName= sc.next();
                    dao.updateProduct(productId1,productName);
                    break;
                case 5 :
                    System.out.println("Enter Product ID to Delete the details");
                    productId = sc.nextInt();
                    dao.deleteProduct(productId);
                    break;
                default:
                    System.out.println("Enter Valid Choice");
                    break;
            }
            System.out.println("Thank you for using our application");
            System.exit(0);
        }while(true);
    }
}
