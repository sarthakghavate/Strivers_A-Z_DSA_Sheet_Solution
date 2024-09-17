package BinaryTrees.MediumProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class  BoundaryTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);

        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);

        System.out.println("Anti-clockwise boundary traversal for given binary tree is: "+anticlockwiseBoundaryTraversal(root));
    }

    private static List<Integer> anticlockwiseBoundaryTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(!isLeaf(root)){
            ans.add(root.val);
        }
        leftBoundary(root,ans);
        bottomBoundary(root,ans);
        rightBoundaryReverse(root,ans);

        return ans;
    }

    private static boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }

    private static void leftBoundary(TreeNode root,List<Integer> ans){
        TreeNode node = root.left;
        while (node != null){

            if(!isLeaf(node)){
                ans.add(node.val);
            }

            if(node.left != null){
                node = node.left;
            }
            else{
                node = node.right;
            }
        }
    }

    private static void bottomBoundary(TreeNode root, List<Integer> ans){
        // here we are utilizing preorder traversal and if we found the leaf node
        // we are adding that to the answer
        if(root == null){
            return;
        }
        if(isLeaf(root)){
            ans.add(root.val);
        }
        bottomBoundary(root.left,ans);
        bottomBoundary(root.right,ans);
    }

    private static void rightBoundaryReverse(TreeNode root,List<Integer> ans){
        TreeNode node = root.right;
        Stack<Integer> stack = new Stack<>(); // for reversing we are using stack data structure.
        while (node != null){
            if(!isLeaf(node)){
                stack.push(node.val);
            }
            if(node.right != null){
                node = node.right;
            }
            else{
                node = node.left;
            }
        }

        while (!stack.isEmpty()){
            ans.add(stack.pop());
        }
    }

}
