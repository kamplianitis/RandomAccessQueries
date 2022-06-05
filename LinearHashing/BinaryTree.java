// done ... only the time searches remaining
package binaryTree;

public class BinaryTree 
{
	// for a tree creation a node is necessary
	// so i create a private class that is the node.... in this way i can create an inner object without creating the outter
	private static class BinaryNode
	{
		int data;// the data
		BinaryNode left;
		BinaryNode right;
		
		
		// constructor
		public BinaryNode(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	// now i have to write the tree
	
	// first things first i have to create the first node that is the root and initialize it to null.
	// the tree is empty at the start
	
	private BinaryNode root;
	
	
	public BinaryTree()
	{
		this.root = null;
	}
	
	
	private static BinaryNode insertNode(int data, BinaryNode subtree)
	{
		// first i take the outter case of the recursive function.
		if(subtree == null)
		{
			System.out.println("Node Added");
			return new BinaryNode(data);
		}
		else // the case there is a noode is filled already and we have to go deeper
		{
			if(data<subtree.data)
				subtree.left = insertNode(data, subtree.left);
			else
				subtree.right = insertNode(data, subtree.right);
		}
		return subtree;
	}
	
	// the insert fucntion is done so i have to make a function that helps with the recursion
	public void add(int data)
	{
		root = insertNode(data, root);
	}
	
	
	
	// search in the tree
	 public static int avg=0;
	private static boolean searchNode(BinaryNode subtree, int data)
	{
		if(subtree == null)
			return false;
		else if(subtree.data == data)
			return true;
		else
		{
			if(data<subtree.data)
			{
				avg++;
				return searchNode(subtree.left, data);
			}
			// no need of else bracket here
			avg++;
			return searchNode(subtree.right, data);
		}
	}
	
	// this function exists cause the upper function is private
	public boolean search(int data)
	{
		return searchNode(root, data);
	}
	
	public void  setAvg()
	{
		avg =0 ;
	}
	
	public int getAvg()
	{
		return this.avg;
	}
	
}
