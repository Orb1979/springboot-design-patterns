package com.example.demo.observer;

// concrete Subscriber
public class DiscordSubscriber implements Observer {

	private String name;

	public DiscordSubscriber(String name) {
		this.name = name;
	}

	@Override
	public void update(String message) {
		// logic how to update some discord feed..
		System.out.println(name + " received discord message: " + message);
	}
}
