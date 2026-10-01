# Command Pattern

Command turns a request into an **object**. You can store it, pass it, queue it, or run it later — without the caller knowing *how* the work is done.

Here a `RemoteControl` (invoker) only knows `Command.execute()`. It does not know about `Light`. Each command object holds the receiver and the action.

## How it works

```
 Invoker (does not know Light)     Command object              Receiver (does the real work)
┌────────────────┐              ┌──────────────────┐         ┌──────────────┐
│ RemoteControl  │  holds       │    Command       │         │    Light     │
│                │─────────────►│    execute()     │         │  turnOn()    │
│ setCommand()   │              └────────▲─────────┘         │  turnOff()   │
│ pressButton()  │                       │                   │  dim()       │
└───────┬────────┘                       │ implements        └──────▲───────┘
        │                                │                          │
        │ pressButton()                  │                          │ calls
        │     └── execute()     ┌────────┴─────────┐                │
        └──────────────────────►│ LightOnCommand   ├────────────────┘
                                │ LightOffCommand  │
                                │ lambda / method  │
                                │ reference        │
                                └──────────────────┘
```

## Call flow

```
StartCommand
    │
    │  remote.setCommand(new LightOffCommand(light))
    │  remote.pressButton()
    ▼
RemoteControl.pressButton()
    │
    │  command.execute()          ← remote never mentions Light
    ▼
LightOffCommand.execute()
    │
    │  light.turnOff()
    ▼
Light.turnOff()  →  "Light turned OFF"
```

The same remote can later hold `LightOnCommand`, an anonymous class, a lambda `() -> light.dim()`, or a method reference `light::dim`. The button code never changes.

## Classes in this folder

| Class             | Role                                         |
|-------------------|----------------------------------------------|
| `Command`         | Interface for an action (`execute()`)        |
| `Light`           | Receiver — the object that actually works    |
| `LightOnCommand`  | Concrete command: turn the light on          |
| `LightOffCommand` | Concrete command: turn the light off         |
| `RemoteControl`   | Invoker — stores a command and runs it       |
| `StartCommand`    | Demo of swapping commands at runtime         |
