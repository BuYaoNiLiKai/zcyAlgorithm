package class03_tree;

import static class03_tree.Code00_TreeCommon.TreeNode;
import static class03_tree.Code00_TreeCommon.getTree1;
import static class03_tree.Code00_TreeCommon.getTree2;
import java.util.Stack;
public class Code01_PreInPostOrderTree {
	public static void f(TreeNode root) {
		// 递归序
		if(root==null) {
			return ;
		}
		//第一次来到
		System.out.println(root.val);
		f(root.left);
		
		//第二次来到
		System.out.println(root.val);
		f(root.right);
		
		// 第三次来到
		System.out.println(root.val);	
	}
	
	// 递归实现先序遍历
	public static void preOrderTree(TreeNode root) {
		if(root==null) {
			return ;
		}
		System.out.println(root.val);
		preOrderTree(root.left);
		preOrderTree(root.right);
	}
	// 中序遍历
	public static void inOrderTree(TreeNode root) {
		if(root==null) {
			return ;
		}
		
		inOrderTree(root.left);
		System.out.println(root.val);
		inOrderTree(root.right);
	}
	// 后序遍历
	public static void postOrderTree(TreeNode root) {
		if(root==null) {
			return ;
		}
		
		postOrderTree(root.left);
		postOrderTree(root.right);
		System.out.println(root.val);
	}
	// 非递归先序
	public static void unRecPreOrderTree(TreeNode tree) {
		if(tree==null) {
			return ;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(tree);
		while(!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			System.out.println(cur.val);
			if(cur.right!=null) {
				stack.add(cur.right);
			}
			if(cur.left!=null) {
				stack.add(cur.left);
			}
		}
	}
	// 非递归中序
	public static void unRecInOrderTree(TreeNode tree) {
		if(tree==null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = tree;
		while(!stack.isEmpty()||cur!=null) { 
			while(cur!=null) {
				stack.add(cur);
				cur= cur.left;
			}
			cur = stack.pop();
			System.out.println(cur.val);
			cur = cur.right;
			
		}
	}
	// 非递归后序
	public static void unRecPostOrderTree(TreeNode tree) {
		if(tree==null) {
			return ;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> help = new Stack<TreeNode>();
		stack.add(tree);
		while(!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			help.add(cur);
			if(cur.left!=null) {
				stack.add(cur.left);
			}
			if(cur.right!=null) {
				stack.add(cur.right);
			}
		}
		while(!help.isEmpty()) {
			System.out.println(help.pop().val);
		}
	}
	//二叉树的前序遍历中序遍历 和后序遍历
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree = getTree1();
		f(tree);
		System.out.println("________递归先序________");
		preOrderTree(tree);
		System.out.println("________递归中序________");
		inOrderTree(tree);
		System.out.println("________递归后序________");
		postOrderTree(tree);
		
		System.out.println("________非递归先序________");
		unRecPreOrderTree(tree);
		System.out.println("________非递归中序________");
		unRecInOrderTree(tree);
		System.out.println("________非递归后序________");
		unRecPostOrderTree(tree);
		System.out.println("_________________________");
		TreeNode tree1 = getTree2();
		inOrderTree(tree1);
		

	}

}
