package com.agile.Model;

public class Warehouse {  
private String address;   
public Warehouse() {}  
/*
 * @param address
 */
public Warehouse(String address) {  
    super();  
    this.address = address;   
}   
public String getAddress() {  
    return address;  
}  
public void setAddress(String address) {  
    this.address = address;  
}
@Override
public String toString() {
    return "Warehouse [address=" + address + "]";
}
}