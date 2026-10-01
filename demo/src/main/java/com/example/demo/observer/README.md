# Observer Pattern (Publisher / Subscriber)

Observer lets many objects react to an event **without the publisher knowing who they are** or how they handle the message.

`NewsPublisher` keeps a list of `Observer`s. When news arrives it calls `update()` on each one. Subscribers can attach or detach independently.

## How it works

```
┌──────────────────┐  attach / detach / notify     ┌──────────────────┐
│    Publisher     │◄─────────────────────────────►│    Observer      │
│  attach(o)       │                               │  update(message) │
│  detach(o)       │                               └────────▲─────────┘
│  notifyObservers │                                        │
└────────▲─────────┘                                        │ implements
         │ implements                          ┌────────────┴────────────┐
         │                                     │                         │
┌────────┴─────────┐                 ┌─────────┴────────┐    ┌───────────┴──────────┐
│  NewsPublisher   │  holds list of  │ EmailSubscriber  │    │ DiscordSubscriber    │
│  List<Observer>  │────────────────►│ Alice            │    │ bob                  │
└──────────────────┘                 └──────────────────┘    └──────────────────────┘
```

The publisher only depends on `Observer`. It never imports email or Discord details.

## Call flow

```
StartObserver
    │
    │  publisher.attach(alice)          EmailSubscriber
    │  publisher.attach(bob)            DiscordSubscriber
    │
    │  publisher.notifyObservers("new video just released, check it out!")
    ▼
NewsPublisher.notifyObservers(message)
    │
    │  for each observer:
    │      observer.update(message)
    │
    ├──────────────────────► EmailSubscriber.update()
    │                          "Alice received email message: ..."
    │
    └──────────────────────► DiscordSubscriber.update()
                               "bob received discord message: ..."
```

## Classes in this folder

| Class               | Role                                           |
|---------------------|------------------------------------------------|
| `Publisher`         | Subject interface (attach / detach / notify)   |
| `Observer`          | Subscriber interface (`update`)                |
| `NewsPublisher`     | Concrete subject — stores observers            |
| `EmailSubscriber`   | Concrete observer — handles news as email      |
| `DiscordSubscriber` | Concrete observer — handles news as Discord    |
| `StartObserver`     | Demo: attach two subscribers, then notify      |
