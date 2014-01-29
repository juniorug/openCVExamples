package com.junior.filteringImages;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui; 
import org.opencv.imgproc.Imgproc;

import View.LoadImage;

public class BlurringImage {
	
	private static int BLUR_SIZE = 5;
	
	public static void main(String[] args) {

		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );

		
		Mat origImg = Highgui.imread("img/Jellyfish.jpg", Highgui.CV_LOAD_IMAGE_COLOR);
		//image to be generated with blur effect
		Mat destImg =new Mat(origImg.rows(),origImg.cols(),origImg.type());
		destImg = origImg;

		Imgproc.blur(origImg, destImg, new Size(2*BLUR_SIZE + 1, 2*BLUR_SIZE+1));
		new LoadImage("img/JellyfishBlur.jpg",destImg);

	}

}
