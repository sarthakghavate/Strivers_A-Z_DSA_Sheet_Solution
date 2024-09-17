package BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair{
    TreeNode node;
    int num;
    public Pair(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
}
public class AllDFSIInOneTraversal {
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

        System.out.println("----All DFS Traversals of binary tree using one traversal-----");
        DFS(root);
    }

    private static void DFS(TreeNode root){
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if(root == null){
            return;
        }

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root,1));

        while (!stack.isEmpty()){
            Pair it = stack.pop();

            if(it.num == 1){
                pre.add(it.node.val);
                it.num++;
                stack.push(it);

                if(it.node.left != null){
                    stack.push(new Pair(it.node.left,1));
                }
            }
            else if(it.num == 2){
                in.add(it.node.val);
                it.num++;
                stack.push(it);

                if(it.node.right != null){
                    stack.push(new Pair(it.node.right,1));
                }
            }
            else{
                post.add(it.node.val);
            }
        }

        System.out.println("Preorder : "+ pre);
        System.out.println("Inorder : "+ in);
        System.out.println("Postorder : "+ post);
    }
}
