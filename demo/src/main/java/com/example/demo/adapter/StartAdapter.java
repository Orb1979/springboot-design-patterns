package com.example.demo.adapter;

import com.example.demo.StartupTask;
import com.example.demo.command.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(5)
public class StartAdapter implements StartupTask {

	@Override
	public void execute() {
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("Adapter Pattern");
		System.out.println("---------------------------------------------------------------------------------------------");
		/*
			use this when contracts of api are incompatible with each other,
			and you can not change the (3rd pary) api.
		*/

		MediaPlayer mediaPlayer = new MediaAdapter(new LegacyPlayer());
		mediaPlayer.play("/some/path.mpeg2");


	}
}
