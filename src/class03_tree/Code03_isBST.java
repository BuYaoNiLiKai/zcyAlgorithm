package class03_tree;


import java.util.Stack;

import class03_tree.Code00_TreeCommon.TreeNode;

public class Code03_isBST {
	// 判断一个树是不是搜索二叉树 左孩子<根节点<右孩子
	public static int preVal = Integer.MIN_VALUE;
	public static boolean isBST1(TreeNode tree) {
		if(tree==null) {
			return true;
		}
		boolean isLeftBST = isBST1(tree.left);
		if(!isLeftBST) {
			return false;
		}
		if(tree.val<preVal) {
			return false;
		}else {
			preVal = tree.val;
		}
		return isBST1(tree.right);	
		
	}
	public static boolean isBST2(TreeNode tree) {
		// 非递归 中序遍历
		if(tree==null) {
			return true;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = tree;
		int preVal = Integer.MIN_VALUE;
		while(!stack.isEmpty()||cur!=null) {
			while(cur!=null) {
				stack.add(cur);
				cur= cur.left;
			}
			cur = stack.pop();
			if(cur.val<preVal) {
				return false;
			}else {
				preVal = cur.val;
			}
			cur = cur.right;
			
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
