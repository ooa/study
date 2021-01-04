package com.github.ooa.study.pattern.strategy.normal;

/**
 * @ClassName: Context
 * @Description: TODO
 * @Author: XiaoMing
 * @Date: 2021年01月04日 20:00
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
