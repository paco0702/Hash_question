

import java.util.LinkedList;

public class LinkedlistHash { // use linked list to handle collision
	LinkedList [] table = new LinkedList[11];
	int count;
	
	public LinkedlistHash() {
		for (int i=0; i<table.length; i++) {
			table [i] = new LinkedList();
		}
		
	}
	
	private int hash (int k) {
		return k% table.length;
	}
	public void insert(char k) {
		LinkedList l = table [hash(k)];
		l.add(k);
	}
	
	public void find (char k) {
		int index = hash(k);
		LinkedList l = table [index];
		
		if(l.contains(k)) {
			//show exist 
		}else {
			// show not exist 
		}
	}
	
	
	// however you may add the element in the same linked list
	// , the time complexity is O(n)
	
	//  if you can distributing the element into different linkedlist
	// then the time complexity close to O(1)
}
