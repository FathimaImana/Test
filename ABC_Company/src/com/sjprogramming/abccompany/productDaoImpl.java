package com.sjprogramming.abccompany;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.sjprogramming.abccompany.DBConnection.con;

public class productDaoImpl implements productDaoInterface {

    @Override
    public void createProduct(product pro) {
        con = DBConnection.createDBConnection();
        String query= "insert into product values(?,?,?,?,?,?)";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,pro.getProductId());
            pstm.setString(2,pro.getProductName());
            pstm.setString(3,pro.getDescription());
            pstm.setDouble(4,pro.getPurchasePrice());
            pstm.setDouble(5,pro.getSellingPrice());
            pstm.setInt(6,pro.getQuantity());

            int cnt = pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Product inserted successfully!");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showProductDetails() {
        con= DBConnection.createDBConnection();
        String query="select * from product";
        System.out.println("Product details as follows");
        System.out.println("---------------------------------------------");
        System.out.format("%s\t%s\t%s\t%s\t%s\t%s\n", "ID","  Name","Description", "Purchase price", "Selling Price", "Quantity");
        System.out.println("---------------------------------------------");


        try{
            Statement stmt = con.createStatement();
            ResultSet result= stmt.executeQuery(query);

            while(result.next()){
                System.out.format("%d\t%s\t%s\t%f\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2 ),
                        result.getString(3 ),
                        result.getDouble(4 ),
                        result.getDouble(5 ),
                        result.getInt(6));
                System.out.println("---------------------------------------------");


            }


        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showProductBasedOnID(int productId) {
        con = DBConnection.createDBConnection();
        String query = "select * from product where Product_id =" + productId;
        try{
            Statement stmt = con.createStatement();
            ResultSet result= stmt.executeQuery(query);

            while(result.next()){
                System.out.format("%d\t%s\t%s\t%f\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2 ),
                        result.getString(3 ),
                        result.getDouble(4 ),
                        result.getDouble(5 ),
                        result.getInt(6));
                System.out.println("---------------------------------------------");
            }


        }
        catch(Exception ex){
            ex.printStackTrace();
        }


    }

    @Override
    public void updateProduct(int productId, String productName) {
        con=DBConnection.createDBConnection();
        String query = "update product set Product_name =? where Product_id=?";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,productName);
            pstm.setInt(2,productId);

            int cnt = pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Product details updated successfully!");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }



    }

    @Override
    public void deleteProduct(int productId) {
        con=DBConnection.createDBConnection();
        String query = "delete from product where product_id=?";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,productId);

            int cnt = pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Product details deleted successfully!. Product ID-" +productId);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
