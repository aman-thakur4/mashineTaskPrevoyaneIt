package com.prevoyance.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class CartEntity {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long cartId;

	    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<CartItemEntity> cartItems = new HashSet();

	    @Column(nullable = false)
	    private double totalAmount;

	    @Column(nullable = false)
	    private double discount;

	    @Column(nullable = false)
	    private double netAmount;

		public CartEntity(long cartId, Set<CartItemEntity> cartItems, double totalAmount, double discount,
				double netAmount) {
			super();
			this.cartId = cartId;
			this.cartItems = cartItems;
			this.totalAmount = totalAmount;
			this.discount = discount;
			this.netAmount = netAmount;
		}

		public CartEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

		public long getCartId() {
			return cartId;
		}

		public void setCartId(long cartId) {
			this.cartId = cartId;
		}

		public Set<CartItemEntity> getCartItems() {
			return cartItems;
		}

		public void setCartItems(Set<CartItemEntity> cartItems) {
			this.cartItems = cartItems;
		}

		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}

		public double getDiscount() {
			return discount;
		}

		public void setDiscount(double discount) {
			this.discount = discount;
		}

		public double getNetAmount() {
			return netAmount;
		}

		public void setNetAmount(double netAmount) {
			this.netAmount = netAmount;
		}

		@Override
		public String toString() {
			return "CartEntity [cartId=" + cartId + ", cartItems=" + cartItems + ", totalAmount=" + totalAmount
					+ ", discount=" + discount + ", netAmount=" + netAmount + "]";
		}

	  
}
