package org.example.models.generic;

public class Customer extends BusinessObject
{
    private String address;
    private String email;

    public Customer()
    {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
