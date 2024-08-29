package com.prevoyance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.prevoyance.entity.ProductEntity;
import com.prevoyance.exception.ResourceNotExistsException;
import com.prevoyance.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService service;

	@PostMapping("/add-product")
	public String addProduct(@RequestBody ProductEntity product) {

		service.addProduct(product);

		return "Added Successfully";

	}

	@GetMapping("/get-product-by-id/{id}") // {_} placeholder
	public ResponseEntity<ProductEntity> getProductById(@PathVariable("id") long productId) {

		ProductEntity product = service.getProductById(productId);
		return new ResponseEntity<ProductEntity>(product, HttpStatus.OK);
	}

	@GetMapping("/get-all-products")
	public ResponseEntity<List<ProductEntity>> getAllProducts() {

		List<ProductEntity> productList = service.getAllProducts();
		if (!productList.isEmpty()) {
			return new ResponseEntity<List<ProductEntity>>(productList, HttpStatus.OK);
		} else {
			throw new ResourceNotExistsException("Product Not Exists, List Is Empty");
		}

	}

	@DeleteMapping("/delete-product-by-id")
	public ResponseEntity<String> deleteProduct(@RequestParam long productId) {

		service.deleteProduct(productId);
		// return ResponseEntity.ok("Deleted");
		return new ResponseEntity<String>("Deleted", HttpStatus.MOVED_PERMANENTLY);

	}

	@PutMapping("/update-product")
	public ResponseEntity<String> updateUpdateProduct(@RequestBody ProductEntity product) {

		int status = service.updateProduct(product);
		if (status == 1) {
			return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("Not Found", HttpStatus.OK);

		}

	}
}
