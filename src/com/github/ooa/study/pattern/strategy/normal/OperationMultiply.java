package com.github.ooa.study.pattern.strategy.normal;

/**
 * @ClassName: OperationMultiply
 * @Description: TODO
 * @Author: XiaoMing
 * @Date: 2021年01月04日 19:59
 */
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
