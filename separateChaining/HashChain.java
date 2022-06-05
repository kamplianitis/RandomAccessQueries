package separateChain;

public class HashChain {
	  private SortedList[] hashArray; 

	  private int arraySize;

	  public HashChain(int size) {
	    arraySize = size;
	    hashArray = new SortedList[arraySize];
	    for (int i = 0; i < arraySize; i++)
	      hashArray[i] = new SortedList(); 
	  }

	  public void displayTable() {
	    for (int j = 0; j < arraySize; j++) {
	      System.out.print(j + ". "); 
	      hashArray[j].displayList(); 
	    }
	  }

	  public int hashFunc(int key) {
	    return key % arraySize;
	  }

	  public void insert(Link theLink) {
	    int key = theLink.getKey();
	    int hashVal = hashFunc(key); 
	    hashArray[hashVal].insert(theLink); 
	  }

	  public Link find(int key) {
	    int hashVal = hashFunc(key); // hash the key
	    Link theLink = hashArray[hashVal].find(key); // get link
	    return theLink;
	  }
}