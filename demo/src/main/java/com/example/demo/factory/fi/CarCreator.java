package com.example.demo.factory.fi;

public interface CarCreator {

	Car create();

	default void someOperation() {
		Car car = create();
		car.drive();
	}

}
