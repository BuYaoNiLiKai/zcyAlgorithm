package class03_tree;
import static class03_tree.Code00_TreeCommon.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


import class03_tree.Code00_TreeCommon.TreeNode;
public class Code02_WidthOrderTree {
	// 二叉树的宽度优先遍历和获取二叉树的宽度
	public static void widthOrderTree(TreeNode tree) {
		if(tree==null) {
			return ;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(tree);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			System.out.println(cur.val);
			if(cur.left!=null) {
				queue.add(cur.left);
			}
			if(cur.right!=null) {
				queue.add(cur.right);
			}
		}
		
	}
	public static int getTreeWidth(TreeNode tree) {
		// 使用hashMap 求二叉树的宽度
		if(tree==null) {
			return 0 ;
		}
		int max = Integer.MIN_VALUE;
		int curLevelNodes = 0;
		int curLevel = 1;
		HashMap<TreeNode,Integer> levelMap = new HashMap<TreeNode,Integer>();
		levelMap.put(tree,1);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(tree);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if(levelMap.get(cur)==curLevel) {
				curLevelNodes++;
			}else {
				curLevel++;
				max =Math.max(max, curLevelNodes);
				curLevelNodes=1;
			}
			if(cur.left!=null) {
				queue.add(cur.left);
				levelMap.put(cur.left,levelMap.get(cur)+1);
			}
			if(cur.right!=null) {
				queue.add(cur.right);
				levelMap.put(cur.right,levelMap.get(cur)+1);
			}
		}
		return Math.max(max, curLevelNodes);
	}
	public static int getTreeWidthPlus(TreeNode tree) {
		// 不使用hashMap 求二叉树的宽度
		if(tree==null) {
			return 0 ;
		}
		int max = Integer.MIN_VALUE;
		int curLevelNodes = 0;
		TreeNode curEnd = tree;
		TreeNode nextLevelEnd = null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(tree);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			curLevelNodes++;
			if(cur.left!=null) {
				queue.add(cur.left);
				nextLevelEnd = cur.left;
			}
			if(cur.right!=null) {
				queue.add(cur.right);
				nextLevelEnd = cur.right;
			}
			if(cur == curEnd) {
				max =Math.max(max, curLevelNodes);
				curEnd = nextLevelEnd;
				curLevelNodes = 0;
			}
		
		}
		return Math.max(max, curLevelNodes);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree  = getTree1();
		widthOrderTree(tree);
		System.out.println("_____________________");
		TreeNode tree1 = getTree2();
		widthOrderTree(tree1);
		System.out.println("_____________________");
		int width = getTreeWidth(tree1);
		System.out.println(width);
		System.out.println("_____________________");
		width = getTreeWidthPlus(tree1);
		System.out.println(width);

	}

}
