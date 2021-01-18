package com.github.ooa.study.pattern.builder.Meal;

/**
 * @ClassName: VegBurger
 * @Description: TODO
 * @Author: XiaoMing
 * @Date: 2021年01月18日 19:34
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
