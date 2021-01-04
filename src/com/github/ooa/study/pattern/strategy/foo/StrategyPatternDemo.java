package com.github.ooa.study.pattern.strategy.foo;

import com.github.ooa.study.pattern.strategy.normal.Context;
import com.github.ooa.study.pattern.strategy.normal.OperationAdd;
import com.github.ooa.study.pattern.strategy.normal.OperationMultiply;
import com.github.ooa.study.pattern.strategy.normal.OperationSubtract;

/**
 * @ClassName: StrategyPatternDemo
 * @Description: TODO
 * @Author: XiaoMing
 * @Date: 2021年01月04日 20:02
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));
        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
        context = new Context(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
    }

}
