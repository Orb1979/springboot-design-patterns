# Strategy Pattern

Strategy makes an algorithm **interchangeable** \
The service asks a `Payment` to pay. \
Which payment method is used is injected — not a pile of `if / else`.

Without this pattern, `PaymentService` would grow a new branch for every type (PayPal, card, crypto, …) \
and violate the open/closed principle. \
With Strategy, you add a new class instead of editing the service.

## How it works

```
 Context (stable)                    Strategy (swappable)
┌──────────────────┐              ┌─────────────────┐
│  PaymentService  │  uses        │    Payment      │
│                  │─────────────►│    pay(amount)  │
│  makePayment()   │              └────────▲────────┘
└────────┬─────────┘                       │ implements
         │                                 │
         │  new PaymentService(strategy)   │
         │                        ┌────────┴─────────┐
         │                        │                  │
         │               ┌────────┴─────────┐ ┌──────┴──────────┐
         └──────────────►│ CreditCardPayment│ │ PaypalPayment   │
                         │ pay() via card   │ │ pay() via PayPal│
                         └──────────────────┘ └─────────────────┘
```

`PaymentService` never mentions credit cards or PayPal. It only calls `strategy.pay(amount)`.

## Call flow

```
StartStrategy
    │
    │  new PaymentService(new CreditCardPayment()).makePayment(100000000)
    ▼
PaymentService.makePayment(amount)
    │
    │  strategy.pay(amount)
    ▼
CreditCardPayment.pay(amount)
    │
    ▼
"paid 100000000 using credit card"


same service, different strategy:

new PaymentService(new PaypalPayment()).makePayment(10)
    │
    ▼
"paid 10 using PayPal"
```

## Classes in this folder

| Class               | Role                                       |
|---------------------|--------------------------------------------|
| `Payment`           | Strategy interface                         |
| `CreditCardPayment` | Concrete strategy                          |
| `PaypalPayment`     | Concrete strategy                          |
| `PaymentService`    | Context — delegates to the chosen strategy |
| `StartStrategy`     | Demo of swapping payment algorithms        |
