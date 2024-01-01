package com.example.food.controller;

import com.example.food.Service.FoodService;
import com.example.food.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FoodController {
    private FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/home")
    public String addFood(Model model,Food food){
        int result = foodService.addFoods(food);
        if(result < 1){
            model.addAttribute("errorMessage", String.format("Could not add %s", food.getName()));
        }
        model.addAttribute("secccessMessage", String.format("Successfully added %s", food.getName()));

        Food[] foods= foodService.getFoods();
        model.addAttribute("foods",foods);
        return "home";
    }


    @GetMapping("/home")
    public String getHome(Model model,Food food){

        model.addAttribute("Message","Hello My friend");
        Food[] foods=foodService.getFoods();
        model.addAttribute("foods",foods);


        return "home";
    }
}
