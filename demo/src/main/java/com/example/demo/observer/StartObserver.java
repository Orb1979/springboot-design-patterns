package com.example.demo.observer;

import com.example.demo.StartupTask;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class StartObserver implements StartupTask {

	@Override
	public void execute() {

		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("Observer pattern (Publisher / Subscriber)");
		System.out.println("---------------------------------------------------------------------------------------------");

		// each subscriber sees the update without the publisher need to know who they are or how the handle it (decoupling)
		NewsPublisher publisher = new NewsPublisher();

		Observer alice = new EmailSubscriber("Alice");
		Observer bob = new DiscordSubscriber("bob");

		publisher.attach(alice);
		publisher.attach(bob);

		publisher.notifyObservers("new video just released, check it out!");


	}
}
