package com.prevoyance.entity;

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
@Table(name = "product")
public class ProductEntity {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	
	private String productCode;
	
	@Column(nullable = false,unique = true)
	private String productName;
	
	 private String imageUrl; 
	
	@Column(nullable = false,unique = false)
	private double productPrice;
	 @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<CartItemEntity> cartItems;



	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", productCode=" + productCode + ", productName=" + productName
				+ ", imageUrl=" + imageUrl + ", productPrice=" + productPrice + "]";
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public ProductEntity(long productId, String productCode, String productName, String imageUrl, double productPrice) {
		super();
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
		this.imageUrl = imageUrl;
		this.productPrice = productPrice;
	}
	
}
