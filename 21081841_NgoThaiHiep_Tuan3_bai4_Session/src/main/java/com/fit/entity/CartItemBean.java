package com.fit.entity;

public class CartItemBean {
	private String strPartnumber;
	private String strModelDescription;
	private double dblUnnitCost;
	private int intQuantity;
	private double dblTotalCost;
	public String getStrPartnumber() {
		return strPartnumber;
	}
	public void setStrPartnumber(String strPartnumber) {
		this.strPartnumber = strPartnumber;
	}
	public String getstrModelDescription() {
		return strModelDescription;
	}
	public void setstrModelDescription(String strModelDescription) {
		this.strModelDescription = strModelDescription;
	}
	public double getDblUnnitCost() {
		return dblUnnitCost;
	}
	public void setDblUnnitCost(double dblUnnitCost) {
		this.dblUnnitCost = dblUnnitCost;
	}
	public int getIntQuantity() {
		return intQuantity;
	}
	public void setIntQuantity(int intQuantity) {
		this.intQuantity = intQuantity;
	}
	public double getDblTotalCost() {
		return dblTotalCost;
	}
	public void setDblTotalCost(double dblTotalCost) {
		this.dblTotalCost = dblTotalCost;
	}
	public CartItemBean(String strPartnumber, String strModelDescription, double dblUnnitCost, int intQuantity,
			double dblTotalCost) {
		super();
		this.strPartnumber = strPartnumber;
		this.strModelDescription = strModelDescription;
		this.dblUnnitCost = dblUnnitCost;
		this.intQuantity = intQuantity;
		this.dblTotalCost = dblTotalCost;
	}
	public CartItemBean() {
		super();
	}
	
	
}
