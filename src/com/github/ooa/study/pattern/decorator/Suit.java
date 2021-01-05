package com.github.ooa.study.pattern.decorator;

/**
 * @ClassName: Suit
 * @Description: TODO
 * @Author: XiaoMing
 * @Date: 2021年01月05日 9:54
 */
public class Suit extends Finery {
    @Override
    public void show() {
        System.out.print(" 西装");
        component.show();
    }
}
