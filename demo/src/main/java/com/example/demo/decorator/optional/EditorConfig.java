package com.example.demo.decorator.optional;

import com.example.demo.decorator.BasicEditor;
import com.example.demo.decorator.TextEditor;
import com.example.demo.decorator.decorators.AutoSaveDecorator;
import com.example.demo.decorator.decorators.SpellCheckDecorator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// optional we could use a config class, so we don't have to wrap multiple objects everytime
@Configuration
public class EditorConfig {

	@Bean
	public TextEditor basicEditor() {
		return new BasicEditor();
	}

	@Bean
	public TextEditor autoSaveEditor() {
		return new AutoSaveDecorator(
				basicEditor());
	}

	@Bean
	public TextEditor spellCheckEditor() {
		return new SpellCheckDecorator(
				basicEditor());
	}

	@Bean
	public TextEditor fullEditor() {
		return new SpellCheckDecorator(
				new AutoSaveDecorator(
						basicEditor()));
	}
}