package com.example.demo.factory.normal;

public class LionCreator extends AnimalCreator {

	@Override
	public Animal create() {
		return new Lion();
	}
}
