package BinaryTrees.MediumProblems;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(5);

        System.out.println("Height of the given binary tree is : " + height(root));
    }
    private static int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int lh = height(node.left);
        int rh = height(node.right);

        return 1 + Math.max(lh,rh);
    }
}
