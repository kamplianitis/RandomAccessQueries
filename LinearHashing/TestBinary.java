// same as the BinaryTree ... check the rand function
package binaryTree;


import java.util.Random;

public class TestBinary {

	public static void main(String[] args) 
	{
		int number = 100000; // the number of data i have to create
		Random rand = new Random(); // the random object
		BinaryTree tree = new BinaryTree();
		
		// so now i have to fill the treee with all the data
		int[] numbers = new int[number];
		
		for(int i=0; i<number; i++) 
		{
			numbers[i] = rand.nextInt();
		}
		
		// now i have an array of all the numbers i need to fill in the tree...
		
		for(int i=0; i<number; i++)
		{
			tree.add(numbers[i]);
		}
		
		
		
		// now that the array is filled all i have to do is search from the array (in order to be sure that the number can be found) and then i search random numbers
		
		int mo=0;
		for(int i=0; i<30; i++)
		{
			if(tree.search(rand.nextInt()))
			{
				System.out.println("Found");
			}
			else
				System.out.println("Not Found");
			mo =+ tree.getAvg();
		}
		System.out.println("average: "+mo/30);		
	}
	
	
}
