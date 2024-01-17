package com.SoftUniExam.BonAppetit.Model.Service;

import com.SoftUniExam.BonAppetit.Model.Entity.CategoryNameEnum;
import com.SoftUniExam.BonAppetit.Model.Entity.User;

public class RecipeServiceModel {

    private Long id;

    private String name;
    private String ingredients;


    private CategoryNameEnum category;
    private User addedBy;

    public RecipeServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryNameEnum category) {
        this.category = category;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }
}



