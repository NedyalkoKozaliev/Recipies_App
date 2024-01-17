package com.SoftUniExam.BonAppetit.Service;

import com.SoftUniExam.BonAppetit.Model.Entity.Category;
import com.SoftUniExam.BonAppetit.Model.Entity.Recipe;
import com.SoftUniExam.BonAppetit.Model.View.OfferViewModel;
import com.SoftUniExam.BonAppetit.Model.Service.RecipeServiceModel;

import java.util.List;

public interface RecipeService {

    void addRecipe(RecipeServiceModel recipeServiceModel);
    List<Recipe> findAllByCategory(Category category);

    Recipe findByID(Long id);

}
