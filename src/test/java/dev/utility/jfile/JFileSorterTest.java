package dev.utility.jfile;

import dev.utility.jbase.constants.JConstants;
import dev.utility.jfile.*;
public class JFileSorterTest {


	public static void main(String[] args) {
		
		JFileSorter fileSorter = JFileTools.getFileSorter(JConstants.INPUT_IMAGE_DIRECTORY, JFileSorter.NO_SORT);
		String[] files = fileSorter.getFileNames();
		for(String file: files)
		{
			System.out.println("File Name: " + file);
		}

	}

}
