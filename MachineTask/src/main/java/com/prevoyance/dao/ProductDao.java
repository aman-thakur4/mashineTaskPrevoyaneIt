package com.prevoyance.dao;

import java.util.List;

import com.prevoyance.entity.ProductEntity;

public interface ProductDao {
	
	public int addProduct(ProductEntity product);
	public ProductEntity getProductById(long productId);
	public List<ProductEntity> getAllProducts();
	public int deleteProduct(long productId);
	public int updateProduct(ProductEntity product);
}
