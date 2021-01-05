package com.github.ooa.study.pattern.decorator;

/**
 * @ClassName: TShirts
 * @Description: TODO
 * @Author: XiaoMing
 * @Date: 2021年01月05日 9:51
 */
public class TShirts extends Finery {
    @Override
    public void show() {
        System.out.print(" 大T恤");
        component.show();
    }
}
