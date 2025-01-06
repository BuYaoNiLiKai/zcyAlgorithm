package class03_tree;

public class Code09_GetSuccessor {
	// 某个节点的后继节点 有父节点 能不能快一点儿 中序便利的后一节点
	public static class TreeNodeWithP{
		int val;
		TreeNodeWithP left;
		TreeNodeWithP right;
		TreeNodeWithP parent;
	}
	public TreeNodeWithP getSuccessor(TreeNodeWithP o) {
		if(o == null) {
			return null;
		}
		if(o.right!=null) {
			// 右子树不为 则为右子树最左侧的节点
			return getLeftMost(o.right);
		}else {
			TreeNodeWithP parent = o.parent;
			while(parent!=null&&parent.left!=o) {
				o = parent;
				parent = o.parent;
			}
			return  parent;
		}

		
	}
	public TreeNodeWithP getLeftMost(TreeNodeWithP root) {
		// 一棵树的最左侧节点
		if(root==null) {
			return null;
		}
		while(root.left!=null) {
			root = root.left;
		}
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
