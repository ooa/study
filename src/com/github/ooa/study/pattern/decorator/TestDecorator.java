package com.github.ooa.study.pattern.decorator;

public class TestDecorator {

	public static void main(String[] args) {
		Person person = new Person("菜菜");
		Finery bigTrouser = new BigTrouser();
		Finery leatherShoes = new LeatherShoes();
		Sneakers sneakers = new Sneakers();
		bigTrouser.decorate(person);
		leatherShoes.decorate(bigTrouser);
		sneakers.decorate(leatherShoes);
		sneakers.show();

		System.out.println();

		Suit suit = new Suit();
		TShirts tShirts = new TShirts();
		Tie tie = new Tie();
		suit.decorate(person);
		tShirts.decorate(suit);
		tie.decorate(tShirts);
		tie.show();

	}

}
