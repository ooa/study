package com.github.ooa.study.pattern.decorator;

/**
 * @ClassName: BigTrouser
 * @Description: TODO
 * @Author: XiaoMing
 * @Date: 2021年01月05日 9:51
 */
public class BigTrouser extends Finery {

    @Override
    public void show() {
        System.out.print(" 垮裤");
        component.show();
    }
}
