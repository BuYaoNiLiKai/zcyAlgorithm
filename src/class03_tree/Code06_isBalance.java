package class03_tree;

import class03_tree.Code00_TreeCommon.TreeNode;

public class Code06_isBalance {
	public static class ReturnData{
		boolean isBST;
		int height;
		public ReturnData(boolean is,int h) {
			isBST = is;
			height = h;
		}
	}
	// 平衡二叉树
	public static boolean isBST(TreeNode tree) {
		return process(tree).isBST;
	}
	public  static ReturnData process(TreeNode tree) {
		if(tree==null) {
			return new ReturnData(true,0);
		}
		ReturnData leftData = process(tree.left);
		ReturnData rightData = process(tree.right);
		int height = Math.max(leftData.height, rightData.height)+1;
		boolean isBST = leftData.isBST&&rightData.isBST&&Math.abs(
				leftData .height -rightData .height
				)<2;
		return new ReturnData(isBST,height);
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
