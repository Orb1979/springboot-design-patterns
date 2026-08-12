package com.example.demo.strategy;

import com.example.demo.StartupTask;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class StartStrategy implements StartupTask {

	@Override
	public void execute() {

		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("Strategy pattern");
		System.out.println("---------------------------------------------------------------------------------------------");

		// how do you make an algorithm or behavior interchangeable without stuffing your code with if/else
		// solves:
		// 1. Eliminates giant conditional logic
		// 2. Makes algorithms interchangeable. You can switch behavior at runtime.
		// 3. Separates concerns. Each strategy handles one algorithm only.
		// 4. Easier extension. Add new strategies without modifying existing classes.
		// 5. Easier testing		Each algorithm can be tested independently.

		CreditCardPayment cp = new CreditCardPayment();
		PaypalPayment pp = new PaypalPayment();
		new PaymentService(cp).makePayment(100000000);
		new PaymentService(pp).makePayment(10);
	}
}
