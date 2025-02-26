package class10_treedp;

import class03_tree.Code00_TreeCommon.TreeNode;

public class Code01_MaxDistance {
	// 二叉树最远距离
	public static int maxDistance(TreeNode root) {
		return process(root).maxDistance;
	}
	public static class Info{
		int maxDistance;
		int height;
		public Info(int m ,int h) {
			maxDistance = m;
			height = h;
		}
	}
	private static Info process(TreeNode root) {
		if(root == null) {
			return new Info(0,0);
		}
		Info leftInfo = process(root.left);
		Info rightInfo = process(root.right);
		int p1 = leftInfo.maxDistance;
		int p2 = rightInfo.maxDistance;
		int p3 = leftInfo.height+1 + rightInfo.height+1;
		int maxDistance = Math.max(p3, Math.max(p1, p2));
		int height = Math.max(leftInfo.height, rightInfo.height)+1;
		return new Info(maxDistance,height);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
