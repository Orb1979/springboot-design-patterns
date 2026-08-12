package com.example.demo.decorator.decorators;

import com.example.demo.decorator.EditorDecorator;
import com.example.demo.decorator.TextEditor;


// @Component
public class SpellCheckDecorator extends EditorDecorator {

	public SpellCheckDecorator(TextEditor editor) {
		super(editor);
	}

	@Override
	public void render() {
		super.render();
		System.out.println("adding spell check feature");
	}
}
