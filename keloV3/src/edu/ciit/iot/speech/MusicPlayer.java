package edu.ciit.iot.speech;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicPlayer {
	 public static void mp3Player(String filename) throws JavaLayerException {
		//声明一个File对象
		 File file=new File(filename);
		 try {
			//创建一个输入流
			FileInputStream stream=new FileInputStream(file);
			//创建一个缓冲流
			BufferedInputStream bufferedInputStream = new BufferedInputStream(stream);
			//创建播放器对象，把文件的缓冲流传入进去
			Player player=new Player(bufferedInputStream);
			//调用播放方法进行播放
			player.play();
			//player.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
}
