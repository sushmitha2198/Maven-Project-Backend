package com.ecomm.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Supplier {
 @Id
 @GeneratedValue
 int SupplierId;
 String SupplierName;
 String SupplierAddress;

 public int getSupplierId() {
	return SupplierId;
}
public void setSupplierId(int supplierId) {
	SupplierId = supplierId;
}
public String getSupplierName() {
	return SupplierName;
}
public void setSupplierName(String supplierName) {
	SupplierName = supplierName;
}
public String getSupplierAddress() {
	return SupplierAddress;
}
public void setSupplierAddress(String supplierAddress) {
	SupplierAddress = supplierAddress;
}
 
}
