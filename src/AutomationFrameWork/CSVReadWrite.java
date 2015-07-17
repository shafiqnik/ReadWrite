package AutomationFrameWork;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class CSVReadWrite {
	//CSVReader reader = new CSVReader(new FileREader("test.csv"));
	
	private static String path = "c:/Temp/asdf.txt";
	
	public static void CSVReadWrite() throws IOException{
		OpenFile();
	}
	
	public static void  ReadFile(String mypath){
		path = mypath;
		
	}

	public static String[] OpenFile() throws IOException{
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		
	
		int numberOfLines = 1;
		String[] textData = new String[numberOfLines ];
		
		for(int i = 0; i<numberOfLines; i++){
			textData[i] =textReader.readLine();
		}
		textReader.close();
		return textData;
	}
}

