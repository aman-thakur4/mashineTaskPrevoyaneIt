package com.prevoyance.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.prevoyance.dao.CartDao;
import com.prevoyance.entity.CartEntity;

public class CartDaoImpl implements CartDao {
	
	 @Autowired
	    private SessionFactory sessionFactory;

	 @Override
	    public CartEntity getCartById(long cartId) {
	        Session session = sessionFactory.getCurrentSession();
	        return session.get(CartEntity.class, cartId);
	    }

	 @Override
	    public void saveCart(CartEntity cart) {
	        Session session = sessionFactory.getCurrentSession();
	        session.saveOrUpdate(cart);
	    }

}
