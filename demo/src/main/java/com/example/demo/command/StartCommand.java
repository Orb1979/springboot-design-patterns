package com.example.demo.command;

import com.example.demo.StartupTask;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(5)
public class StartCommand implements StartupTask {

	@Override
	public void execute() {
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("Command Pattern");
		System.out.println("---------------------------------------------------------------------------------------------");
		/*
		It turns a request / action into an object, so you can store it, pass it, queue it, undo it, or execute it later
		without the caller knowing how it works.

		The problem it solves
		Without the Command pattern, you usually do this:
		button.click();

		But that directly couples:
   	the invoker (button) to the action logic (what click does)

		That leads to problems:
		❌ Tight coupling - The button needs to know what to do.
		❌ Hard to extend -dding new actions means changing button code or lots of conditionals.
		❌ No easy undo/redo - Once executed, the action is gone.
		❌ No queuing or logging -	You can’t easily store actions for later.
		*/

		Light light = new Light();

		Command cmd1 = new LightOffCommand(light);
		Command cmd2 = new LightOnCommand(light);

		RemoteControl remote = new RemoteControl();

		remote.setCommand(cmd1);
		remote.pressButton();

		remote.setCommand(cmd2);
		remote.pressButton();


		// anonymouse command
		remote.setCommand(new Command() {
			@Override
			public void execute() {
				light.dim();
			}
		});
		remote.pressButton();

		// anonymouse command as functional interface (lambda)
		remote.setCommand( ()-> light.dim());
		remote.pressButton();

		// anonymouse command as functional interface (method reference)
		remote.setCommand(light::dim);
		remote.pressButton();
		}
}
