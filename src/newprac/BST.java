package newprac;

public class BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,2,3,4,5,6,7,8,9};
		int s = 0;
		int e = arr.length-1;
		
		BST bst = new BST();
		TreeNode root = bst.createBst(arr, s, e);
		bst.printBst(root);
	}
	
	
	public static TreeNode createBst(int[] arr, int s, int e){
		
		
		if(s>e)
			return null;
		
		int mid = (s+e)/2;
		
		TreeNode root = new newprac.TreeNode(arr[mid]);
		
		root.setLeft(createBst(arr, 0, mid-1));
		root.setRight(createBst(arr, mid+1, e));
		
		
		return root;
	}
	
	public void printBst(TreeNode root){
		
	}

}
