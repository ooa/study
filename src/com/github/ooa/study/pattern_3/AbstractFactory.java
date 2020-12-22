package com.github.ooa.chudq.pattern_3;

public abstract class AbstractFactory {
	abstract Computer getComputer(String brank);
	abstract Phone getPhone();
}
