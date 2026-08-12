package com.example.demo.factory.normal;

public abstract class AnimalCreator {

	public abstract Animal create();

	public void someOperation() {
		Animal animal = create();
		animal.doSomething();
	}

}
