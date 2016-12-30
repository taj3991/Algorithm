package jianzhiOffer;

import java.util.LinkedList;

/**
 * Createdi by tangjian on 2016/12/30.
 */
public class Question60 {


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

        node8.left = node6;
        node6.left = node5;
        node6.right = node7;

        node8.right  = node1;
        node1.left = node2;
        node1.right = node3;

        printBinaryTree(node8);


    }
    static void printBinaryTree(BinaryTreeNode binaryTreeNode){
        if (binaryTreeNode == null)return;

        LinkedList<BinaryTreeNode> linkedList = new LinkedList<BinaryTreeNode>();
        linkedList.push(binaryTreeNode);

        int nextLevel = 0;
        int tobePrinted = 1;
        while(!linkedList.isEmpty()){
            BinaryTreeNode node = linkedList.pop();
            System.out.print(node.value+"\t");

            if (node.left != null){
                nextLevel ++;
                linkedList.add(node.left);
            }

            if (node.right != null){
                nextLevel ++;
                linkedList.add(node.right);
            }

            tobePrinted--;

            if (tobePrinted == 0){
                System.out.println();
                 tobePrinted = nextLevel;
            }
        }

    }
}
