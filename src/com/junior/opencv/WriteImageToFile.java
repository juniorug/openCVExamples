package com.junior.opencv;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;

import View.LoadImage;


public class WriteImageToFile {

	public static void main(String[] args) 
	{ 
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		
		//create an image ( 3 channels, 16 bit image depth, 650 high, 600 wide, (0, 50000, 50000) assigned for Blue, Green and Red plane respectively. )
		Scalar scalar = new Scalar(0,50000, 50000);
		Mat img = new Mat(650, 600, CvType.CV_16UC3, scalar);
		
		if (img.empty()) //check whether the image is loaded or not
	    {
	         System.out.println("Error : Image cannot be loaded..!!");
	    }
		//specify the compression technique
		MatOfInt compression_params = new MatOfInt(Highgui.CV_IMWRITE_JPEG_QUALITY); //vector that stores the compression parameters of the image


		//specify the compression quality
		long comp_quality = 98;
		//compression_params(comp_quality);

		boolean bSuccess = Highgui.imwrite("img/imageToFile.jpg", img, compression_params); //write the image to file
		if ( !bSuccess )
		{
			System.out.println("ERROR : Failed to save the image");
		} else
		{
			System.out.println("Success : Image loaded successfully..!!");
			new LoadImage("img/imageToFile.jpg",img);
		}
		
		
		
	}
}