package Multiway;

import java.util.Random;

import binaryTree.BinaryTree;

public class Main 
{
	public static void main (String args[])
	{
		int number = 100000; // the number of data i have to create
		Random rand = new Random(); // the random object
		MultiwayTree tree = new MultiwayTree(50);
		int searches = 30;
		
		
		// so now i have to fill the treee with all the data
		int[] numbers = new int[number];
				
		for(int i=0; i<number; i++)
		{
			numbers[i] = rand.nextInt();
		}
		
		for(int i=0; i<number; i++)
		{
			tree.insert(numbers[i]);
		}
		
		
		// search
		
		int mo=0;
		for(int i=0; i<searches; i++)
		{
			tree.setAvg();
			if(tree.searchstart(rand.nextInt()) != null)
				System.out.println("Found");
			else 
				System.out.println("Not Found");
			mo = mo + tree.getAvg();
		}
		System.out.println((float)mo/searches);
	}
}
