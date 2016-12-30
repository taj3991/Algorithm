package jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangjian on 2016/12/30.
 */
public class Question59 {


    public static void main(String[] args) {


        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5l = new BinaryTreeNode(5);
        BinaryTreeNode node5r = new BinaryTreeNode(5);

        BinaryTreeNode node6l = new BinaryTreeNode(6);
        BinaryTreeNode node6r = new BinaryTreeNode(6);
        BinaryTreeNode node7l = new BinaryTreeNode(7);
        BinaryTreeNode node7r = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);

        node8.left = node6l;
        node6l.left = node5l;
        node6l.right = node7l;


        node8.right = node6r;
        node6r.left = node7r;
        node6r.right = node5r;


        /*boolean isSysmmetry = isSymmetryBinaryTree(node8);
        System.out.println(isSysmmetry);*/

        List<Integer> preorderValueList = new ArrayList<>();
        preorderView(node8,preorderValueList);

        List<Integer> selfPreorderValueList = new ArrayList<>();
        selfDefinePreorderView(node8,selfPreorderValueList);

        for(int i = 0 ; i < preorderValueList.size() ; i ++){
            if ( preorderValueList.get(i) != selfPreorderValueList.get(i)){
                System.out.println(false);
                break;
            }
        }

    }


    static boolean isSymmetryBinaryTree(BinaryTreeNode root) {
        if (root == null) return false;

        boolean isSysmmetry = false;

        isSysmmetry = isSymmetry(root, root);
        return isSysmmetry;

    }

    static boolean isSymmetry(BinaryTreeNode node1, BinaryTreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.value != node2.value) return false;
        return isSymmetry(node1.left, node2.right) && isSymmetry(node1.right, node2.left);
    }


    static void preorderView(BinaryTreeNode root, List<Integer> valueList) {
        if (root == null) return;
        valueList.add(root.value);

        if (root.left == null) {
            valueList.add(null);
        } else {
            preorderView(root.left, valueList);
        }

        if (root.right == null) {
            valueList.add(null);
        } else
            preorderView(root.right, valueList);
    }



    static  void selfDefinePreorderView(BinaryTreeNode root, List<Integer> valueList) {
        if (root == null) return;
        valueList.add(root.value);

        if (root.right == null) {
            valueList.add(null);
        } else
            selfDefinePreorderView(root.right, valueList);


        if (root.left == null) {
            valueList.add(null);
        } else {
            selfDefinePreorderView(root.left, valueList);
        }

    }


}
