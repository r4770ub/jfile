package dev.utility.jfile;

import java.io.File;
import java.text.DecimalFormat;

public class JFile extends File
{

	public static String TYPE_IMAGE  ="IMAGE"; 
	public static String TYPE_AUDIO = "AUDIO"; 
	public static String TYPE_VIDEO = "VIDEO";
	public static String TYPE_BINARY = "BINARY";
	public static String TYPE_WORD = "WORD";
	public static String TYPE_EXCEL = "EXCEL";
	public static String TYPE_POWERPOINT= "POWERPOINT";
	
 
	
	static final long serialVersionUID = -619618735055302633L;
	private String fileName; 
	private String absolutePath; 
	private String fileExtension; 
	private String filePath; 
	private float  bSize;
	private float  kbSize; 
	private float  mbSize; 
	private float  gbSize; 
	private String fileType; 
	boolean isDirectory; 
	boolean isFile; 
	


	public JFile(String pathName) {
		super(pathName);
		initialize(this.getParentFile());
		
		

		
	}


	public JFile(File file) {
		super(file.getAbsolutePath());
		initialize(this.getParentFile());

		
	}
	
	public String fileInformation() 
	{
		
		 DecimalFormat df = new DecimalFormat("#.##");
		String information= ""; 
		information = information + ("=====================================================") +"\n";
		information = information + ("AbsolutePath: 	" + this.absolutePath +"\n");  
		information = information + ("FilePath: 	" + this.filePath +"\n");           
		information = information + ("Filename: 	" + this.fileName +"\n");   
		information = information + ("File Ext 	" + this.fileExtension +"\n");           

		information = information + ("FileType: 	" + this.fileType +"\n");           
		information = information + ("Is Dir?: 	" + this.isDirectory +"\n");           
		information = information + ("Is File?: 	" + this.isFile +"\n");           

		information = information + ("Size Byte: 	" +     df.format(this.bSize) +"\n");  
		information = information + ("Size KiloByte 	" +  df.format(this.kbSize) +"\n");  
		information = information + ("Size MegaByte: 	" +  df.format(this.mbSize) +"\n");  
		information = information + ("Size GigaByte: 	" +  df.format(this.gbSize) +"\n");  

		information = information + ("=====================================================") +"\n";


		return information; 
	}
	
	private void initialize(File file)
	{
		this.fileName = getName();
		this.absolutePath = getAbsolutePath(); 
		this.filePath = absolutePath.substring(0, absolutePath.lastIndexOf('/')+1);
		this.fileExtension = this.fileName.substring(this.fileName.lastIndexOf('.') +1 ,this.fileName.length());
		parseType();
		if(file.isDirectory())
		{
			isDirectory = true; 
			isFile = false; 
		}
		else
		{
			isDirectory = false; 
			isFile = false; 
		}
		this.bSize = this.length();
		this.kbSize = (bSize/1000); 
		this.mbSize =  (kbSize/1048);
		this.gbSize = (mbSize/1000);
	}

	public String getFormattedFileSize()
	{
		
		if(gbSize > 1)
			return gbSize + " gb";
		else if(mbSize > 1 )
			return mbSize + " mb";
		else if(kbSize > 1)
			return kbSize + " kb";
		else
			return  bSize + "bytes";
	
		
	}

	public void parseType()
	{
		if(this.fileExtension.equalsIgnoreCase("png") || this.fileExtension.equalsIgnoreCase("jpg") ||this.fileExtension.equalsIgnoreCase("jpeg") || this.fileExtension.equalsIgnoreCase("tiff ") || this.fileExtension.equalsIgnoreCase("bmp") || this.fileExtension.equalsIgnoreCase("gif"))
		{
			this.fileType = TYPE_IMAGE;
		}
		
	}
	public JFile copyJFile(JFile jFile)
	{
		JFile copy; 
		copy = new JFile(jFile); 
		return copy; 
	}



}
