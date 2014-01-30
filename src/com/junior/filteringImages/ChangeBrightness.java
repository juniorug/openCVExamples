package com.junior.filteringImages;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui; 
import org.opencv.imgproc.Imgproc;

import View.LoadImage;

public class ChangeBrightness {

	private static double INCREASEBRIGHTNESS = 75;
	private static double DECREASEBRIGHTNESS = -75;
	public static void main(String[] args) 
	{ 
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );

		
		Mat origImg = Highgui.imread("img/Jellyfish.jpg", Highgui.CV_LOAD_IMAGE_COLOR);
		if (origImg.empty()) //check whether the image is loaded or not
	    {
	         System.out.println("Error : Image cannot be loaded..!!");
	    }
		else {
			System.out.println("Success : Image loaded successfully..!!");
			
			new LoadImage("img/Jellyfish.jpg",origImg);
			
			Mat destImg = origImg;
			destImg.convertTo(origImg, -1, 1, INCREASEBRIGHTNESS);
			new LoadImage("img/JellyfishHighBrightness.jpg",destImg);
			
			destImg.convertTo(origImg, -1, 1, DECREASEBRIGHTNESS);
			new LoadImage("img/JellyfishLowBrightness.jpg",destImg);
			
			
		}
		 
	}

}
