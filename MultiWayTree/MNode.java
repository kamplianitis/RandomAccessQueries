package Multiway;

public class MNode 
{
	public int[] values; // An array of values
	public int t; //defines the range for number of values
	public MNode[] C; //the children
	public int n; // Current number of values
	public boolean leaf; //if the node we have is leaf

	// Constructor 
	public MNode(int t1, boolean leaf1)
	{
		t = t1;
		leaf = leaf1;

		values = new int[2*t - 1];
		C = new MNode[2 * t];

		// Initialize the number of values as 0
		n = 0;
	}

	// A utility function to insert a new key in this node 
	// The assumption is, the node must be non-full when this 
	// function is called 
	public final void insertNonFull(int k)
	{
		int i = n - 1;

		// check this case it is a leaf node
		if (leaf == true)
		{
			while (i >= 0 && values[i] > k)
			{
				values[i + 1] = values[i];
				i--;
			}

			// Insert the new key at found location
			values[i + 1] = k;
			n = n + 1;
		}
		else // case this node is not leaf
		{
			// Find the child which is going to have the new key
			while (i >= 0 && values[i] > k)
			{
				i--;
			}

			// check the found child is not full or not
			if (C[i + 1].n == 2 * t - 1)
			{
				// If the child is full, split
				splitChild(i + 1, C[i + 1]);

				
				if (values[i + 1] < k)
				{
					i++;
				}
			}
			C[i + 1].insertNonFull(k);
		}
	}
 
	public final void splitChild(int i, MNode y)
	{
		MNode z = new MNode(y.t, y.leaf);
		z.n = t - 1;

		for (int j = 0; j < t - 1; j++)
		{
			z.values[j] = y.values[j + t];
		}

		if (y.leaf == false)
		{
			for (int j = 0; j < t; j++)
			{
				z.C[j] = y.C[j + t];
			}
		}

		y.n = t - 1;

		for (int j = n; j >= i + 1; j--)
		{
			C[j + 1] = C[j];
		}
		C[i + 1] = z;

		for (int j = n - 1; j >= i; j--)
		{
			values[j + 1] = values[j];
		}

		values[i] = y.values[t - 1];

		n = n + 1;
	}
}

