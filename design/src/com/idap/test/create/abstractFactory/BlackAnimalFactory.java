package com.idap.test.create.abstractFactory;

public class BlackAnimalFactory implements IAnimalFactory {

	@Override
	public ICat createCat() {
		return new BlackCat();
	}

}
