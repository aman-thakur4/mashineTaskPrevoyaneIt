package com.prevoyance.service;

import java.util.List;
import com.prevoyance.entity.ProductEntity;

public interface ProductService {

	public int addProduct(ProductEntity product);
	public ProductEntity getProductById(long productId);

	public List<ProductEntity> getAllProducts();
	
	public int deleteProduct(long productId);
	
	public int updateProduct(ProductEntity product);
	
	
}
