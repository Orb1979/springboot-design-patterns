package com.example.demo.decorator.decorators;

import com.example.demo.decorator.EditorDecorator;
import com.example.demo.decorator.TextEditor;

//@Component
public class AutoSaveDecorator extends EditorDecorator {

	public AutoSaveDecorator(TextEditor editor) {
		super(editor);
	}

	@Override
	public void render() {
		super.render();
		System.out.println("enable auto-save feature");
	}
}
