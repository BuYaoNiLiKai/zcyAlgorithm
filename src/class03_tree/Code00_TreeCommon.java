package class03_tree;

public class Code00_TreeCommon {
	public static class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
			
		}
	}
	public static TreeNode generateRandomTree() {
		return null;
	}
	public static TreeNode getTree1() {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);
		tree.right.left = new TreeNode(6);
		tree.right.right = new TreeNode(7);
		return tree;
	}
	public static TreeNode getTree2() {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);
		tree.right.left = new TreeNode(8);
		tree.right.right = new TreeNode(9);
		tree.left.right.left = new TreeNode(6);
		tree.left.right.left.left = new TreeNode(7);
		tree.right.left.right = new TreeNode(10);
		tree.right.left.right.left = new TreeNode(11);
		return tree;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
