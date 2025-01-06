package class03_tree;

import class03_tree.Code00_TreeCommon.TreeNode;

public class Code08_LCA {

	// o1 o2 在root上的最低公共祖先
	// 要么公公祖先是root 要么是root的左节点 或者右节点
	public static TreeNode LCA(TreeNode root,TreeNode o1,TreeNode o2) {
		if(root == null||o1==root || o2 == root  ) { //有一个是根节点
			return root;
		}
		
		TreeNode left = LCA(root.left,o1,o2);
		TreeNode right = LCA(root.right,o1,o2);
		if(left != null && right!=null) {
			return root;
		}
		return  left==null?right:left;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
