package jianzhiOffer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * Created by tangjian on 2016/12/30.
 */
public class Question61 {


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


        printTreeInZShape(node8);

    }
    static  void printTreeInZShape(BinaryTreeNode root){
        if ( root == null)return;
        Map<Integer,Stack<BinaryTreeNode>> levels  = new HashMap<Integer,Stack<BinaryTreeNode>>();
        int current = 0;
        int next = 1;
        levels.put(current,new Stack<BinaryTreeNode>());
        levels.put(next,new Stack<BinaryTreeNode>());

        levels.get(current).add(root);

        while(!levels.get(current).isEmpty() || !levels.get(next).isEmpty()){
            Stack<BinaryTreeNode> currentStack = levels.get(current);
            Stack<BinaryTreeNode> nextStack = levels.get(next);

            BinaryTreeNode pNode  = currentStack.pop();

            System.out.print(pNode.value+"\t");


            if (current == 0){
              if (pNode.left != null){
                  nextStack.push(pNode.left);
              }
              if (pNode.right != null){
                  nextStack.push(pNode.right);
              }

            }else{
                if (pNode.right != null){
                    nextStack.push(pNode.right);
                }
                if (pNode.left != null){
                    nextStack.push(pNode.left);
                }

            }

            levels.put(current,currentStack);
            levels.put(next,nextStack);


            if (currentStack.isEmpty()){
                System.out.println();
                current = 1-current;
                next  = 1-current;
            }



        }


    }


}
