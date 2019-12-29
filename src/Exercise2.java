import java.util.Scanner;
public class Exercise2 {
	//This will be the main class
	public static void main(String [] args) {
		MyArrayList arr = new MyArrayList();
		FileManager theFileManager = new FileManager();
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter the name of the text file.");
		String fileName = userInput.next()+".txt";  
		theFileManager.loadTextFile(arr, fileName);

		
		double startTime = System.nanoTime();   //Start timer
		
		arr.sortLinkedLists();     //Insertion Sort on the LinkedLists
		arr.quickSortWrapper();    //Quick sort on the array of references
		
		double endTime   = System.nanoTime();                //Stop timer
		double totalTime = (endTime - startTime)/1000000000.0;             //find the duration
		System.out.println("\n\nTime to sort: " + totalTime + " seconds");
		
		
		System.out.println("\n\nAFTER SORTING: ");
		theFileManager.writeToFile(arr.printArray(), "anagrams");      
	}
}
