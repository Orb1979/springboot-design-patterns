package com.example.demo.decorator.optional;

import com.example.demo.decorator.BasicEditor;
import com.example.demo.decorator.TextEditor;
import com.example.demo.decorator.decorators.AutoSaveDecorator;
import com.example.demo.decorator.decorators.SpellCheckDecorator;

// optional builder, so we don't have to wrap multiple objects everytime
public class EditorBuilder {

	private TextEditor editor = new BasicEditor();

	public EditorBuilder withSpellCheck() {
		editor = new SpellCheckDecorator(editor);
		return this;
	}

	public EditorBuilder withAutoSave() {
		editor = new AutoSaveDecorator(editor);
		return this;
	}

	public TextEditor build() {
		return editor;
	}

	public static EditorBuilder create() {
		return new EditorBuilder();
	}
}