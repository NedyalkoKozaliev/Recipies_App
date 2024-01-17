package com.SoftUniExam.BonAppetit.Web;


import com.SoftUniExam.BonAppetit.Model.Entity.Category;
import com.SoftUniExam.BonAppetit.Model.Entity.CategoryNameEnum;
import com.SoftUniExam.BonAppetit.Model.Entity.Recipe;
import com.SoftUniExam.BonAppetit.Model.View.OfferViewModel;
import com.SoftUniExam.BonAppetit.Current.CurrentUser;
import com.SoftUniExam.BonAppetit.Repository.CategoryRepository;
import com.SoftUniExam.BonAppetit.Repository.RecipeRepository;
import com.SoftUniExam.BonAppetit.Repository.UserRepository;
import com.SoftUniExam.BonAppetit.Service.CategoryService;
import com.SoftUniExam.BonAppetit.Service.RecipeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {


    private final CurrentUser currentUser;
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RecipeService recipeService;
    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    public HomeController(CurrentUser currentUser, RecipeRepository recipeRepository, UserRepository userRepository, ModelMapper modelMapper, RecipeService recipeService, CategoryRepository categoryRepository, CategoryService categoryService) {
        this.currentUser = currentUser;
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.recipeService = recipeService;

        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }



    @GetMapping("/")
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";

        }



       String Logged=currentUser.getUsername();
        List<Recipe> main=recipeService.findAllByCategory(categoryService.findByCategoryNameEnum(CategoryNameEnum.valueOf("MAIN_DISH")));
        List<Recipe>dessert=recipeService.findAllByCategory(categoryService.findByCategoryNameEnum(CategoryNameEnum.valueOf("DESSERT")));
        List<Recipe>cocktails=recipeService.findAllByCategory(categoryService.findByCategoryNameEnum(CategoryNameEnum.valueOf("COCKTAIL")));
        List<Recipe>favorites=userRepository.findById(currentUser.getId()).get().getFavouriteRecipes().stream().toList();







        model.addAttribute("MainDishes",main);
        model.addAttribute("Desserts",dessert);
        model.addAttribute("Cocktails",cocktails);
        model.addAttribute("Favorites",favorites);


    model.addAttribute("Logged", Logged);

        return "home";
    }


}
