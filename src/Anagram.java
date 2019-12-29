
public class Anagram {
	
	private String word;
	private Anagram next;
	
	public Anagram(String word) {
		this.setWord(word);
		setNext(null);
		//good practice to make pointer point to null when creating the 
		//first linked list node
	}
	
	public String sortLetters() {
		char [] charArray = word.toCharArray();
		sortCharArray(charArray);
		return charToString(charArray);
	}
	
	private void sortCharArray(char [] charArray) {
		boolean swapCalled;
		int listToTraverse = charArray.length - 1;
		do {
			swapCalled = false;
			for(int j = 0; j < listToTraverse; j++) {
				if(charArray[j]>charArray[j+1]) {
					char temp = charArray[j];
					charArray[j] = charArray[j+1];
					charArray[j+1] = temp;
					swapCalled = true;
				}
			}
			listToTraverse--;
		}while(swapCalled == true);
	}
	
	private String charToString(char [] charArray) {
		String sortedString = "";
		for(int i = 0;i<charArray.length;i++) {
			sortedString += charArray[i];
		}
		return sortedString;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Anagram getNext() {
		return next;
	}

	public void setNext(Anagram next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return getWord();
	}
	

}
