package com.sjprogramming.abccompany;

public interface customerDaoInterface {
    //Create Customer
    public void createCustomer(customer cus);

    //Show All customer
    public void showCustomerDetails();

    //Search Customer based on ID
    public void showCustomerBasedOnID(int id);

    //Update customer
    public void updateCustomer(int id, String name);

    //Delete Customer
    public void deleteCustomer(int id);


}
