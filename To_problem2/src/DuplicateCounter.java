import java.util.Scanner;
import java.util.HashMap;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class DuplicateCounter {
	
	HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();


	 void count(String dataFile) {
		 
			try {
				Scanner fileInput = new Scanner(new File(dataFile));
				while(fileInput.hasNext()) {
					String word = fileInput.next().toLowerCase();
					
					Integer counter = wordCounter.get(word);
					
					if (counter == null) {
						counter = 1;
					}
					else
						counter += 1;
					
					wordCounter.put(word, counter);
				}
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		 
	 }
	 
	 void write(String outputFile) {
		 try {
			FileWriter fileOutput = new FileWriter(outputFile);
			 
			 for(String submit : wordCounter.keySet())
			 	fileOutput.write(submit + "\t" + wordCounter.get(submit) + "\r\n");
			 
			 fileOutput.close();
		 } catch (IOException e) {
				e.printStackTrace();
			}	 
			 
	 }
		 
		 
		 
}
	

