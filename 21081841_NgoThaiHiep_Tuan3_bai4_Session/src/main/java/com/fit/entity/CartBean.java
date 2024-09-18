package com.fit.entity;

import java.util.ArrayList;

public class CartBean {
	private ArrayList<CartItemBean> alCartItems = new ArrayList<CartItemBean>();
	private double dblOrderTotal;
	
	public int getLineItemCount() {
		return alCartItems.size();
	}

	public void deleteCartItem(String strItemIndex) {
		int iItemIndex = 0;
		try {
			iItemIndex = Integer.parseInt(strItemIndex);
			alCartItems.remove(iItemIndex - 1);
			calculateOrderTotal();
		} catch (NumberFormatException nfe) {
			System.out.println("Error while deleting cart item: " + nfe.getMessage());
			nfe.printStackTrace();
		}
	}
	
	public void updateCartItem(String strItemIdex, String strQuantity) {
		int iItemIndex = 0;
		double dblTotalCost = 0;
		double dblUnitCost = 0;
		int iQuantity = 0;
		CartItemBean cartItem = null;
		try {
			iItemIndex = Integer.parseInt(strItemIdex);
			iQuantity = Integer.parseInt(strQuantity);
			if (iQuantity > 0) {
				cartItem = alCartItems.get(iItemIndex - 1);
				dblUnitCost = cartItem.getDblUnnitCost();
				dblTotalCost = dblUnitCost * iQuantity;
				cartItem.setIntQuantity(iQuantity);
				cartItem.setDblTotalCost(dblTotalCost);
				calculateOrderTotal();
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Error while updating cart: " + nfe.getMessage());
			nfe.printStackTrace();
		}
	}
	
	public void addCartItem(String strPartNumber, String strModelDescription, String strUnitCost, String strQuantity) {
		double dblTotalCost = 0;
		double dblUnitCost = 0;
		int iQuantity = 0;
		CartItemBean cartItem = new CartItemBean();
		try {
			dblUnitCost = Double.parseDouble(strUnitCost);
            iQuantity = Integer.parseInt(strQuantity);
            if (iQuantity > 0) {
                dblTotalCost = dblUnitCost * iQuantity;
                cartItem.setStrPartnumber(strPartNumber);
               cartItem.setstrModelDescription(strModelDescription);
                cartItem.setDblUnnitCost(dblUnitCost);
                cartItem.setIntQuantity(iQuantity);
                cartItem.setDblTotalCost(dblTotalCost);
                alCartItems.add(cartItem);
                calculateOrderTotal();
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Error while parsing from String to primitive types: " + nfe.getMessage());
            nfe.printStackTrace();
        }
           
		
    }
	
	public void addCartItem(CartItemBean cartItem) {
		alCartItems.add(cartItem);
	}
	
	
	public CartItemBean getCartItem(int iItemIndex) {
		CartItemBean cartItem = null;
		if (alCartItems.size() > iItemIndex) {
			cartItem =(CartItemBean) alCartItems.get(iItemIndex);
		}
		return cartItem;
	}

	
	public ArrayList<CartItemBean> getAlCartItems() {
		return alCartItems;
	}

	public void setAlCartItems(ArrayList<CartItemBean> alCartItems) {
		this.alCartItems = alCartItems;
	}

	public double getDblOrderTotal() {
		return dblOrderTotal;
	}

	public void setDblOrderTotal(double dblOrderTotal) {
		this.dblOrderTotal = dblOrderTotal;
	}
	
	public void calculateOrderTotal() {
		double dblTotal = 0;
		for (int counter = 0; counter < alCartItems.size(); counter++) {
			CartItemBean cartItem = alCartItems.get(counter);
			dblTotal += cartItem.getDblTotalCost();
		}
		setDblOrderTotal(dblTotal);
	}
	

}
