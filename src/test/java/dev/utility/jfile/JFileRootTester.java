package dev.utility.jfile;

import java.io.FileNotFoundException;
import dev.utility.jfile.*;


import dev.utility.jbase.constants.JConstants;

public class JFileRootTester {
	
	public static void main(String [] args) throws FileNotFoundException
	{
		JFileRoot filegrabber  =  JFileTools.getJFileRoot("/home/r4770/dev/");
		filegrabber.process();
		filegrabber.getDirectories();
	}

}
