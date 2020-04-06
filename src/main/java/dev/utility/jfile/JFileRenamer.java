package dev.utility.jfile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class JFileRenamer {
	
	public static final int NO_SORT = 1;
	public static final int SORT_FILES_ALPHANUMERIC = 2;
	public static final int SORT_FILES_BYSIZE = 3;

	private static Logger log = Logger.getLogger(JFileRenamer.class.getName());

	private String directoryName;
	private List<File> files;
	private List<String> fileNames;

	private int sort_option;
	

	 JFileRenamer(String directoryName, int sort_option)  
	 {
		 this.sort_option =sort_option;
		this.directoryName = directoryName;
		this.sort_option = sort_option; 
		
		
	}

	public void standardize(String prefix) throws IOException {
		log.info("Sanatizing directory: " + directoryName + " with prefix: " + prefix);
 
		
		JFileSorter sorter = new JFileSorter(directoryName, JFileSorter.SORT_FILES_ALPHANUMERIC);
		String[] files = sorter.getFileNames();
		for(String file: files)
			System.out.println(file);
		
		int counter = 0;
		for (String fileName : files) 
		{

			File file = new File(fileName);
			counter++;

			String extension = "";
			int i = fileName.lastIndexOf('.');
			if (i > 0)
				extension = fileName.substring(i);

			String newFilename = prefix + counter + extension;

			File currentFile = new File(fileName);
			File newFile = new File(directoryName + newFilename);
			rename(currentFile, newFile);
		}
		log.info("Sanatize directory is complete\n\n\n");

	}
	
	public boolean rename(File oldName, File newName)
	{
		boolean rename = false; 
		
		log.info("Attempting to rename File:  " + oldName + " to " + newName);

		if (oldName.exists()) 
		{
			boolean success = oldName.renameTo(newName);
			if (success) 
			{
				rename = true; 
			  log.info("success");

			} else {
				log.severe("Could not rename the file. Exiting....");
				System.exit(1);

			}

		} else {
			log.severe(oldName + "is no longer present");
			System.exit(1);
		}
		
		return rename;
	}

	public List<File> getFiles() {
		return files;
	}

	public List<String> getFileNames() {
		return fileNames;
	}

}
