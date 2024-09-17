package BinaryTrees.MediumProblems;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(5);

        System.out.println(isBalanced(root));
    }

    private static boolean isBalanced(TreeNode root) {
        // if check functions returns -1 then tree is not balanced
        // if return height of the tee then it is balanced.
        return check(root) != -1;
    }

    private static int check(TreeNode node){
        if(node == null){
            return 0;
        }

        int lh = check(node.left);
        int rh = check(node.right);

        // passes -1 to above function call
        if(lh == -1 || rh == -1){
            return -1;
        }
        // check for imbalance
        if(Math.abs(lh - rh) > 1){
            return -1;
        }

        return 1 + Math.max(lh,rh);
    }

}
