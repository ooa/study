package com.github.ooa.study.pattern.decorator;

/**
 * @ClassName: Sneakers
 * @Description: TODO
 * @Author: XiaoMing
 * @Date: 2021年01月05日 9:53
 */
public class Sneakers extends Finery {
    @Override
    public void show() {
        System.out.print(" 破球鞋");
        component.show();
    }
}
