package com.xiaoshabao.example.module.base.模式设计.适配器模式;

/**
 * 实现Vlc媒体播放器
 */
public class VlcPlayer implements AdvancedMediaPlayer {
	@Override
	public void playVlc(String fileName) {
		System.out.println("Playing vlc file. Name: " + fileName);
	}

	@Override
	public void playMp4(String fileName) {
		// 什么也不做
	}
}
