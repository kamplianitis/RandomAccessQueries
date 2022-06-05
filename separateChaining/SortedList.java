package separateChain;

public class SortedList {
	  private Link first;
	  public SortedList() {
	    first = null;
	  }

	  public void insert(Link theLink){
	    int key = theLink.getKey();
	    Link previous = null; // start at first
	    Link current = first;
	    // until end of list,
	        //or current bigger than key,
	    while (current != null && key > current.getKey()) { 
	      previous = current;
	      current = current.next; // go to next item
	    }
	    if (previous == null) // if beginning of list,
	      first = theLink; 
	    else
	      // not at beginning,
	      previous.next = theLink; 
	    theLink.next = current; 
	  }
	  public static int avg;
	  
	  public Link find(int key) {
	    Link current = first; 
	    while (current != null && current.getKey() <= key) {// or key too small,
	      avg++;
	      if (current.getKey() == key) // found, return link
	        return current;  
	      current = current.next; // go to next item
	    }
	    return null; // cannot find it
	  }

	  public void displayList() {
	    System.out.print("List: ");
	    Link current = first;
	    while (current != null){
	      current.displayLink(); 
	      current = current.next;
	    }
	    System.out.println("");
	  }

	public static int getAvg() {
		return avg;
	}

	public static void setAvg() {
		SortedList.avg = 1;
	}
	  
}
