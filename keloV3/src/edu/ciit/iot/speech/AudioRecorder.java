package edu.ciit.iot.speech;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class AudioRecorder extends Thread {

	private static TargetDataLine mic;
    private String audioName;

    public AudioRecorder(String audioName) {
         this.audioName = audioName;
    }

    @Override
    public  void run() {
        initRecording();
        statRecording();
    }

    private void initRecording() {

        System.out.println("开始录音.....");

        try {
            //define audio format
        	//编码格式，采样率，每个样本的位数，声道，帧长（字节），帧数，是否按big-endian字节顺序存储
            AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 16000, 16, 1, 2, 160000, false);

            DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
            // 获取音频输入设备
            mic = (TargetDataLine) AudioSystem.getLine(info);
            mic.open();

            System.out.println("录音中......");
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        }

    }

    private void statRecording() {
        try {
        	// 当开始音频捕获或回放时，生成 START 事件
        	mic.start();
            // 构造从指示的目标数据行读取数据的音频输入流
            AudioInputStream audioInputStream = new AudioInputStream(mic);
            File f = new File(audioName);
            
            AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, f);
            System.out.println("录音文件存储.....");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

       public void stopRecording() {
        mic.stop();
        mic.close();
        System.out.println("录音结束....");
    }
}
