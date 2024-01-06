package com.sjprogramming.abccompany;

public class product {
    private static int productId;
    private String productName;
    private String description;
    private double purchasePrice;
    private double sellingPrice;
    private int quantity;

    public static int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public product() {
    }


    public product(String productName, double sellingPrice) {
        this.productName = productName;
        this.sellingPrice = sellingPrice;
    }

    public product(int productId, String productName, String description, double purchasePrice, double sellingPrice, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", sellingPrice=" + sellingPrice +
                ", quantity=" + quantity +
                '}';
    }
}
