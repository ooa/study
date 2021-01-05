package com.github.ooa.study.pattern.decorator;

/**
 * @ClassName: Finery
 * @Description: Decorator
 * @Author: XiaoMing
 * @Date: 2021年01月05日 9:49
 */
public class Finery extends Person{

    protected Person component;

    //打扮
    public void decorate(Person component){
        this.component = component;
    }

    @Override
    public void show(){
        if(component!=null){
            component.show();
        }
    }

}
