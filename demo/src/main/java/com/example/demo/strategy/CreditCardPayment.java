package com.example.demo.strategy;

public class CreditCardPayment implements Payment {
	@Override
	public void pay(int amount) {
		System.out.println("paid " + amount + " using credit card");
	}
}
