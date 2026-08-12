package com.example.demo.decorator.optional;

import com.example.demo.decorator.TextEditor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// optional service class, where we use a Qualifier in the constructor (instead of a builder approach)
// so we know which bean to choose from Config class
@Service
public class EditorService {

	private final TextEditor editor;

	public EditorService(@Qualifier("fullEditor") TextEditor editor) {
		this.editor = editor;
	}

	public void generateDocument(){
		editor.render();
	}
}