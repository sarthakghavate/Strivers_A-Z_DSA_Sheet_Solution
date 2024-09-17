package BinaryTrees.Traversals;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

     TreeNode(int val){
        this.val = val;
    }
     TreeNode(int val,TreeNode left, TreeNode right){
        this.val = val;
        this.left = null;
        this.right = null;
    }

}
public class Traversals {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // DFS : inorder,preorder,postorder
        System.out.print("Preorder Traversal : ");
        preorder(root);
        System.out.println();
        System.out.print("Iterative Preorder Traversal : ");
        System.out.println(iterativePreorderTraversal(root));

        System.out.print("Inorder Traversal : ");
        inorder(root);
        System.out.println();
        System.out.print("Iterative Inorder Traversal : ");
//        System.out.println(iterativeInorderTraversal(root));

        System.out.print("Postorder Traversal : ");
        postorder(root);
        System.out.println();

        // BFS : level-order
        System.out.print("Level Order Traversal : ");
        levelOrder(root);

        System.out.print("Level wise Level Order Traversal : ");
        levelWiseLevelOrder(root);

    }

    private static void preorder(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }
    private static void inorder(TreeNode node){
        if(node == null){
            return;
        }
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }
    private static void postorder(TreeNode node){
        if(node == null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val + " ");
    }

    private static void levelOrder(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.remove();
                ans.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        System.out.println(ans);
    }
    private static void levelWiseLevelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++){
                TreeNode node = queue.remove();
                subList.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            ans.add(subList);
        }
        // print ans
        System.out.println(ans);
    }

    // iterative
    public static List<Integer> iterativePreorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return ans;
    }
//    private static List<Integer> iterativeInorderTraversal(TreeNode root) {
//
//    }
}
