package com.prevoyance.model;

public class ProductModel {
 
	private long productId;
	
	private String productCode;
	
	private String productName;
	
	private String imageUrl; 
	
	public ProductModel(long productId, String productCode, String productName, String imageUrl, double productPrice) {
		super();
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
		this.imageUrl = imageUrl;
		this.productPrice = productPrice;
	}

	private double productPrice;

	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "ProductModel [productId=" + productId + ", productCode=" + productCode + ", productName=" + productName
				+ ", imageUrl=" + imageUrl + ", productPrice=" + productPrice + "]";
	}

}
