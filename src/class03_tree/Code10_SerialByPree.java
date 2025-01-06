package class03_tree;

import static class03_tree.Code00_TreeCommon.TreeNode;
import static class03_tree.Code00_TreeCommon.getTree1;



public class Code10_SerialByPree {
	// 二叉树的序列化
	// 润
	public static String serialByPre(TreeNode root) {
		if(root == null) {
			return "#_";
		}
		String res = root.val+"_";
		res+=serialByPre(root.left);
		res+=serialByPre(root.right);
		return res;
	}
	public static void main(String []args) {
		TreeNode tree =getTree1();
		String s = serialByPre(tree );
		System.out.println(s);
	}

}
