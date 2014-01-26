package com.junior.opencv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

import View.LoadVideo;

public class CaptureVideoFromCamera {
	
	public static void main(String[] args) 
	{
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		VideoCapture vc = new VideoCapture(0);
		if(!vc.isOpened())  // if not success, exit program
	    {
	      System.out.println("Cannot open the video cam");
	    }
		
	   double dWidth = vc.get(Highgui.CV_CAP_PROP_FRAME_WIDTH); //get the width of frames of the video
	   double dHeight = vc.get(Highgui.CV_CAP_PROP_FRAME_HEIGHT); //get the height of frames of the video
		
	   System.out.println("Frame size : " + dWidth + " x " + dHeight);
	   
	   double fps = vc.get(10); //get the frames per seconds of the video
	   System.out.println("frame per seconds : " + fps);
	   
	   Mat webcamImage = new Mat();  
	   new LoadVideo(webcamImage,vc);
	   
	}

}
