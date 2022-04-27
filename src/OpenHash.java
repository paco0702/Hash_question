

public class OpenHash {
	char [] table = new char [11];
	int count =0;
	
	
	
	
	
	int getSize() {
		return count;
	}
	
    private int hash(int k) {
		return k % table.length;
		}

  public boolean insert (char k) {
  	if (isFull()) return false ;
  	
  	int index, hk, collision = 0;  // hk is the hash key, and 
  	                               // collision is storing the number of collision
  	
  	index = hk = hash(k);
  	
  	while (table [index ] != 0 && table [index ]!= (char) 127) { 
  		                          // just created the array, the element are equal to 0
  		                          // String array, all the element will be null
  		                          // null is represented to 0
  		                          // if the table [index} is not null, then this is collision
  		                          // if the table [index] is equal to zero, then there is empty room to store the element
  		
  		collision ++;
  		index = hash (hk +collision);  // go to the second box
  	} // however, what if keep looping ?? all the box is not empty
  	
  	table [index] = k;
  	count ++;
  	return true;
  }
  
  public int find(char k) {
	  int index , hk, collision = 0;
	  index = hk= hash(k);
	  System.out.println("number of hk "+hk);
	  System.out.println("number of index "+ hk);
	  while (table [index] !=0 && table[index] != k && collision < count) { 
			  // it means that when the key get through the hash function, and then 
			  // the element inside is not the element we want
			  //that means there is an collision 
			  
			  // reach the target char or empty room. then it will stop
		      // collision < count in order to stop the loop
		  
		  
		  collision ++;  
		  // collision start with  i =1
		  //                       i=2
		  //                      so on and so far until the array is empty and can store the element
		  
		  index = hash(hk + collision);                                   // if there is not the target element, and collision = count (mean we already go through the whole table
	//   index = hash(hk + collision*collision); that is (2) probing      // then we can stop the reaching 
	  }
	  
	  if(table [index ]==k) {         
		  return index;
	  }else return -1;            //return table[index] == k ? index : -1 (is the same statement
	                              // if return 1-, which mean that this is not your target element in array and the looping is stopped by collision == count;
  }
  
  
  public void delete(char k) {
	  int index = find(k);
	  if (index >= 0) {  // find might return -1 if there no element
//	  table[index] = 0;
	  // if deleting index equal to 0, the array empty
	  // some element suppose to be that index and
	  // if the box is empty, the looping will stop 
	  // e.g. B suppose is in index 2, but O occuppied 
	  // after deleted O , and then delete B
	  // the hash function for B index is equal to 2 
	  // then the find function will stop and would not search in next box
		  // so cannot find B
		  
		  
	  // change 
	  table[index] = (char) 127; // however it affect the the insertion 
	  count --;
	  }
	  }
  
  boolean isFull() {
  	if(count ==11) {
  		return true;
  	}
  	else return false;
  }
  
  public void print () {
	  for (int i=0; i<this.table.length; i++) {
		  if(table[i]==0) {
			  System.out.println(0);
		  }
		  else
		  System.out.println(table[i]);
	  }
  }
  
  public static void main(String [] args) {
	  OpenHash h = new OpenHash();
	  h.insert('1');
	  h.insert('1');
	  h.print();
	  
  }
}
