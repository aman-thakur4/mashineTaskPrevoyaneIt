package com.prevoyance.service.impl;

import com.prevoyance.dao.ProductDao;
import com.prevoyance.entity.ProductEntity;
import com.prevoyance.service.ProductService;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao dao;

	

	@Override
	public int addProduct(ProductEntity product) {

		String productId = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		product.setProductId(Long.parseLong(productId));

		return dao.addProduct(product);

	}

	@Override
	public ProductEntity getProductById(long productId) {

		return dao.getProductById(productId);
	}

	@Override
	public List<ProductEntity> getAllProducts() {

		return dao.getAllProducts();
	}

	@Override
	public int deleteProduct(long productId) {

		return dao.deleteProduct(productId);

	}

	@Override
	public int updateProduct(ProductEntity product) {
		return dao.updateProduct(product);

	}

}
