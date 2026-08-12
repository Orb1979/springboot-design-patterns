package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

// if you use multiple CommandLineRunners, to start your code when Spring is initialized
// (e.g because you have no Controller)
// you can use a orchestration pattern like this

@Component
public class AppStartRunner implements CommandLineRunner {

	private final List<StartupTask> tasks;

	public AppStartRunner(List<StartupTask> tasks) {
		this.tasks = tasks;
	}

	@Override
	public void run(String... args) throws Exception {
		tasks.forEach(StartupTask::execute);
	}
}




