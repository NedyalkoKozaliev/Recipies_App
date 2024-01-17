package com.SoftUniExam.BonAppetit.Service.Impl;

import com.SoftUniExam.BonAppetit.Model.Entity.Category;
import com.SoftUniExam.BonAppetit.Model.Entity.CategoryNameEnum;
import com.SoftUniExam.BonAppetit.Repository.CategoryRepository;
import com.SoftUniExam.BonAppetit.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;



    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() != 0) {
            return;
        }
        Arrays.stream(CategoryNameEnum.values())
                .forEach((categoryNameEnum -> {
                    Category category =new Category();
                    category.setCategoryName(categoryNameEnum);
                    switch (categoryNameEnum){
                        case MAIN_DISH -> category.setDescription("Heart of the meal, substantial and satisfying; main dish delights taste buds.");
                        case DESSERT -> category.setDescription("Sweet finale, indulgent and delightful; dessert crowns the dining experience with joy.");
                        case COCKTAIL -> category.setDescription("Sip of sophistication, cocktails blend flavors, creating a spirited symphony in every glass.");
                    }
                    categoryRepository.save(category);
                }));
    }

    @Override
    public Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
        return categoryRepository.findByCategoryName(categoryNameEnum).orElse(null);


    }
}
