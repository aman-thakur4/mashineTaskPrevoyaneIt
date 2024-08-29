package com.prevoyance.controller;

import com.prevoyance.entity.CartEntity;
import com.prevoyance.entity.ProductEntity;
import com.prevoyance.service.CartService;
import com.prevoyance.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")

public class CartController {
	
	 @Autowired
	    private CartService cartService;

	    @Autowired
	    private ProductService productService;

	    @PostMapping("/add")
	    public ResponseEntity<CartEntity> addProductToCart(@RequestParam long cartId, @RequestParam long productId, @RequestParam int quantity) {
	        ProductEntity product = productService.getProductById(productId);
	        if (product == null) {
	            return ResponseEntity.badRequest().body(null);
	        }

	        CartEntity cart = cartService.getCartById(cartId);
	        if (cart == null) {
	            cart = new CartEntity();
	            cartService.saveCart(cart);
	        }

	        cartService.addProductToCart(cart, product, quantity);
	        cartService.recalculateCartTotals(cart);

	        return ResponseEntity.ok(cart);
	    }
}
