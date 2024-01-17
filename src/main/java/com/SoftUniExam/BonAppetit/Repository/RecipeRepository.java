package com.SoftUniExam.BonAppetit.Repository;


import com.SoftUniExam.BonAppetit.Model.Entity.Category;
import com.SoftUniExam.BonAppetit.Model.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long >{




    Optional<Recipe> findById(Long id);

    List<Recipe> findAllByCategory(Category category);

}
