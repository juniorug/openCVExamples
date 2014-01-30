package com.junior.filteringImages;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui; 
import org.opencv.imgproc.Imgproc;

import View.LoadImage;

public class NegativeImage {


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
			//image to be generated with dilatation effect
			//Mat destImg =new Mat(origImg.rows(),origImg.cols(),origImg.type());
			Mat destImg = origImg.inv();
			
			//Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT,new Size(2*DILATATION_SIZE + 1, 2*DILATATION_SIZE+1));
	
			//Imgproc.dilate(origImg, destImg, element);
			new LoadImage("img/JellyfishDilated.jpg",destImg);
		}
	}

}
