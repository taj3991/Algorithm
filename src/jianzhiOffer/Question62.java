package jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangjian on 2016/12/30.
 */
public class Question62 {

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

        List<Integer> valueList = new ArrayList<>();
        preorderView(node8,valueList);

        for(Integer i:valueList){
            System.out.print(i+"\t");
        }

        System.out.println();
          int [] arr = {0};
        BinaryTreeNode root = deserialize(valueList,arr);
        System.out.println(root.value);
       BinaryTreeNode.printFromRoot(root);

        Integer ii = new Integer(0);
        Integer i2 = ii++;
        System.out.println(ii.hashCode());
        System.out.println(i2.hashCode());




    }



    static  BinaryTreeNode deserialize(List<Integer> valueList,int[] arr){
        int index  = arr[0];
        if (valueList == null || valueList.isEmpty()  || index > valueList.size()-1 )return  null;
        if (valueList.get(index) != null){
            BinaryTreeNode root = new BinaryTreeNode();
            root.value = valueList.get(index);
            arr[0]+=1;
            root.left = deserialize(valueList,arr);
            arr[0]+=1;
            root.right = deserialize(valueList,arr);
            return  root;
        }
        return null;
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
}
