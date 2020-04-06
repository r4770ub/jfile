package dev.utility.jfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class JFileRoot
{
	
	private String rootObject; 
	private File root; 
	private List<String> files; 
	private List<String> directories; 
	
    JFileRoot(String inputDirectory ) 
	{
		this.rootObject = inputDirectory; 
		root = new File(inputDirectory);
		files = new ArrayList<String>();
		directories = new ArrayList<String>();

	}
	
	public void process() throws FileNotFoundException
	{
		System.out.println("JFileRoot"); 
		System.out.println("Analysing: " + root.getAbsolutePath());
		search(root);
		System.out.println("Number of directories: " +directories.size());
		System.out.println("Number of files: " +  files.size());
	}
	
	public void search(File file) throws FileNotFoundException
	{
		if(file.isDirectory())
		{
		   directories.add(file.getAbsolutePath()); 
		   File[] files = file.listFiles(); 
		   for(File actualFile: files)
		   {
			   search(actualFile); 
		   }
		}
		else if( file.isFile())
		{
			files.add(file.getAbsolutePath()); 
		}
		else
		{
			System.err.println("JFileRoot Error: Input is not a valid directory  or file in OS System"); 
			System.exit(1);
		}
	}
	
   
	public String getRootDirectory() {
		return rootObject;
	}



	public List<String> getDirectories() {
		return directories;
	}

	public List<String> getFiles() {
		return files;
	}
	
}
