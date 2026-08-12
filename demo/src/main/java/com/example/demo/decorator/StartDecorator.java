package com.example.demo.decorator;

import com.example.demo.StartupTask;
import com.example.demo.decorator.decorators.AutoSaveDecorator;
import com.example.demo.decorator.decorators.SpellCheckDecorator;
import com.example.demo.decorator.optional.EditorBuilder;
import com.example.demo.decorator.optional.EditorService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class StartDecorator implements StartupTask {

	private final EditorService editorService;

	public StartDecorator(EditorService editorService) {
		this.editorService = editorService;
	}

	@Override
	public void execute() {
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("Decorator Pattern");
		System.out.println("---------------------------------------------------------------------------------------------");
		// solves: adding behavior to an object dynamically without modifying its original class
		// Instead of creating lots of subclasses for every feature combination, you “wrap” an object
		// with decorator objects that add responsibilities.
		// It’s commonly used when:
		// - You want to extend functionality at runtime
		// - You want to avoid creating lots of subclasses
		// - You want flexible combinations of features
		TextEditor editor1 = new AutoSaveDecorator(new SpellCheckDecorator(new BasicEditor()));
		editor1.render();
		System.out.println("---");

		// optional use a builder (less wrapping)
		TextEditor editor2 = EditorBuilder.create()
				                     .withSpellCheck()
				                     .withAutoSave()
				                     .build();
		editor2.render();
		System.out.println("---");

		// optional or use @Qualifier and a Config Class
		// is recommended to use @Qualifier through constructor
		editorService.generateDocument();
	}
}
