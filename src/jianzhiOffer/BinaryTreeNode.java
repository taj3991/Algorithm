package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/12.
 */
public class BinaryTreeNode {

    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode() {

    }

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }


    public static void printFromRoot(BinaryTreeNode root) {
        BinaryTreeNode left = root.left;
        BinaryTreeNode right = root.right;

        Integer leftValue = null;
        if (left != null) leftValue = left.value;

        Integer rightValue = null;
        if (right != null) rightValue = right.value;

        System.out.println(leftValue + "<- " + root.value + " ->" + rightValue);

        if (left != null) {
            printFromRoot(left);
        }

        if (right != null) {
            printFromRoot(right);
        }


    }
}
