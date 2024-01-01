package com.example.food.Service;


import com.example.food.mapper.FoodMapper;
import com.example.food.model.Food;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    private final FoodMapper foodMapper;

    public FoodService (FoodMapper foodMapper){
        this.foodMapper = foodMapper;
    }
    public Food[] getFoods() {

        return foodMapper.selectFoods();
    }
    public int addFoods(Food food){
        return foodMapper.insertFood(food);
    }


}
