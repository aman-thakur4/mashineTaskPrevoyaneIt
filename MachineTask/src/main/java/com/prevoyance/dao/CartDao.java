package com.prevoyance.dao;

import com.prevoyance.entity.CartEntity;

public interface CartDao {

	    public CartEntity getCartById(long cartId);

	    public void saveCart(CartEntity cart) ;
}
