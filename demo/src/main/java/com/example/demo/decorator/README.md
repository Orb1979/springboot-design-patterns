# Decorator Pattern

Decorator adds behavior to an object **at runtime** by wrapping it, instead of subclassing every feature combination.

A decorator *is* a `TextEditor` and *contains* a `TextEditor`. Each wrapper does extra work, then (or before) delegates to the inner editor.

## How it works

```
 Shared interface
┌─────────────────┐
│   TextEditor    │
│   render()      │
└────────▲────────┘
         │
         │  implements
         │
    ┌────┴─────┬──────────────────────────┐
    │          │                          │
┌───┴─────┐  ┌─┴────────────────┐         │
│ Basic   │  │ EditorDecorator  │ wraps   │
│ Editor  │  │  editor.render() ├─────────┘
└─────────┘  └────────▲─────────┘
                      │  extends
           ┌──────────┴──────────┐
           │                     │
┌──────────┴──────────┐ ┌────────┴────────────┐
│ SpellCheckDecorator │ │ AutoSaveDecorator   │
│ + spell check       │ │ + auto-save         │
└─────────────────────┘ └─────────────────────┘
```

## Wrapping (nesting)

You stack wrappers. The outermost object is still a `TextEditor`.

```
  editor1 = new AutoSaveDecorator(
                new SpellCheckDecorator(
                    new BasicEditor()))

  ┌──────────────────────┐
  │ AutoSaveDecorator    │  outermost
  │   ┌──────────────────┤
  │   │ SpellCheckDec.   │
  │   │   ┌──────────────┤
  │   │   │ BasicEditor  │  innermost
  │   │   └──────────────┤
  │   └──────────────────┤
  └──────────────────────┘
```

## Call flow (`render()`)

Each decorator calls the next one, then adds its own feature:

```
editor1.render()
    │
    ▼
AutoSaveDecorator.render()
    │  super.render()
    ▼
SpellCheckDecorator.render()
    │  super.render()
    ▼
BasicEditor.render()
    │
    ▼
"rendering plain text editor"
"adding spell check feature"
"enable auto-save feature"
```

## Optional helpers in this package

Wrapping by hand gets noisy. This demo also shows two ways to build the same stack:

- `optional/EditorBuilder` — fluent wrapping (`withSpellCheck().withAutoSave().build()`)
- `optional/EditorConfig` + `EditorService` — Spring beans (`@Qualifier("fullEditor")`)

## Classes in this folder

| Class / package                  | Role                                         |
|----------------------------------|----------------------------------------------|
| `TextEditor`                     | Component interface                          |
| `BasicEditor`                    | Concrete component (plain editor)            |
| `EditorDecorator`                | Base decorator (holds and delegates)         |
| `decorators/SpellCheckDecorator` | Adds spell check after render                |
| `decorators/AutoSaveDecorator`   | Adds auto-save after render                  |
| `optional/EditorBuilder`         | Builds a wrapped editor without nested `new` |
| `optional/EditorConfig`          | Spring beans for common combinations         |
| `StartDecorator`                 | Demo of wrapping, builder, and DI            |
