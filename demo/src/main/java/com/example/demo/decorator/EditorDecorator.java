package com.example.demo.decorator;

// This object is a TextEditor, but it also contains a TextEditor

public abstract class EditorDecorator implements TextEditor {
	protected TextEditor editor;

	public EditorDecorator(TextEditor editor) {
		this.editor = editor;
	}

	public void render(){
		editor.render(); // delegate to wrapped / contained object
	}
}
