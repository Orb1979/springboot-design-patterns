package com.example.demo.factory;

import com.example.demo.StartupTask;
import com.example.demo.factory.fi.CarCreator;
import com.example.demo.factory.fi.Porsche;
import com.example.demo.factory.fi.Toyota;
import com.example.demo.factory.normal.Lion;
import com.example.demo.factory.normal.PandaCreator;
import com.example.demo.factory.normal.Animal;
import com.example.demo.factory.normal.AnimalCreator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Start implements StartupTask {

	@Override
	public void execute() {
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("Factory pattern");
		System.out.println("---------------------------------------------------------------------------------------------");
		// easily swap out the concrete creators (PandaCreator, LionCreator, MockedCreator)
		// without touching any other logic which makes it very flexible

		if (Math.random() <= 0.5 ){
			AnimalCreator creator = new PandaCreator();
			creator.someOperation();
		} else {
			// or with anonymouse override (so we don't need to create a LionCreator Class)
			AnimalCreator creator = new AnimalCreator() {
				@Override
				public Animal create() {
					return new Lion();
				}
			};
			creator.someOperation();
		}

		// Similar to abstract class AnimalCreator but as functional interface
		// A functional interface is an interface that has exactly one abstract method.
		CarCreator creator1 = Toyota::new;
		creator1.someOperation();

		CarCreator creator2 = Porsche::new;
		creator2.someOperation();

	}
}
