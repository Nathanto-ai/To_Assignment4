import java.util.Scanner;
import java.util.LinkedHashSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class DuplicateRemover {
	
	LinkedHashSet<String> uniqueWords = new LinkedHashSet<String>();


//	Method to eliminate duplicate words
	void remove (String dataFile) {
		int i;		
		

		try {
//			Hash set to store strings
						
//			Scanner reads objects from file
			Scanner fileInput = new Scanner(new File(dataFile));
			
//			reads line from file
			while(fileInput.hasNextLine()) {
				String row = fileInput.nextLine();
				
//				splits words by the space
				String[] word = row.split(" ");
				
				for(i = 0; i < word.length; i++) {
					
//					convert words to lower case
					String wordSet = word[i].toLowerCase();
//					adds words to set
					uniqueWords.add(wordSet);
				}	
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
//	method writing unique words to output file
	void write(String outputFile) {
		
		try {
			FileWriter fileOutput = new FileWriter(outputFile);
			
//		Write each word to output file
		for(String submit : uniqueWords) {
					fileOutput.write(submit + "\r\n");
			}
		
		fileOutput.close();

		
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
