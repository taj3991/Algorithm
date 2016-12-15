package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/15.
 */
public class Question19 {


    public static void main(String[] args) {

        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(8);
        BinaryTreeNode node3 = new BinaryTreeNode(7);
        BinaryTreeNode node4 = new BinaryTreeNode(9);
        BinaryTreeNode node5 = new BinaryTreeNode(2);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        BinaryTreeNode.printFromRoot(node1);

        outputTreeMirror(node1);

        BinaryTreeNode.printFromRoot(node1);

    }



    static  void outputTreeMirror(BinaryTreeNode root){

        if (root == null) return;
        BinaryTreeNode left = root.left;
        BinaryTreeNode right = root.right;

        root.left  = right;
        root.right = left;

        if (left !=null){
            outputTreeMirror(left);
        }

        if (right != null){
            outputTreeMirror(right);
        }
    }





}
