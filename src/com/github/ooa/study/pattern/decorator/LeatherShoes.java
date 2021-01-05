package com.github.ooa.study.pattern.decorator;

/**
 * @ClassName: LeatherShoes
 * @Description: ConcreteDecorator
 * @Author: XiaoMing
 * @Date: 2021年01月05日 9:52
 */
public class LeatherShoes extends Finery {
    @Override
    public void show() {
        System.out.print(" 皮鞋");
        super.show();
    }
}
