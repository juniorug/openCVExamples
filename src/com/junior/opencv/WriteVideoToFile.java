package com.junior.opencv;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

import View.LoadVideo;
//import org.opencv.highgui.VideoWriter;
public class WriteVideoToFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		
		VideoCapture vc = new VideoCapture(0);
		if(!vc.isOpened())  // if not success, exit program
	    {
	      System.out.println("Cannot open the video cam");
	    }
		
		
		Mat webcamImage = new Mat();  
		new LoadVideo(webcamImage,vc);
		
		double dWidth = vc.get(Highgui.CV_CAP_PROP_FRAME_WIDTH); //get the width of frames of the video
	    double dHeight = vc.get(Highgui.CV_CAP_PROP_FRAME_HEIGHT); //get the height of frames of the video
	    
	    System.out.println("Frame size : " + dWidth + " x " + dHeight);
	    
	    
	    Size frameSize = new Size(dWidth,dHeight);
	    //initialize the VideoWriter object 
	    //VideoWriter vw = new  VideoWriter("D:/MyVideo.avi", CV_FOURCC('P','I','M','1'), 20, frameSize, true); 
	    
	    
	}

}
