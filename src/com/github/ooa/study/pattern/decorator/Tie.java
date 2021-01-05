package com.github.ooa.study.pattern.decorator;

/**
 * @ClassName: Tie
 * @Description: TODO
 * @Author: XiaoMing
 * @Date: 2021年01月05日 9:55
 */
public class Tie extends Finery{
    @Override
    public void show() {
        System.out.print(" 领带");
        component.show();
    }
}
