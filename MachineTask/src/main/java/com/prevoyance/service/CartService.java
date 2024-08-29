package com.prevoyance.service;

import com.prevoyance.entity.CartEntity;
import com.prevoyance.entity.ProductEntity;

public interface CartService {
	 
	    public CartEntity getCartById(long cartId); 

	    public void saveCart(CartEntity cart); 

	    public void addProductToCart(CartEntity cart, ProductEntity product, int quantity) ;

	    public void recalculateCartTotals(CartEntity cart) ;

	    double calculateDiscount(double totalAmount) ;
}
