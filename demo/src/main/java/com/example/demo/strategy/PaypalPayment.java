package com.example.demo.strategy;

public class PaypalPayment implements Payment {
	@Override
	public void pay(int amount) {
		System.out.println("paid " + amount + " using PayPal");
	}
}
