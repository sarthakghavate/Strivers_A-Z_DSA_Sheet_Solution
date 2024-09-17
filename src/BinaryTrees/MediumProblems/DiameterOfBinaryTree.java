package BinaryTrees.MediumProblems;

public class DiameterOfBinaryTree {

    static int max = 0;
    public static void main(String[] args) {
        // Creating tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // brute force
        int ans = findDiameterOfBinaryTree(root);
        System.out.println("Diameter of the given binary tree is : "+ans);

        // optimal
        int ansOptimal = findDiameterOfBinaryTreeOptimal(root);
        System.out.println("Diameter of the given binary tree is : "+ansOptimal);

    }


    // brute force - go to each node, cal lh and rh, return max(lh+rh) as answer
    private static int findDiameterOfBinaryTree(TreeNode root){
        findDiameter(root);
        return max;
    }
    private static void findDiameter(TreeNode root){
        if(root == null){
            return;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        max = Math.max(max,lh+rh);

        findDiameterOfBinaryTree(root.left);
        findDiameterOfBinaryTree(root.right);
    }

    private static int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return 1+Math.max(lh,rh);
    }


    /*optimal - when we make call for the height(root), it goes and
                calculates lh and rh for each node.so when we get lh and rh ,
                immediately update the max (prev max and lh+rh).so our max will store the diameter.
                We use maxi array here instead of int maxi variable,because
                in java primitives are pass by value, changes made to that variable in a function
                won't change the original or outside value
                and objects does opposite to it, they are passed by reference means changes made to the
                object in a function call will change the outside value also.

     */
    private static int findDiameterOfBinaryTreeOptimal(TreeNode root) {
        int [] maxi = new int[1];
        findMax(root,maxi);
        return maxi[0];
    }
    private static int findMax(TreeNode root, int[] maxi) {
        if(root == null){
            return 0;
        }

        int lh = findMax(root.left,maxi);
        int rh = findMax(root.right,maxi);

        maxi[0] = Math.max(maxi[0],lh+rh);

        return 1 + Math.max(lh,rh);
    }
}
