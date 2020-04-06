package dev.utility.jfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

public class JFileTools {

	Logger log = Logger.getLogger(JFileTools.class.getName());

	public static JFileSorter getFileSorter(String inputDir, int option)  {
		return new JFileSorter(inputDir, option);
	}

	public static JFileRenamer getJFileRenamer(String inputdir, int option)  {
		return new JFileRenamer(inputdir, option);
	}

	
	public static JFileRoot getJFileRoot(String rootDirectory)  {
		return new JFileRoot(rootDirectory);
	}

	

}
