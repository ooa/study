package com.github.ooa.study.pattern.builder.Meal;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Meal
 * @Description: TODO
 * @Author: XiaoMing
 * @Date: 2021年01月18日 18:14
 */
public class Meal {
    List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }
}
