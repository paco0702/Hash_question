

import java.math.BigInteger;

public class OpenHash2 {
	char [] table = new char [11];
	int count =0;
	 int r = 7;
	
	
	private int hash(int k) {
		return k % table.length;
	}
	
	private int hash2(int k, int r) {         // r is another prime number 
		return r - (k%r);
	}
	
	public boolean insert (char k) {
		if(isFull ()) return false;
		int index , hk , collision = 0;
		
		index = hk= hash(k);
		int h2k = hash2(k, r); // the r? 
		
		while (table [index] != 0) {
			collision ++;
			index = hash(hk +collision *h2k);
		}
		
		table [index] =k;
		count ++;
		return true;
	}
	
	public boolean isFull() {
		if(count == table.length) {
			return true;
		}else return false;
	}
	
	public int find(char k) {
		int index, hk, collision = 0;
		index = hk = hash(k);
		int h2k = hash2(k, r); // the r
		while(
		table[index] != 0
		&& table[index] != k
		&& collision < count
		) {
		collision ++;
		index = hash(hk + collision * h2k);
		}
		return table[index] == k ? index :
		-1;
		}

	
	public void delete(char k) {
		int index = find(k); 
		if (index >= 0) {  // because the find function might return -1, 
		table[index] = 0;
		// should equal to 0;
		count --;
		}
		}
	
	//rehashing
	//Next prime
	
	private int nextPrime(int p) {       // after doubling the size of array
		//create an object big integer 
		// get the prime
		BigInteger bi = new BigInteger(String.valueOf(p));
		                             // however it is required to provide a String 
		                             // or can use ("" + p (p is number of size to convert integer to String 
		return bi.nextProbablePrime().intValue();  // intValue convert string to integer 
		
		}
	
	// after rehashing (having the new size 
	// rebuild the table 
	
	public void rehashing() {
		
		char[] oldTable = table;
		                 // nextPrime function getting the new prime number 
		table = new char[nextPrime(oldTable.length * 2)]; // create new char array
		
		count = 0;
		for(int i=0; i<oldTable.length; i++)
		if (oldTable[i] > 0 ||  oldTable[i ] != 127)  // if old table is empty, no element need to copy 
			
		insert(oldTable[i]);    // cannot the directly copy the value into the same index
		 // do the recalculate 
		// do hash function with new table and new table size and new prime number 
		}
}
