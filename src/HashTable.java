

public class HashTable {
	int [] table = new int [10];      // implementing array 
	int count =0 ;             // can implement linked list
	

    private int hash(int k) {
	
	return k% table.length;   // mod 
	
    }
    
    int size() {
    	return count;
    }
    int length() {
    	return table.length;
    }
    
       public int find (int k) {
    	if(isEmpty()==true) {
    		return 0;
    	}
    	int index, hk= 0;
    	index = hk= hash (k);
    	int loop =0;
    	while(table[index]!=k  ) {
    		loop++;
    		index = hash (hk +loop);
    		if(loop ==length()) {
    			System.out.println("there is not this key");
    			return 0;
    		}
    	}
    	
    	return table[index];
    }
    
    void del(int k) {
    	if(isEmpty()==true) {
    		return;
    	}
    	int index, hk= 0;
    	index = hk= hash (k);
    	int loop =0;
    	while(table[index]!=k  ) {
    		loop++;
    		index = hash (hk +loop);
    		if(loop == length()) {
    			System.out.println("there is not this key");
    			return;
    		}
    	}
    	
       table[index] =0;
    }
    
    boolean isEmpty() {
    	if(length()==0) {
    		return true;
    	}else 
    		return false;
    }
  
    boolean isFull() {
    	if(count == table.length) {
    		return true;
    	}else return false;
    }
    
    public void insert (int k) {
    	if (isFull()==true) return ;
    	
    	int index, hk, collision = 0;
    	index = hk = hash(k);
    	
    	while (table [index ] != 0 && table[index] % length()!= 9) {
    		
    		collision ++;
    		index = hash (hk +collision);
    	}
    	
    	table[index] = k;
    	count++;
    	
    	
    }
    
    void print() {
    	for(int i=0; i<length(); i++) {
    		System.out.println(table[i]);
    	}
    }

    public static void main(String [] args) {
    	HashTable h = new HashTable();
    	System.out.println("insert element");
    	h.insert(4);
    	h.insert(14);
    	h.insert(24);
    	h.insert(34);
    	h.insert(44);
    	h.insert(54);
    	h.insert(64);
    	h.insert(74);
    	h.insert(84);
    	h.insert(94);
    	
    	System.out.println();
    	
    	h.print();
    	System.out.println();
    	System.out.println("find element 94");
    	System.out.println(h.find(94));
    	System.out.println();
    	System.out.println("delete element 94");
    	h.del(94);
    	h.print();
    	
    	System.out.println("return number of element");
    	System.out.println(h.count);
    }
}

