package com.prevoyance.service.impl;
import org.springframework.beans.factory.annotation.Autowired;

import com.prevoyance.dao.CartDao;
import com.prevoyance.entity.CartEntity;
import com.prevoyance.entity.CartItemEntity;
import com.prevoyance.entity.ProductEntity;
import com.prevoyance.service.CartService;


public class CartServiceImpl implements CartService{
	 @Autowired
	    private CartDao cartDao;

	 @Override
	    public CartEntity getCartById(long cartId) {
	        return cartDao.getCartById(cartId);
	    }

	 @Override
	    public void saveCart(CartEntity cart) {
	        cartDao.saveCart(cart);
	    }

	 @Override
	    public void addProductToCart(CartEntity cart, ProductEntity product, int quantity) {
	        CartItemEntity cartItem = new CartItemEntity();
	        cart.getCartItems().add(cartItem);
	        saveCart(cart);
	    }

	 @Override
	    public void recalculateCartTotals(CartEntity cart) {
	        double totalAmount = cart.getCartItems().stream().mapToDouble(CartItemEntity::getTotalPrice).sum();
	        double discount = calculateDiscount(totalAmount);
	        double netAmount = totalAmount - discount;

	        cart.setTotalAmount(totalAmount);
	        cart.setDiscount(discount);
	        cart.setNetAmount(netAmount);

	        saveCart(cart);  // Update the cart with the new totals
	    }

	 @Override
	public double calculateDiscount(double totalAmount) {
	        return 0;  // Implement your discount logic if necessary
	    }
}
