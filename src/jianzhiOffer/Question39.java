package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/21.
 */
public class Question39 {


    public static void main(String[] args) {

        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);

        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;

      /*  node6.left = node7;
        node6.right = node8;*/

        //node8.right = node9;

        int depth = treeDepth(node1);
        // getTreeDepth(node1,1);
        System.out.println(depth);

        System.out.println(isBalanceTree(node1, 0));

    }

    static int getTreeDepth(BinaryTreeNode rootNode, int currentTreeDepth) {
        if (rootNode == null) return currentTreeDepth;

        int leftTreeDepth = currentTreeDepth;
        if (rootNode.left != null) {
            leftTreeDepth = getTreeDepth(rootNode.left, leftTreeDepth + 1);
        }

        int rightTreeDepth = currentTreeDepth;
        if (rootNode.right != null) {
            rightTreeDepth = getTreeDepth(rootNode.right, rightTreeDepth + 1);
        }
        int depth = leftTreeDepth > rightTreeDepth ? leftTreeDepth : rightTreeDepth;
        return depth;
    }

    static int treeDepth(BinaryTreeNode root) {
        if (root == null) return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return (left > right) ? left + 1 : right + 1;
    }


    int isBalanceTree(BinaryTreeNode root) {

        int depth = 0;
       depth  = isBalanceTree(root, depth);
        return depth;
    }


    private static int isBalanceTree(BinaryTreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int leftDepth = depth;
        int rightDepth = depth;

        leftDepth = isBalanceTree(root.left, leftDepth+1);
        rightDepth = isBalanceTree(root.right, rightDepth+1);
        int diff = Math.abs(leftDepth - rightDepth);
        if (diff <= 1) {
            depth = (leftDepth > rightDepth) ? leftDepth : rightDepth ;
            return depth;
        } else {
            return -1;
        }

    }


}
