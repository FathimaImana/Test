package com.sjprogramming.abccompany;

public interface productDaoInterface {

    //Create Product
    public void createProduct(product pro);
    //Show All Product
    public void showProductDetails();
    //Show Product based on ID
    public void showProductBasedOnID(int productId);

    //Update Product Name
    public void updateProduct(int productId, String productName);
    //Delete Product
    public void deleteProduct(int productId);
}
