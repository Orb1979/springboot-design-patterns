# Factory Method Pattern

Factory Method lets you create objects **without hard-coding the concrete class**. The client calls `someOperation()` on a creator. The creator decides *which* product to make in `create()`.

This folder shows two styles of the same idea:

1. **Classic** (`normal/`) — abstract class with an abstract `create()`
2. **Functional** (`fi/`) — interface with one method, so you can pass `Toyota::new`

## How it works (classic)

```
 Creator (knows the steps)              Product (does the work)
┌────────────────────┐               ┌─────────────┐
│  AnimalCreator     │  creates      │   Animal    │
│                    │──────────────►│ doSomething │
│  create()  ◄───────┼─ override     └──────▲──────┘
│  someOperation()   │                      │
└─────────▲──────────┘                      │ implements
          │ extends                         │
          │                        ┌────────┴────────┐
┌─────────┴──────────┐             │                 │
│  PandaCreator      │             │  Panda          │
│  create() → Panda  │             │  Lion           │
└────────────────────┘             └─────────────────┘
```

`someOperation()` always looks the same: create an animal, then use it. Swap the creator (or use an anonymous subclass for `Lion`) and the rest of the code stays put.

## Call flow (classic)

```
Start
    │
    │  AnimalCreator creator = new PandaCreator()
    │  creator.someOperation()
    ▼
AnimalCreator.someOperation()
    │
    │  Animal animal = create()     ← factory method (subclass chooses)
    ▼
PandaCreator.create()  →  new Panda()
    │
    │  animal.doSomething()
    ▼
Panda.doSomething()  →  "chewing on bamboo"
```

## How it works (functional interface)

Same pattern, but `CarCreator` is an interface with **one** abstract method. A default `someOperation()` still creates, then drives. You can pass a constructor reference instead of writing a `ToyotaCreator` class.

```
┌────────────────────┐               ┌─────────────┐
│  CarCreator        │  creates      │    Car      │
│  create()          │──────────────►│  drive()    │
│  someOperation()   │               └──────▲──────┘
│  (default method)  │                      │
└─────────▲──────────┘                      │ implements
          │                                 │
          │  CarCreator creator = Toyota::new
          │                        Porsche::new
          │
   ┌──────┴──────┐
   │ Toyota      │
   │ Porsche     │
   └─────────────┘
```

```
CarCreator creator = Toyota::new
creator.someOperation()
    │
    │  Car car = create()   →  new Toyota()
    │  car.drive()
    ▼
"Toyota driving 100km/h"
```

## Classes in this folder

| Class / package        | Role                                      |
|------------------------|-------------------------------------------|
| `normal/Animal`        | Product interface                         |
| `normal/Panda`, `Lion` | Concrete products                         |
| `normal/AnimalCreator` | Creator — `create()` + `someOperation()`  |
| `normal/PandaCreator`  | Concrete creator for pandas               |
| `fi/Car`               | Product interface (functional style)      |
| `fi/Toyota`, `Porsche` | Concrete products                         |
| `fi/CarCreator`        | Functional factory (method reference)     |
| `Start`                | Demo of both styles                       |
