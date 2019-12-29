import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
public class FileManager {
	private Scanner fileOpen;
	
	public void loadTextFile(MyArrayList arr, String fileName) {
		
		try {
			fileOpen = new Scanner(new File(fileName));
			fileOpen.useDelimiter("\r\n");
			while(fileOpen.hasNext()) {
				arr.add(new Anagram(fileOpen.next()));
			}
		}catch(FileNotFoundException e) {
			System.out.println("Error in loading the file!");
		}
	}
	
	public void writeToFile(String whatToWrite, String newFileName) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(newFileName+".txt"));
			writer.write(whatToWrite);
			writer.close();
		}catch (Exception e) {
			System.out.println("Could not write to file.");
		}
	}
	
}
