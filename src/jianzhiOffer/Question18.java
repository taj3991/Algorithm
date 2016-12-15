package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/15.
 */
public class Question18 {


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


        BinaryTreeNode node6 = new BinaryTreeNode(8);
        BinaryTreeNode node7 = new BinaryTreeNode(9);
        BinaryTreeNode node8 = new BinaryTreeNode(2);

        node6.left = node7;
        node6.right = node8;


        boolean result = hasSubTree(node1, node6);
        System.out.println(result);


    }

    static boolean hasSubTree(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
        boolean hasSubTree = false;
        if (pRoot1 != null && pRoot2 != null) {
            if (pRoot1.value == pRoot2.value) {
                hasSubTree = doesTree1HasTree2(pRoot1, pRoot2);

            }

            if (pRoot1.left != null && !hasSubTree) {
                hasSubTree = hasSubTree(pRoot1.left, pRoot2);
            }


            if (pRoot1.right != null && !hasSubTree) {
                hasSubTree = hasSubTree(pRoot1.right, pRoot2);
            }
        }
        return hasSubTree;

    }

    private static boolean doesTree1HasTree2(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
        if (pRoot2 == null) return true;
        if (pRoot1 == null) return false;


        if (pRoot1.value != pRoot2.value) return false;

        return doesTree1HasTree2(pRoot1.left, pRoot2.left)
                && doesTree1HasTree2(pRoot1.right, pRoot2.right);
    }
}
