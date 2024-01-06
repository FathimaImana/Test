package com.sjprogramming.abccompany;

import java.util.Date;

public class Invoice {
    //invoice variables
    int invoiceNumber;
    Date invoiceDate;
    int UnitsPerProduct;
    Double TotalPricePerProduct;
    Double DiscountPerProduct;
//getters and setters
    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public int getUnitsPerProduct() {
        return UnitsPerProduct;
    }

    public void setUnitsPerProduct(int unitsPerProduct) {
        UnitsPerProduct = unitsPerProduct;
    }

    public Double getTotalPricePerProduct() {
        return TotalPricePerProduct;
    }

    public void setTotalPricePerProduct(Double totalPricePerProduct) {
        TotalPricePerProduct = totalPricePerProduct;
    }

    public Double getDiscountPerProduct() {
        return DiscountPerProduct;
    }

    public void setDiscountPerProduct(Double discountPerProduct) {
        DiscountPerProduct = discountPerProduct;
    }

    //constructor
    public Invoice(int invoiceNumber, Date invoiceDate, int unitsPerProduct, Double totalPricePerProduct, Double discountPerProduct) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        UnitsPerProduct = unitsPerProduct;
        TotalPricePerProduct = totalPricePerProduct;
        DiscountPerProduct = discountPerProduct;
    }


}



