package com.example.demo.observer;

import java.util.ArrayList;
import java.util.List;

// concrete Publisher
public class NewsPublisher implements Publisher {
	private final List<Observer> observers = new ArrayList<>();

	@Override
	public void attach(Observer o) {
		observers.add(o);
	}

	@Override
	public void detach(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers(String message) {
		for (Observer o : observers) {
			o.update(message);
		}

	}
}
