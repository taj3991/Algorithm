package jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tangjian on 2016/12/17.
 */
public class Question22 {


    public static void main(String[] args) {

        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(10);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(9);
        BinaryTreeNode node7 = new BinaryTreeNode(11);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        printBinaryTreeFromTopToBottom(node1);



    }

    static  void printBinaryTreeFromTopToBottom(BinaryTreeNode root){

        if (root == null)return;

        Queue<BinaryTreeNode> queue  = new LinkedList<BinaryTreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryTreeNode head = queue.poll();
            System.out.print(head.value+"\t");

            if (head.left!=null){
                queue.offer(head.left);
            }

            if (head.right!=null){
                queue.offer(head.right);
            }

        }


    }
}
