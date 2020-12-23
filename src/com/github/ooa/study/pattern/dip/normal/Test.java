package com.github.ooa.study.pattern.dip.normal;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: XiaoMing
 * @Date: 2020年12月22日 18:16
 */
class Test {

    public static void main(String[] args) {
        Driver xiaoMing = new Driver();
        Benz benz = new Benz();
        xiaoMing.drive(benz);
        Bmw bmw = new Bmw();
        xiaoMing.drive(bmw);
    }


}
