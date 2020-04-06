package dev.utility.jfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JFileSorter {

	public static final int NO_SORT = 1;
	public static final int SORT_FILES_ALPHANUMERIC = 2;
	public static final int SORT_FILES_BYSIZE = 3;
	private File directory;

	private List rawFiles;
 

	public JFileSorter(String directoryName, int OPTION)  {
		directory = new File(directoryName);
		rawFiles = new ArrayList<String>();

		checkDirectory();

		if (OPTION == SORT_FILES_BYSIZE) {
			noSort();
			sortByFileSize();
		} else if (OPTION == SORT_FILES_ALPHANUMERIC) {
			noSort();
			sortAlphaNumericFiles();
		} else if (OPTION == NO_SORT) {
			noSort();
		} else {
			System.err.println("\tInvalid user Option in JFileSorter"); 
			System.exit(1);
		}
	}

	private void noSort() {
		
		File [] files = directory.listFiles(); 
		for(File file : files) 
		{
			rawFiles.add(file.getAbsolutePath());
		}

	}

	
	private void sortByFileSize() {
		
		System.out.println("\t Sorting Files by Size ");
		Collections.sort(rawFiles, new Comparator<File>() {

			public int compare(File file1, File file2) {
				Long file1Length = file1.length();
				Long file2Length = file2.length();
				return file1Length.compareTo(file2Length);
			}

		});

	}

	public void sortAlphaNumericFiles() 
	{
		System.out.println("\tSort Files  Alpha Numerically");
		try 
		{

			Collections.sort(rawFiles, new Comparator<String>() {
				public int compare(String o1, String o2) {

					String o1StringPart = o1.replaceAll("\\d", "");
					String o2StringPart = o2.replaceAll("\\d", "");

					if (o1StringPart.equalsIgnoreCase(o2StringPart)) {
						return extractInt(o1) - extractInt(o2);
					}
					return o1.compareTo(o2);
				}

				int extractInt(String s) {
					String num = s.replaceAll("\\D", "");
					// return 0 if no digits found
					return num.isEmpty() ? 0 : Integer.parseInt(num);
				}
			});
		} catch (Exception e) 
		{
			System.err.println("Error in sorting alphanumeric sorting");
			e.printStackTrace();
			noSort();
		}

	}

	private void checkDirectory() 
	{
		System.out.println(" JFileSorter ----> Checking valdity of file structure");
		System.out.println("\tAbsolute Path: " + directory.getAbsolutePath());

		if (!directory.exists()) 
		{
			System.err.println("\tJFileSorter Error ---> Directory does not exsist: " + directory.getAbsolutePath());
			System.exit(1);
		}

		File[] temp = directory.listFiles();
		System.out.println("\t Total Files found: " + temp.length);
	
		if(temp.length <= 0)
		{
			System.err.println(" \tJFileSorter Error ---> Directory contains no files"); 
			System.exit(1);
		}
		else
		{
			System.out.println(" \tJFileSorter Message ---> Total Files in directory: " + temp.length);
		}

	}

	public String[] getFileNames() 
	{
		String [] fileNames = new String[rawFiles.size()]; 
		for(int i = 0 ; i < rawFiles.size() ; i++)
		{
			System.out.println("\t File " + i + ": " + rawFiles.get(i));
			fileNames[i] = (String) rawFiles.get(i);
		}
		
		return fileNames; 
	}
	
	public File[] getFiles() 
	{
		File [] files = new File[rawFiles.size()]; 
		for(int i = 0 ; i < rawFiles.size() ; i++)
		{
			System.out.println("\t File " + i + ": " + rawFiles.get(i));
			files[i] = (File) rawFiles.get(i);
		}
		return files;
	}
	
}
