package com.github.ooa.study.pattern.builder.Meal;

/**
 * @ClassName: Item
 * @Description: TODO
 * @Author: XiaoMing
 * @Date: 2021年01月18日 18:14
 */
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
