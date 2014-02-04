package com.junior.opencv;


import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

import View.LoadImage;

public class LoadImageFromFile
{
	public static void main( String[] args )
    {
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
      
		Mat m=Highgui.imread("img/Jellyfish.jpg",Highgui.CV_LOAD_IMAGE_COLOR);
		new LoadImage("img/Jellyfish.jpg",m);
		
		System.out.println("image height: " + m.height());
		System.out.println("image width: " + m.width());
		m=Highgui.imread("img/Jellyfish.jpg",Highgui.CV_LOAD_IMAGE_GRAYSCALE);
		new LoadImage("img/JellyfishGray.jpg",m);
    }
}