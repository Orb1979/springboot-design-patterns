package com.example.demo.observer;

// concrete Subscriber
public class EmailSubscriber implements Observer {

	private String name;

	public EmailSubscriber(String name) {
		this.name = name;
	}

	@Override
	public void update(String message) {
		// logic how to update send an email ..
		System.out.println(name + " received email message: " + message);
	}
}
