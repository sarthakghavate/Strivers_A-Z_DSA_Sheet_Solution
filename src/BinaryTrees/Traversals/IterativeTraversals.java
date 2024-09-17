package BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeTraversals {
    public static void main(String[] args) {
        /*
            Tree:
                        1

                  2             7

              3        4

                    5       6

             preorder : 1 2 3 4 5 6 7
             inorder : 3 2 5 4 6 1 7
             postorder : 3 5 6 4 2 7 1
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        System.out.println("Iterative Preorder : " + iterativePreorder(root));
        System.out.println("Iterative Inorder : " + iterativeInorder(root));
        System.out.println("Iterative Postorder : " + iterativePostorderUsingTwoStacks(root));
    }

    private static List<Integer> iterativePreorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        if (node == null) {
            return ans;
        }

        stack.push(node);

        while (!stack.isEmpty()) {
            node = stack.pop();
            ans.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return ans;
    }

    private static List<Integer> iterativeInorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        // if the tree is empty then return ans
        if (node == null) {
            return ans;
        }

        while (true) {
            if (node != null) {
                stack.push(node); // push into stack
                node = node.left; // go to left
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                node = stack.pop(); // pop the node
                ans.add(node.val); // add top value to the answer
                node = node.right; // go to right
            }
        }
        return ans;
    }

    private static List<Integer> iterativePostorderUsingTwoStacks(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode node = root;
        // if the tree is empty then return ans
        if (node == null) {
            return ans;
        }

        stack1.push(node);
        while (!stack1.isEmpty()) {
            node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            node = stack2.pop();
            ans.add(node.val);
        }

        return ans;
    }
}