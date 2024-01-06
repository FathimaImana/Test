package com.sjprogramming.abccompany;

public class customer {
    private int customerId;
    private String customerName;
    private String email;
    private String address;
    private int contactNum;
    private String dateOfBirth;
    private String gender;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContactNum() {
        return contactNum;
    }

    public void setContactNum(int contactNum) {
        this.contactNum = contactNum;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
public customer(){

}
    public customer(int customerId, String customerName, String email, String address, int contactNum, String dateOfBirth, String gender) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.address = address;
        this.contactNum = contactNum;
        this.dateOfBirth = String.valueOf(dateOfBirth);
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", contactNum=" + contactNum +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                '}';
    }
}
