package com.example.demo.decorator;

public class BasicEditor implements TextEditor {

	public BasicEditor() {
	}

	@Override
	public void render() {
		System.out.println("rendering plain text editor");
	}
}
