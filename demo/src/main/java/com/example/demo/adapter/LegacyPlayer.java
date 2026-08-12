package com.example.demo.adapter;

public class LegacyPlayer {

	// example of a method which is not compatible with our MediaPlayer interface
	// our api expects play((String path)
	public void startPlayback(String path){
		System.out.println("playing legacy " + path);
	}
}
