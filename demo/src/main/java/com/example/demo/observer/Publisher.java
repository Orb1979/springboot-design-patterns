package com.example.demo.observer;

public interface Publisher {
	void attach(Observer o);
	void detach(Observer o);
	void notifyObservers(String message);
}
