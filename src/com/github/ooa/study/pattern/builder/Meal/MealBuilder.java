package com.github.ooa.study.pattern.builder.Meal;

/**
 * @ClassName: MealBuilder
 * @Description: TODO
 * @Author: XiaoMing
 * @Date: 2021年01月18日 18:16
 */
public class MealBuilder {

    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        return meal;
    }

}
