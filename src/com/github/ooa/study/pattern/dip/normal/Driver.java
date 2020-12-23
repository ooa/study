package com.github.ooa.study.pattern.dip.normal;

/**
 * @ClassName: Driver
 * @Description: TODO
 * @Author: XiaoMing
 * @Date: 2020年12月22日 18:18
 */
public class Driver implements IDriver{

    @Override
    public void drive(ICar car) {
        car.run();
    }
}
