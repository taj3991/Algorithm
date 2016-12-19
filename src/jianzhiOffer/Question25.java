package jianzhiOffer;

import java.util.Enumeration;
import java.util.Stack;

/**
 * Created by tangjian on 2016/12/17.
 */
public class Question25 {
    static Stack<Integer> stack = new Stack<>();


    public static void main(String[] args) {

        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(12);
        BinaryTreeNode node3 = new BinaryTreeNode(12);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        printValueEqNBinaryTreePath(node1, 22, 0);


    }

    static void printValueEqNBinaryTreePath(BinaryTreeNode root, int n, int sum) {
        if (root == null) {
            return;
        }
        int value = root.value;
        sum += value;
        stack.push(value);
        if (sum == n) {
            printStack(stack);
        } else if (sum < n) {
            printValueEqNBinaryTreePath(root.left, n, sum);
            printValueEqNBinaryTreePath(root.right, n, sum);
        } else {
            return;
        }
        stack.pop();
    }


    private static void printStack(Stack<Integer> stack) {
        Enumeration enumeration = stack.elements();
        while (enumeration.hasMoreElements()) {
            System.out.print(enumeration.nextElement() + "\t");
        }
        System.out.println();
    }
}
