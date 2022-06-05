package Multiway;

// A BTree 
public class MultiwayTree
{
	private MNode root; // Pointer to root node
	private int t; // Minimum degree
	// Constructor
	public MultiwayTree(int _t)
	{
		root = null;
		t = _t;
	}

	// function to search a value in the tree 
	int avg=1;
	public final MNode searchs(int k, MNode root)
	{
		if(root==null)
			return null;
		else
		{
			int i=0;
			while (i<root.n && k>root.values[i])
			{
				i++;
				avg++;
			}
			if(root.values[i] == k)
			{
				return root;
			}
			if(root.leaf == true)
			{
				return null;
			}
			return searchs(k,root.C[i]);
		}
	}
	
	public final MNode searchstart(int k)
	{
		return searchs(k, root);
	}
	
	// The main function that inserts a new key in this Multi-way-Tree 
	public final void insert(int k)
	{
		// case the  tree is empty
		if (root == null)
		{
			root = new MNode(t, true);
			root.values[0] = k; 
			root.n = 1; // not empty anymore
		}
		else //case the tree is not empty
		{
			// If root is full, then tree grows in height
			if (root.n == 2 * t - 1)
			{
				MNode s = new MNode(t, false);

				// Make old root as child of new root
				s.C[0] = root;

				// Split the old root and move 1 key to the new root
				s.splitChild(0, root);
				// declares the position of the key
				int i = 0;
				if (s.values[0] < k)
				{
					i++;
				}
				s.C[i].insertNonFull(k);

				//root Change
				root = s;
			}
			else
			{
				root.insertNonFull(k);
			}
		}
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg() {
		this.avg = 1;
	}
}