package com.sjprogramming.abccompany;

import com.sjprogramming.abccompany.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class customerDaoImpl implements customerDaoInterface {

    Connection con;
// Create a Customer row
    @Override
    public void createCustomer(customer cus) {
        con = DBConnection.createDBConnection();
        String query= "insert into customer values(?,?,?,?,?,?,?)";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,cus.getCustomerId());
            pstm.setString(2,cus.getCustomerName());
            pstm.setString(3,cus.getEmail());
            pstm.setString(4,cus.getAddress());
            pstm.setInt(5,cus.getContactNum());
            pstm.setString(6,cus.getDateOfBirth());
            pstm.setString(7,cus.getGender());

            int cnt = pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Customer inserted successfully!");
                System.out.println("--------------------------------");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }


    }


// Generate all customer details
    @Override
    public void showCustomerDetails() {
        con= DBConnection.createDBConnection();
        String query="select * from customer";
        System.out.println("Customer details as follows");
        System.out.println("---------------------------------------------");
        System.out.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\n", "ID","Name","Email", "Address","Contact Number","DOB","Gender");
        System.out.println("---------------------------------------------");


        try{
            Statement stmt = con.createStatement();
            ResultSet result= stmt.executeQuery(query);

            while(result.next()){
                System.out.format("%d\t%s\t%s\t%s\t%d\t%s\t%s\n",
                        result.getInt(1),
                        result.getString(2 ),
                        result.getString(3 ),
                        result.getString(4 ),
                        result.getInt(5 ),
                        result.getString(6 ),
                        result.getString(7 ));


                System.out.println("---------------------------------------------");


            }


        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

    //Show customer based on ID
    @Override
    public void showCustomerBasedOnID(int customerId) {
        con = DBConnection.createDBConnection();
        String query = "select * from customer where Customer_id =" + customerId;
        try{
            Statement stmt = con.createStatement();
            ResultSet result= stmt.executeQuery(query);

            while(result.next()){
                System.out.format("%d\t%s\t%s\t%s\t%d\t%s\t%s\n",
                        result.getInt(1),
                        result.getString(2 ),
                        result.getString(3 ),
                        result.getString(4 ),
                        result.getInt(5 ),
                        result.getString(6 ),
                        result.getString(7 ));
            }


        }
        catch(Exception ex){
            ex.printStackTrace();
        }


    }
// Update Name of the customer based on ID
    @Override
    public void updateCustomer(int customerId, String customerName) {
        con=DBConnection.createDBConnection();
        String query = "update customer set Customer_name =? where Customer_id=?";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,customerName);
            pstm.setInt(2,customerId);

            int cnt = pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Customer details updated successfully!");
                System.out.println("---------------------------------------");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }



    }
// Delete Customer based on ID
    @Override
    public void deleteCustomer(int customerId) {
        con= DBConnection.createDBConnection();
        String query = "delete from customer where Customer_id=?";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,customerId);

            int cnt = pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Customer  details deleted successfully! . Customer ID - " + customerId);
                System.out.println("----------------------------------------------------------------------");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }


    }
}


