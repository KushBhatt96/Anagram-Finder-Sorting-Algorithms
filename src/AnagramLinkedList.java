
public class AnagramLinkedList {
	
	private Anagram head;
	
	public AnagramLinkedList() {
		head = null;
	}
	
	
	
	public void insertToEnd(Anagram a) {
		if(head == null) {
			head = a;
		}
		else {
			Anagram j = head;
			while(j.getNext() != null) {
				j = j.getNext();
			}
			j.setNext(a);
		}
	}
	
	//Sort LL via insertion sort
	public void insertionSortLL() {
		Anagram j = head;
		while(j != null && j.getNext()!=null) {
			Anagram temp = j.getNext();
			if(j.getWord().compareTo(temp.getWord())>0) {
				j.setNext(temp.getNext());
				head = findAndInsert(head, temp);
			}
			else {
				j = j.getNext();
			}
		}
	}
	
	public Anagram findAndInsert(Anagram head, Anagram temp) {
		Anagram j = head;
		Anagram prev = null;
		while(j != null) {
			if(j.getWord().compareTo(temp.getWord())>0) {
				temp.setNext(j);
				if(prev == null) {
					head = temp;
				}
				else {
					prev.setNext(temp);
				}
				break;
			}
			prev = j;
			j = j.getNext();
		}
		return head;
	}
	
	
	
	public String recursivePrint() {
		return recursivePrint(head);
	}
	
	public String recursivePrint(Anagram cursor) {
		String oneLine = "";
		while(cursor!=null) {
			oneLine += cursor.toString() + " ";
			System.out.print(cursor.toString() + " ");
			cursor = cursor.getNext();
		}
		oneLine += "\n";
		System.out.println("");
		return oneLine;
	}
	
	
	

	public Anagram getHead() {
		return head;
	}
	
}
