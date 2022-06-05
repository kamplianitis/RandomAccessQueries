package separateChain;

import java.io.IOException;
import java.util.Random;

public class SepMain {

	public static void main(String[] args) throws IOException
	{
	    int size, initSize;
	    size = 1000;
	    initSize = 100000;
	    Random rand = new Random();
	    HashChain hashTable = new HashChain(size);


	    for (int i = 0; i < initSize; i++)
	    {
	    	hashTable.insert(new Link(rand.nextInt(10000000)));
	    }
	    hashTable.displayTable();
	    
	    int mo=0;
	    for(int i =0; i<30; i++)
	    {
	    	SortedList.setAvg();
	    	if(hashTable.find(rand.nextInt(10000000))==null)
	    	{
	    		System.out.println("Not Found");
	    	}
	    	else
	    	{
	    		System.out.println("Found");
	    	}
	    	mo = mo + SortedList.getAvg();
	    }
	    
	    System.out.println((float)mo/30);
	}
}
