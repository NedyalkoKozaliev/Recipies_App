package com.SoftUniExam.BonAppetit.Model.Binding;

import com.SoftUniExam.BonAppetit.Model.Entity.CategoryNameEnum;
import jakarta.validation.constraints.*;

public class RecipeAddBindingModel {
    @Size(min=2,max=40, message = "Name length must be between 2 and 40 characters.")
    @NotEmpty(message = "Name could not be empty.")
    private String name;

    @Size(min=2,max=150, message = "Ingredients length must be between 2 and 150 characters.")
    @NotEmpty(message = "Ingredients could not be empty.")
    private String ingredients;

    @NotNull(message = "You must select category.")
    private CategoryNameEnum category;

    public RecipeAddBindingModel() {
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
}
