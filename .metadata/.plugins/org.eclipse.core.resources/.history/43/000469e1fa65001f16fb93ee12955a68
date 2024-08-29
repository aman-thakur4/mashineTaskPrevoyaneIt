package com.prevoyance.dao.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.prevoyance.dao.ProductDao;
import com.prevoyance.entity.ProductEntity;
import com.prevoyance.exception.ResourceNotExistsException;
import com.prevoyance.exception.SomethingWentWrongException;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SessionFactory sf;

	private String ExceptionError = "Something Went Wrong During operation";

	public ProductDaoImpl() {

	}

	@Override
	public int addProduct(ProductEntity product) {
		Session session = sf.openSession();
		try {
			session.save(product); //
			session.beginTransaction().commit();

			return 1;

		} catch (Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrongException(ExceptionError);
		}

	}

	@Override
	public ProductEntity getProductById(long productId) {
		Session session = sf.openSession();
		ProductEntity productEntity = null;
		try {
			productEntity = session.get(ProductEntity.class, productId);

		} catch (Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrongException(ExceptionError);
		}
		return productEntity;

	}

	@Override
	public List<ProductEntity> getAllProducts() {
		Session session = sf.openSession();
		List<ProductEntity> list = null;
		try {

			LocalDate currentDate = LocalDate.now();

			// Define the date format
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			// Format the current date
			String formattedDate = currentDate.format(formatter);
			Criteria criteria = session.createCriteria(ProductEntity.class);

			Criteria criteria2 = session.createCriteria(ProductEntity.class);
			criteria2.setProjection(Projections.min("expDate"));
			criteria2.add(Restrictions.gt("expDate", formattedDate));

			List<String> list2 = criteria2.list();

			if (!list2.isEmpty()) {
				String date = list2.get(0);
				criteria.add(Restrictions.eq("expDate", date));
				list = criteria.list();

			}

			// criteria.add(Restrictions.gt("productId", 3l));

			// list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrongException(ExceptionError);
		}
		return list;
	}

	@Override
	public int deleteProduct(long productId) {
		Session session = sf.openSession();
		try {
			ProductEntity dbProduct = session.get(ProductEntity.class, productId);
			if (dbProduct != null) {
				session.delete(dbProduct);
				return 1;
			} else {
				throw new ResourceNotExistsException("Product not exists with id = " + productId);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrongException(ExceptionError);
		}

	}

	@Override
	public int updateProduct(ProductEntity product) {
		Session session = sf.openSession();
		try {
			ProductEntity dbSuppplier = getProductById(product.getProductId());
			if (dbSuppplier != null) {
				session.update(product);
				session.beginTransaction().commit();
				return 1;
			} else {
				throw new ResourceNotExistsException("Product not exists with id = " + product.getProductId());
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrongException(ExceptionError);
		}

	}	
}
