package com.junior.opencv;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import View.LoadImage;

public class BlankImage {
	
	public static void main(String[] args) 
	{ 
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		Mat img = new Mat(500, 1000, CvType.CV_8UC3, new Scalar(0,0, 100));
		if (img.empty()) //check whether the image is loaded or not
	    {
	         System.out.println("Error : Image cannot be loaded..!!");
	    }
		else {
			System.out.println("Success : Image loaded successfully..!!");
			new LoadImage("img/new.jpg",img);
		}
		 
	}
	
}
