package dev.utility.jfile;

import java.io.IOException;
import dev.utility.jfile.*;


import dev.utility.jbase.constants.JConstants;

public class JFileRenamerTester {
	
	
	public static void main(String[] args) throws IOException
	{
		JFileRenamer filerenamer = JFileTools.getJFileRenamer(JConstants.INPUT_DESKTOP_DIRECTORY, JFileSorter.SORT_FILES_ALPHANUMERIC);
		filerenamer.standardize(JConstants.STEG_PARTITION);
	}

}
