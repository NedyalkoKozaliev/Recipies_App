package com.SoftUniExam.BonAppetit.Model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="recipes")
public class Recipe extends BaseEntity{
    private String name;

   private String ingredients;



    private Category category;

    private User addedBy;



    public Recipe() {
    }

    @Column(columnDefinition = "TEXT")
    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @OneToOne
    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
