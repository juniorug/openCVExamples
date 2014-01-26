package com.junior.opencv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;

import View.LoadVideo;

public class CaptureVideoFromFile {
	public static int CV_CAP_PROP_FPS = 5; //CV_CAP_PROP_FPS isn't implemented yet...
	public static void main(String[] args) 
	{
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		VideoCapture vc = new VideoCapture("videos/jeni.avi");
		vc.open("videos/jeni.avi");
		if(!vc.isOpened())  // if not success, exit program
	    {
	      System.out.println("Cannot open the video file");
	    } else {
			System.out.println("Success : Video opened successfully..!!");
		}
		
	    double fps = vc.get(CV_CAP_PROP_FPS); //get the frames per seconds of the video
	    System.out.println("frame per seconds : " + fps);
		
		Mat webcamImage = new Mat();  
		new LoadVideo(webcamImage,vc);	
	}

}
