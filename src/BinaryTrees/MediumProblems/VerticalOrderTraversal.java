package BinaryTrees.MediumProblems;

import java.util.*;

class Tuple{
    TreeNode node;
    int row; //vertical
    int col; // level

    public Tuple(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(verticalTraversal(root));
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();

        TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root,0,0));

        while (!queue.isEmpty()){
            // remove tuple from the queue
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int x = tuple.row; //vertical
            int y = tuple.col; //level

            // if map does not have key with vertical x, put x as key and corresponding to
            // it initialize value empty treemap as value.
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            // if corresponding to vertical x, there is no key of level y then put and initialize
            // priority queue as value.
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }

            // fill the priority queue with nodes value (to achieve sorting we use PQ)
            map.get(x).get(y).offer(node.val);

            if(node.left != null){
                queue.offer(new Tuple(node.left,x-1,y+1));
            }
            if(node.right != null){
                queue.offer(new Tuple(node.right,x+1,y+1));
            }
        }

        for(TreeMap<Integer,PriorityQueue<Integer>> ys : map.values()){
            List<Integer> subList = new ArrayList<>();
                for(PriorityQueue<Integer> nodes : ys.values()){
                    while (!nodes.isEmpty()) {
                        int n = nodes.poll();
                        subList.add(n); // add to the end
                    }
                }
                // add subList which contains list of nodes with same vertical and level to ans.
                ans.add(subList);
        }

        return ans;
    }
}
