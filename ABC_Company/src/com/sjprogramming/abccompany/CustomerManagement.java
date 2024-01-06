package com.sjprogramming.abccompany;
import java.util.Scanner;
public class CustomerManagement {
    public void manageCustomer() {
        String customerName;
        int  customerId;
        int contactNum;
        //create object of Customer

        customerDaoInterface dao=new customerDaoImpl(); //Using this object we can access all CRUD methods
        System.out.println("Welcome to Customer Management Application");

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("""
                    1.Add customer
                    2.Show All customer Details
                    3.Show customer Based on ID
                    4.Update customer Name
                    5.Delete customer
                    """);
            System.out.println("Enter choice : ");
            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    //get all details of customer
                    customer cus = new customer();
                    System.out.println("Enter ID : ");
                    customerId = sc.nextInt();
                    System.out.println("Enter name : ");
                    customerName = sc.next();
                    System.out.println("Enter Email : ");
                    String email = sc.next();
                    System.out.println("Enter Address : ");
                    String address = sc.next();
                    System.out.println("Enter Contact Number : ");
                    contactNum = sc.nextInt();
                    System.out.println("Enter Date Of Birth(YY-MM-DD) : ");
                    String dateOfBirth = sc.next();
                    System.out.println("Enter gender(Male/Female) : ");
                    String gender = sc.next();


                    //set all details to the customer
                    cus.setCustomerId(customerId);
                    cus.setCustomerName(customerName);
                    cus.setEmail(email);
                    cus.setAddress(address);
                    cus.setContactNum(contactNum);
                    cus.setDateOfBirth(String.valueOf(dateOfBirth));
                    cus.setGender(gender);

                    dao.createCustomer(cus);
                    break;
                case 2 :
                    //Show all details of the customer
                    dao.showCustomerDetails();
                    break;
                case 3 :
                    //Show customer details based on ID
                    System.out.println("Enter ID to show details");
                    customerId = sc.nextInt();
                    dao.showCustomerBasedOnID(customerId);
                    break;
                case 4 :
                    //Update customer name based on ID
                    System.out.println("Enter ID to Update the details");
                    int customerId1 = sc.nextInt();
                    System.out.println("Enter the New name");
                    customerName= sc.next();
                    dao.updateCustomer(customerId1,customerName);
                    break;
                case 5 :
                    //Delete customer based on ID
                    System.out.println("Enter Customer ID to Delete the details");
                    customerId = sc.nextInt();
                    dao.deleteCustomer(customerId);
                    break;
                default:
                    System.out.println("Enter Valid Choice");
                    break;
            }
            System.out.println("Thank you for using our services");
            System.exit(0);
        }while(true);
    }
}
