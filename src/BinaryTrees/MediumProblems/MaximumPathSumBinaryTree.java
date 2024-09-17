package BinaryTrees.MediumProblems;

public class MaximumPathSumBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Maximum path sum of given binary tree is "+ maxPathSum(root) +".");
    }

    private static int maxPathSum(TreeNode root) {
        int [] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        maxPath(root,maxi);
        return maxi[0];
    }
    private static int maxPath(TreeNode root, int [] maxi){
        if(root == null){
            return 0;
        }
        int leftSum = Math.max(0,maxPath(root.left,maxi)); // ignore -ve sum
        int rightSum = Math.max(0,maxPath(root.right,maxi));

        // set maxi
        maxi[0]  = Math.max(maxi[0],leftSum+rightSum+root.val);

        return root.val + Math.max(leftSum,rightSum); // to choose most sum path at each node
    }
}