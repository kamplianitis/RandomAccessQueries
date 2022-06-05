package LinearHashing;

import java.io.*; 
import java.util.*; 

public class LinearMain {

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		int initPages = 4, pageSize = 2, i, keysNo, searchNo;
	
		LinearHashing Hash1 = new LinearHashing(pageSize, initPages);
		System.out.println("Creating Linear Hash Table...."); 

		System.out.print("\nPlease enter the number of keys you wish to insert:");
		keysNo = 100000;
		System.out.println(keysNo);
		Random r = new Random();
		while(Hash1.getKeysNum() < keysNo){
			Hash1.insertKey((r.nextInt()));
		}
		System.out.println("done");


		
		
		
		searchNo = 30;
		boolean result;
		int search_key;
		int mo=0;
		System.out.println("Searching for " + searchNo + " random keys........");
		for (i = 1; i <= searchNo; i++){
			HashBucket.setAvg();
		   search_key = (r.nextInt() % 10000);
		   result = Hash1.searchKey(search_key);
		   if (result == true)
		     System.out.println("Search Key " + search_key + " found!!!");
		   mo = mo + HashBucket.getAvg();
		}
		System.out.println((float)mo/searchNo);
	}
}

