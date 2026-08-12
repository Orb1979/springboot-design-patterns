package com.example.demo.strategy;

public class PaymentService {
	private final Payment strategy;

	public PaymentService(Payment strategy) {
		this.strategy = strategy;
	}

	 public void makePayment(int amount){
		strategy.pay(amount);
	 }
}


// without the strategy Pattern, this service would have something like this
// violates the open / closed principle

//class PaymentService {
//
//	void makePayment(String type, int amount) {
//
//		if (type.equals("paypal")) {
//			System.out.println("Paying with PayPal");
//		}
//
//		else if (type.equals("creditcard")) {
//			System.out.println("Paying with Credit Card");
//		}
//
//		else if (type.equals("crypto")) {
//			System.out.println("Paying with Crypto");
//		}
//	}
//}