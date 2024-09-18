package com.fit.entity;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
	private static final List<Product> ds = new ArrayList<Product>();
	static{
		initData();
	}

	public static List<Product> queryProduct() {
		return ds;
	}
	
	private static void initData() {
		// TODO Auto-generated method stub
		Product sp = new Product();
		sp.setId("PRO01");
		sp.setDescription("");
		sp.setPrice(99000);
		sp.setModel("Nokia lumia");
		sp.setQuantity((10));
		sp.setImgURL("/images/dt1.jpg");
		ds.add(sp);
		
		sp = new Product();
		sp.setId("PRO02");
		sp.setDescription("");
		sp.setPrice(48000);
		sp.setModel("BlackBerry Passport");
		sp.setQuantity((10));
		sp.setImgURL("/images/dt2.jpg");
		ds.add(sp);
		
		sp = new Product();
		sp.setId("PRO03");
		sp.setDescription("");
		sp.setPrice(52000);
		sp.setModel("Sony Xperia Z5");
		sp.setQuantity((10));
		sp.setImgURL("/images/dt3.jpg");
		ds.add(sp);
		
		sp = new Product();
		sp.setId("PRO04");
		sp.setDescription("");
		sp.setPrice(83000);
		sp.setModel("HTC One M9");
		sp.setQuantity((10));
		sp.setImgURL("/images/dt4.jpg");
		ds.add(sp);
		
		sp = new Product();
		sp.setId("PRO05");
		sp.setDescription("");
		sp.setPrice(60000);
		sp.setModel("Samsung Galaxy Note 5");
		sp.setQuantity((10));
		sp.setImgURL("/images/dt5.jpg");
		ds.add(sp);
	}
}
