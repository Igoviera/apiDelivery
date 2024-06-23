package com.igo.apiDelivery.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)

    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    private String imgURL;
    private boolean avaliable = true;

    public Product() {
    }

    public Product(Long id, String description, BigDecimal price, String imgURL, Boolean avaliable) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.imgURL = imgURL;
        this.avaliable = avaliable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Boolean getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(Boolean avaliable) {
        this.avaliable = avaliable;
    }
}
