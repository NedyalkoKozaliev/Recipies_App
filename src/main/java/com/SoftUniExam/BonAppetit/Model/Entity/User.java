package com.SoftUniExam.BonAppetit.Model.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="users")
public class User extends BaseEntity{


  private String username;

  private String password;


   private String email;
   private Set<Recipe> addedRecipes;

   private Set<Recipe> favouriteRecipes;

    public User() {
    }

    @Column(nullable = false,unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = false,unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @OneToMany(mappedBy = "addedBy",fetch = FetchType.EAGER)
    public Set<Recipe> getAddedRecipes() {
        return addedRecipes;
    }

    public void setAddedRecipes(Set<Recipe> addedRecipes) {
        this.addedRecipes = addedRecipes;
    }
    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Recipe> getFavouriteRecipes() {
        return favouriteRecipes;
    }

    public void setFavouriteRecipes(Set<Recipe> favouriteRecipes) {
        this.favouriteRecipes = favouriteRecipes;
    }


}
