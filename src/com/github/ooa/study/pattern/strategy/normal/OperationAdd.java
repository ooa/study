package com.github.ooa.study.pattern.strategy.normal;

/**
 * @ClassName: OperationAdd
 * @Description: TODO
 * @Author: XiaoMing
 * @Date: 2021年01月04日 19:57
 */
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
