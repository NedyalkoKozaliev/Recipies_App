package com.SoftUniExam.BonAppetit.Repository;

import com.SoftUniExam.BonAppetit.Model.Entity.Category;
import com.SoftUniExam.BonAppetit.Model.Entity.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCategoryName(CategoryNameEnum categoryName);






}
