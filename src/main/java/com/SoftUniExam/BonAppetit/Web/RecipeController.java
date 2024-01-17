package com.SoftUniExam.BonAppetit.Web;

import com.SoftUniExam.BonAppetit.Current.CurrentUser;
import com.SoftUniExam.BonAppetit.Model.Binding.RecipeAddBindingModel;

import com.SoftUniExam.BonAppetit.Model.Entity.User;
import com.SoftUniExam.BonAppetit.Model.Service.RecipeServiceModel;
import com.SoftUniExam.BonAppetit.Repository.RecipeRepository;
import com.SoftUniExam.BonAppetit.Repository.UserRepository;
import com.SoftUniExam.BonAppetit.Service.RecipeService;
import com.SoftUniExam.BonAppetit.Service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserRepository userRepository;
    private final UserService userService;
    private final RecipeRepository recipeRepository;

    public RecipeController(RecipeService recipeService, ModelMapper modelMapper, CurrentUser currentUser, UserRepository userRepository, UserService userService, RecipeRepository recipeRepository) {
        this.recipeService = recipeService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userRepository = userRepository;
        this.userService = userService;
        this.recipeRepository = recipeRepository;
    }

    @ModelAttribute
    public RecipeAddBindingModel recipeAddBindingModel(){
        return new RecipeAddBindingModel();
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (currentUser.getId() == null) {
            return "redirect:/users/login";
        }
        if (!model.containsAttribute("recipeAddBindingModel")) {
            model.addAttribute("recipeAddBindingModel", new RecipeAddBindingModel());
        }
        return "recipe-add";
    }

    @PostMapping("/add")
    public String addRecipe(@Valid RecipeAddBindingModel recipeAddBindingModel, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("recipeAddBindingModel", recipeAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springFramework.validation.BindingResult.recipeAddBindingModel", bindingResult);
            return "recipe-add";
        }
      recipeService.addRecipe(modelMapper.map(recipeAddBindingModel, RecipeServiceModel.class));
        return "redirect:/";

    }


    @GetMapping("/fav/{id}")
    public String favorite(@PathVariable Long id) {
        User user=userService.findUserByUsername(currentUser.getUsername());
        if(!user.getFavouriteRecipes().contains(recipeService.findByID(id))){
        user.getFavouriteRecipes().add(recipeService.findByID(id));
        userRepository.save(user);}
        return "redirect:/";
    }

}
