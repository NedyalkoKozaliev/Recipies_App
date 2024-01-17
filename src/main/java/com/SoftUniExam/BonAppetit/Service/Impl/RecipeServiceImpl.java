package com.SoftUniExam.BonAppetit.Service.Impl;

import com.SoftUniExam.BonAppetit.Model.Entity.Category;
import com.SoftUniExam.BonAppetit.Model.Entity.User;
import com.SoftUniExam.BonAppetit.Repository.UserRepository;
import com.SoftUniExam.BonAppetit.Current.CurrentUser;
import com.SoftUniExam.BonAppetit.Model.Entity.Recipe;
import com.SoftUniExam.BonAppetit.Model.Service.RecipeServiceModel;
import com.SoftUniExam.BonAppetit.Repository.RecipeRepository;
import com.SoftUniExam.BonAppetit.Service.CategoryService;
import com.SoftUniExam.BonAppetit.Service.RecipeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final RecipeRepository recipeRepository;
    private final CurrentUser currentUser;
    private final UserRepository userRepository;

@Autowired
    public RecipeServiceImpl(ModelMapper modelMapper, CategoryService categoryService, CategoryService conditionService, RecipeRepository productRepository, RecipeRepository recipeRepository, CurrentUser currentUser, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.categoryService = conditionService;
        this.recipeRepository = recipeRepository;

        this.currentUser = currentUser;
        this.userRepository = userRepository;
    }

    @Override
    public void addRecipe(RecipeServiceModel recipeServiceModel) {
        Recipe recipe =modelMapper.map(recipeServiceModel, Recipe.class);
        recipe.setAddedBy(findUserById(currentUser.getId()));
        recipe.setCategory(categoryService.findByCategoryNameEnum(recipeServiceModel.getCategory()));
       recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> findAllByCategory(Category category) {
        return recipeRepository.findAllByCategory(category);
    }

    @Override
    public Recipe findByID(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    private User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
