package class03_tree;

import java.util.LinkedList;
import java.util.Queue;

import class03_tree.Code00_TreeCommon.TreeNode;

public class Code04_isCBT {

	// 判断是不是 完全二叉树
	public static boolean isCBT(TreeNode tree) {
		if(tree==null) {
			return  true;
		}
		boolean findLeaf = false;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(tree);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			TreeNode left = cur.left;
			TreeNode right =cur.right;
			if(
					findLeaf&&(left!=null||right!=null)
					||
					(left==null&&right!=null)
					
			 ) {
				return false;
			}
				
			if(cur.left!=null) {
				queue.add(cur.left);
			}
			if(cur.right!=null) {
				queue.add(cur.right);
			}
			if(left==null||right==null) {
				findLeaf = true;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
