package com.example.demo.factory.normal;

public class PandaCreator extends AnimalCreator {

	@Override
	public Animal create() {
		return new Panda();
	}
}
