package com.SoftUniExam.BonAppetit.Model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="categories")
public class Category extends BaseEntity{

    private CategoryNameEnum categoryName;
    private String description;

    public Category() {
    }

    @Enumerated(EnumType.STRING)
    @Column(unique = true,nullable = false)
    public CategoryNameEnum getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryNameEnum categoryName) {
        this.categoryName = categoryName;
    }

    @Column(nullable = false,columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
