package BinaryTrees.MediumProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClockWiseBoundaryTraversal {
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

        System.out.println("Clockwise boundary traversal for given binary tree is: "+clockwiseBoundaryTraversal(root));
    }
    private static boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
    private static List<Integer> clockwiseBoundaryTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(!isLeaf(root)){
            ans.add(root.val);
        }

        rightBoundary(root,ans);
        bottomBoundaryReverse(root,ans);
        leftBoundaryReverse(root,ans);

        return ans;
    }

    private static void rightBoundary(TreeNode root, List<Integer> ans){
        TreeNode node = root.right;

        while (node != null){
            if(!isLeaf(node)){
                ans.add(node.val);
            }

            if(node.right != null){
                node = node.right;
            }
            else{
                node = node.left;
            }
        }
    }

    private static void bottomBoundaryReverse(TreeNode root,List<Integer> ans){
        Stack<Integer> stack = new Stack<>(); // help me in reversing
        // will utilise preorder
        preorder(root,stack);

        // transfer elements stack to ans
        while (!stack.isEmpty()){
            ans.add(stack.pop());
        }
    }

    private static void preorder(TreeNode root, Stack<Integer> stack){
        if(root == null){
            return;
        }
        if(isLeaf(root)){
           stack.push(root.val);
        }

        preorder(root.left,stack);
        preorder(root.right,stack);
    }

    private static void leftBoundaryReverse(TreeNode root,List<Integer> ans){
        TreeNode node = root.left;
        Stack<Integer> stack = new Stack<>();
        while (node!=null){
            if(!isLeaf(node)){
                stack.push(node.val);
            }

            if(node.left != null){
                node = node.left;
            }
            else{
                node = node.right;
            }
        }

        // transfer from stack to ans
        while (!stack.isEmpty()){
            ans.add(stack.pop());
        }
    }

}
