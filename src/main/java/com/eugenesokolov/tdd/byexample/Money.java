package com.eugenesokolov.tdd.byexample;

public class Money implements Expression {

	protected int amount;
	protected String currency;

	static Money dollar(int amount) {
		return new Money(amount, "USD");
	}

	static Money franc(int amount) {
		return new Money(amount, "CHF");
	}

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public Money times(int multiplier) {
		return new Money(amount * multiplier, currency);
	}

	public boolean equals(Object obj) {
		Money money = (Money) obj;
		return amount == money.amount && currency == money.currency;
	}

	public String currency() {
		return currency;
	}

	public Expression plus(Money added) {
		return new Sum(this, added);
	}

	@Override
	public Money reduce(Bank bank, String to) {
		int rate = bank.rate(currency, to); 
		return new Money(amount / rate, to);
	}

}
