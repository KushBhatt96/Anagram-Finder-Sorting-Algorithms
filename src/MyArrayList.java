
public class MyArrayList {
	
	private AnagramLinkedList [] simpleArray;
	
	public MyArrayList() {
		simpleArray = new AnagramLinkedList [0];
	}
	
	public void add(Anagram a) {
		//recall that we cannot change the size of a simple array and hence will need to recreate an array
		//and copy over the existing elements
		
		if(simpleArray.length <= 0) {
			//If the array of LinkedLists has 0 elements we must add a new Linked List and insert the Anagram to that LL
			AnagramLinkedList [] addToArray = new AnagramLinkedList[1];
			addToArray[0] = new AnagramLinkedList();
			simpleArray = addToArray;
			simpleArray[0].insertToEnd(a);
		}
		else {
			//if the array of LinkedLists has 1 or more elements, we must check if the Word within the passed Anagram object is
			// indeed an anagram of any of the words in the head of the existing LLs --> if not create a new array of size +1 and
			//add a new array element for a new LL
			boolean anagramFound = false;
			for(int i = 0;i<simpleArray.length;i++) {
				//System.out.println(a.getWord());
				//System.out.println("LENGTH OF ARRAY: " + simpleArray.length);
				//System.out.println("i: " + i);
				//System.out.println(simpleArray[i].getHead() == null);
				//System.out.println("YO");
				if(simpleArray[i].getHead().sortLetters().equals(a.sortLetters())) {
					simpleArray[i].insertToEnd(a);
					anagramFound = true;
				}
			}
			//if none of the words in the existing LL heads were anagrams of this new anagram object, simply add to the
			//array
			if(anagramFound == false) {
				AnagramLinkedList [] addToArray = new AnagramLinkedList[simpleArray.length+1];
				for(int i = 0;i<simpleArray.length;i++) {
					addToArray[i] = simpleArray[i];
					//System.out.println("IN LOWER: " + addToArray[i].getHead().getWord());
				}
				addToArray[simpleArray.length] = new AnagramLinkedList(); 
				addToArray[simpleArray.length].insertToEnd(a);
				simpleArray = addToArray;
			}
		}
	}
	
	
	public void quickSortWrapper() {
		quickSort(simpleArray, 0, simpleArray.length-1);
	}
	
	private void quickSort(AnagramLinkedList [] arr, int first, int last) {
		if(first<last) {
			int pPosition = partitioningQS(arr, first, last);
			quickSort(arr, first, pPosition-1);
			quickSort(arr, pPosition+1, last);
		}
	}
	
	private int partitioningQS(AnagramLinkedList [] arr, int first, int last) {
		String pivot = arr[first].getHead().getWord();
		int lower = first+1, higher = last;
		
		while(lower<=higher) {
			while(lower<arr.length && arr[lower].getHead().getWord().compareTo(pivot) <= 0) {
				lower++;
			}
			while(arr[higher].getHead().getWord().compareTo(pivot)>0) {
				higher--;
			}
			if(lower<higher) {
				AnagramLinkedList temp = arr[lower];
				arr[lower] = arr[higher];
				arr[higher] = temp;
			}
		}
		AnagramLinkedList temp = arr[first];
		arr[first] = arr[higher];
		arr[higher] = temp;
		return higher;
	}
	
	
	
	public String printArray() {
		String anagramString = "";
		for(int i = 0;i<simpleArray.length;i++) {
			anagramString += simpleArray[i].recursivePrint();
		}
		return anagramString;
	}
	
	public void sortLinkedLists() {
		for(int i = 0;i<simpleArray.length;i++) {
			simpleArray[i].insertionSortLL();
		}
	}

}
