package com.prevoyance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_item")
public class CartItemEntity {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long cartItemId;

	    @ManyToOne
	    @JoinColumn(name = "cart_id", nullable = false)
	    private CartEntity cart;

	    @ManyToOne
	    @JoinColumn(name = "product_id", nullable = false)
	    private ProductEntity product;

	    @Column(nullable = false)
	    private String productName;

	    @Column(nullable = false)
	    private String productImageUrl;

	    @Column(nullable = false)
	    private double productPrice;

	    @Column(nullable = false)
	    private int quantity;

	    @Column(nullable = false)
	    private double totalPrice;

		public CartItemEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

		public CartItemEntity(long cartItemId, CartEntity cart, ProductEntity product, String productName,
				String productImageUrl, double productPrice, int quantity, double totalPrice) {
			super();
			this.cartItemId = cartItemId;
			this.cart = cart;
			this.product = product;
			this.productName = productName;
			this.productImageUrl = productImageUrl;
			this.productPrice = productPrice;
			this.quantity = quantity;
			this.totalPrice = totalPrice;
		}

		public long getCartItemId() {
			return cartItemId;
		}

		public void setCartItemId(long cartItemId) {
			this.cartItemId = cartItemId;
		}

		public CartEntity getCart() {
			return cart;
		}

		public void setCart(CartEntity cart) {
			this.cart = cart;
		}

		public ProductEntity getProduct() {
			return product;
		}

		public void setProduct(ProductEntity product) {
			this.product = product;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getProductImageUrl() {
			return productImageUrl;
		}

		public void setProductImageUrl(String productImageUrl) {
			this.productImageUrl = productImageUrl;
		}

		public double getProductPrice() {
			return productPrice;
		}

		public void setProductPrice(double productPrice) {
			this.productPrice = productPrice;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public double getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}

		@Override
		public String toString() {
			return "CartItemEntity [cartItemId=" + cartItemId + ", cart=" + cart + ", product=" + product
					+ ", productName=" + productName + ", productImageUrl=" + productImageUrl + ", productPrice="
					+ productPrice + ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
		}

	   
}
