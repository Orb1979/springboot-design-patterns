package com.example.demo.adapter;

public class MediaAdapter implements MediaPlayer {
	private LegacyPlayer legacyPlayer;

	public MediaAdapter(LegacyPlayer legacyPlayer) {
		this.legacyPlayer = legacyPlayer;
	}

	public void play(String path){
		legacyPlayer.startPlayback(path);
	}
}
