package AutomationFrameWork;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;

public class ReadFile {
	
	private String path = null;
	
	public ReadFile(String file_path){
		path = file_path;
	}
	
	/**
	 * Opens the txt file which is located at "ie. c:/Temp/dummy.txt"
	 * 
	 * @return
	 * @throws IOException
	 */
	
	public String[] OpenFile() throws IOException{
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		
		int numberOfLines = 3;
		String[] textData = new String[numberOfLines];
		
		for (int i=0; i<numberOfLines; i++){
			textData[i] = textReader.readLine();
			
		}
		
		textReader.close();
		return textData;
		
	}
	
	/**
	 * Reads lines of the the simple text file
	 * Path is where the txt file is located.
	 * Returns number of lines in the file as integer value
	 * @return
	 * @throws IOException
	 */
	
	int readLines() throws IOException{
		FileReader file_to_read = new FileReader(path);
		BufferedReader bf = new BufferedReader(file_to_read);
		
		String aLine;
		int numberOfLines = 0;
		
		while ((aLine = bf.readLine()) != null){
			numberOfLines++;
			//System.out.println("readLines  "+aLine);
		}
		bf.close();
		return numberOfLines;
		
	}
	
	
	/**
	 * Reads the txt file and returns content of the txt file as Array
	 * 
	 * @return
	 * @throws IOException
	 */
	ArrayList myRead() throws IOException{
		FileReader file_to_read = new FileReader(path);
		BufferedReader bf = new BufferedReader(file_to_read);
		
		ArrayList al = new ArrayList();
		
		String aLine;
		//String[] lines = null;
		int numberOfLines = 0;
		
		while ((aLine = bf.readLine()) != null){
			numberOfLines++;
			//System.out.println("readLines string  "+aLine);
			al.add(aLine);
		}
		bf.close();
		return al;
		
	}
	
	/**
	 * Write file module
	 */
	 

}
