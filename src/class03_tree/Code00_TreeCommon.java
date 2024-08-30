package class03_tree;

public class Code00_TreeCommon {
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            this.value = x;
            this.left = null;
            this.right = null;
        }

    }

    public static TreeNode generateRandomTree(int maxSize, int maxValue) {
        // 生成一个随机的树
        int size = (int) (Math.random() * (maxSize + 1));
        if (size == 0) {
            return null;
        }
        int val = (int) (Math.random() * (maxValue + 1));
        TreeNode root = new TreeNode(val);
        for (int j = 1; j <= size; j++) {
            val = (int) (Math.random() * (maxValue + 1));
            TreeNode cur = root;
            while (true) {
                // 随机插入节点
                if (Math.random() < 0.5) {
                    // 若左子树为空，往左子树上插入节点，否则，cur=左子树
                    if (cur.left == null) {
                        cur.left = new TreeNode(val);
                        break;
                    } else {
                        cur = cur.left;
                    }
                } else {
                    // 若右子树为空，往右子树上插入节点，否则，cur=右子树
                    if (cur.right == null) {
                        cur.right = new TreeNode(val);
                        break;
                    } else {
                        cur = cur.right;
                    }
                }
            }
        }
        return root;
    }

    public static void preorderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preorderPrint(root.left);
        preorderPrint(root.right);
    }

    public static void inorderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderPrint(root.left);
        System.out.print(root.value + " ");
        inorderPrint(root.right);
    }

    public static void postorderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderPrint(root.left);
        postorderPrint(root.right);
        System.out.print(root.value + " ");
    }

    public static void main(String[] args) {
        TreeNode root = generateRandomTree(10, 10);
        preorderPrint(root);
        System.out.println();
        inorderPrint(root);
        System.out.println();
        postorderPrint(root);
    }
}
