package BinaryTrees.MediumProblems;

public class IdenticalBinaryTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println(isSame(p,q) + " : p and q are identical binary trees.");
    }

    private static boolean isSame(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if((p == null && q != null) || (p != null && q == null)){
            return false;
        }
        if(p.val != q.val){
            return false;
        }

        return isSame(p.left,q.left) && isSame(p.right,q.right);

    }
}
