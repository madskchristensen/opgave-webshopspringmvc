package com.madskchristensen.webshopspringmvc.models;

public class CategoryProduct {
    private Long categoryId;
    private Long productId;

    public CategoryProduct() {
    }

    public CategoryProduct(Long categoryId, Long productId) {
        this.categoryId = categoryId;
        this.productId = productId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
