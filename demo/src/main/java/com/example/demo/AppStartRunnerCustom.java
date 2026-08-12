package com.example.demo;

import com.example.demo.observer.StartObserver;
import com.example.demo.strategy.StartStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppStartRunnerCustom {

	// just an example, this will overwrite the AppStartRunner component (See AppstartRunner Component_
	// by default spring will inject every component which matches in its constructor
	// and thus always running all StartupTask Components

//	@Bean
//	public AppStartRunner appStartRunner(
//			StartStrategy startStrategy,
//			StartObserver startObserver) {
//
//		return new AppStartRunner(
//				List.of(
//						startStrategy,
//						startObserver
//				)
//		);
//	}
}