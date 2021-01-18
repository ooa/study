package com.github.ooa.study.pattern.builder.Meal;

import com.github.ooa.study.pattern.builder.Meal.Item;
import com.github.ooa.study.pattern.builder.Meal.Packing;
import com.github.ooa.study.pattern.builder.Meal.Wrapper;

/**
 * @ClassName: Burger
 * @Description: TODO
 * @Author: XiaoMing
 * @Date: 2021年01月18日 19:31
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing(){
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
