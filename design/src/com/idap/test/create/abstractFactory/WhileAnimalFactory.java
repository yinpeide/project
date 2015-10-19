package com.idap.test.create.abstractFactory;

public class WhileAnimalFactory implements IAnimalFactory {

	@Override
	public ICat createCat() {
		return new WhileCat();
	}

}
