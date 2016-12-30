package jianzhiOffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjian on 2016/12/30.
 */
public class Question63 {


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

        node5.left = node3;
        node3.left = node2;
        node3.right = node4;

        node5.right = node7;
        node7.left = node6;
        node7.right = node8;

        //List<BinaryTreeNode> list  = new ArrayList<>();
       /* midorderView(node5,list);
        System.out.println(list.get(2).value);*/

       //preorderView(node5);

        BinaryTreeNode kTh  = kTh(node5,new int []{5});
        System.out.println(kTh.value);

    }


    static void midorderView(BinaryTreeNode root, List<BinaryTreeNode> list) {
        if (root == null) return;

        if (root.left != null)
            midorderView(root.left, list);

        list.add(root);

        if (root.right != null)
            midorderView(root.right, list);
    }

    static void preorderView(BinaryTreeNode root) {
        BinaryTreeNode pNode = root;
         if (pNode.left != null) {
             root = pNode;
             pNode = pNode.left;
         }
         System.out.print(pNode.value+"\t");

         pNode = root.right;
         while(pNode.right != null){
             pNode = root.right;
         }
        System.out.print(pNode.value+"\t");

    }

   static BinaryTreeNode kTh(BinaryTreeNode pRoot,int [] arr){

        BinaryTreeNode target = null;
        if (pRoot.left != null){
            target = kTh(pRoot.left,arr);
        }

        if (target == null){
            if (arr[0] == 1) target = pRoot;
            arr[0] = arr[0] -1;
        }

        if (target == null && pRoot.right != null){
            target = kTh(pRoot.right,arr);
        }
        return target;
    }

}