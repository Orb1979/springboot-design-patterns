# Adapter Pattern

Use Adapter when two APIs do not match and you **cannot change** the other side (often third-party code).

In this example the app wants `MediaPlayer.play(path)`, but `LegacyPlayer` only has `startPlayback(path)`. `MediaAdapter` implements the interface the app expects and forwards the call.

## How it works

```
  Your code                     The contract you want          The class you cannot change
┌──────────────┐              ┌─────────────────┐            ┌──────────────────┐
│ StartAdapter │              │  MediaPlayer    │            │  LegacyPlayer    │
│              │              │  play(path)     │            │ startPlayback()  │
└──────┬───────┘              └────────▲────────┘            └────────▲─────────┘
       │                               │                              │
       │  talks to MediaPlayer         │  implements                  │  wraps
       │                               │                              │
       │                      ┌────────┴────────┐                     │
       └─────────────────────►│  MediaAdapter   ├─────────────────────┘
                              │                 │
                              │  play(path)     │
                              │    └── calls    │
                              │  startPlayback  │
                              └─────────────────┘
```

## Call flow

```
StartAdapter
    │
    │  new MediaAdapter(new LegacyPlayer())
    │  mediaPlayer.play("/some/path.mpeg2")
    ▼
MediaAdapter.play(path)
    │
    │  translates play() into startPlayback()
    ▼
LegacyPlayer.startPlayback(path)
    │
    ▼
"playing legacy /some/path.mpeg2"
```

## Classes in this folder

| Class            | Role                                      |
|------------------|-------------------------------------------|
| `MediaPlayer`    | Target — the interface the app uses       |
| `LegacyPlayer`   | Adaptee — existing API you cannot change  |
| `MediaAdapter`   | Adapter — makes the two fit together      |
| `StartAdapter`   | Demo that plays a file through the adapter|
