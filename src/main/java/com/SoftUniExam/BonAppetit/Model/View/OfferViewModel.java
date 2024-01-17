package com.SoftUniExam.BonAppetit.Model.View;

import com.SoftUniExam.BonAppetit.Model.Entity.Category;
import com.SoftUniExam.BonAppetit.Model.Entity.User;

public class OfferViewModel {

    private Long id;

    private String description;

    private Float price ;

    private Category category;

    private User seller;

    public OfferViewModel() {
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Category getCondition() {
        return category;
    }

    public void setCondition(Category category) {
        this.category = category;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
