package BinaryTrees.MediumProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        /*
                    1
                 2      3
             4      5       6


             Expected ans : [[1],[3,2],[4,5,6]
         */

        System.out.println(zigzagLevelOrder(root));
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true; // to keep track of direction we have to go.

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.remove();

                // if the direction is leftToRight add nodes value to end of the list
                // else add nodes value to the starting of the list.(for reversal).
                if(leftToRight){
                    subList.add(node.val);
                }
                else{
                    subList.add(0,node.val);  // adds elements to list in reverse order
                }

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            // now we have completed one level
            leftToRight = !leftToRight;
            ans.add(subList);
        }
        return ans;
    }
}
