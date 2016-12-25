package jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangjian on 2016/12/25.
 */
public class Question50 {

    public static void main(String[] args) {
        BinaryTreeNode node0 = new BinaryTreeNode(0);

        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);

        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);

        node6.left = node2;
        node6.right = node8;

        node2.left = node0;
        node2.right = node4;

        node4.left = node3;
        node4.right = node5;


        node8.left = node7;
        node8.right = node9;


        BinaryTreeNode commBinaryTreeNode = lowestCommonAncestor(node6, node0, node2);
        System.out.println(commBinaryTreeNode.value);


        List list = new ArrayList<BinaryTreeNode>();
        list.add(node6);
        List<List<BinaryTreeNode>> listList = binaryTreeAllPath(list);
        System.out.println(listList.size());


        for (List<BinaryTreeNode> ll : listList) {
            for (BinaryTreeNode binaryTreeNode : ll) {
                System.out.print(binaryTreeNode.value + "\t");
            }
            System.out.println();
        }

        BinaryTreeNode beforeNode1 = findBeforeNode(listList.get(1), node3);
        BinaryTreeNode beforeNode2 = findBeforeNode(listList.get(2), node5);
        System.out.println(beforeNode1.value);
        System.out.println(beforeNode2.value);

        BinaryTreeNode node = lowestCommonAncestor(listList, node3, node5);

        System.out.println(node.value);

        BinaryTreeNode commonNode = getCommonParent(node6,node6,node6);
        System.out.println(commonNode.value);

    }


    //求二叉搜索树的公共节点
    static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        if (root == null)
            return root;

        if (root.value > p.value & root.value > q.value) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.value < p.value & root.value < q.value) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }


    static List<List<BinaryTreeNode>> binaryTreeAllPath(List<BinaryTreeNode> binaryTreeNodeList) {
        if (binaryTreeNodeList == null || binaryTreeNodeList.isEmpty()) return null;

        BinaryTreeNode lastNode = binaryTreeNodeList.get(binaryTreeNodeList.size() - 1);
        List<List<BinaryTreeNode>> leftListList = null;
        if (lastNode.left != null) {
            List leftList = new ArrayList<BinaryTreeNode>();
            leftList.addAll(binaryTreeNodeList);
            leftList.add(lastNode.left);

            leftListList = binaryTreeAllPath(leftList);
        }

        List<List<BinaryTreeNode>> rightListList = null;
        if (lastNode.right != null) {
            List rightList = new ArrayList<BinaryTreeNode>();
            rightList.addAll(binaryTreeNodeList);
            rightList.add(lastNode.right);

            rightListList = binaryTreeAllPath(rightList);
        }

        List<List<BinaryTreeNode>> newList = new ArrayList<List<BinaryTreeNode>>();
        if (leftListList != null)
            newList.addAll(leftListList);

        if (rightListList != null)
            newList.addAll(rightListList);

        if (leftListList == null && rightListList == null) {
            newList.add(binaryTreeNodeList);
        }

        return newList;
    }


    //求一棵有公共节点树的2个节点的公共节点 辅助 0(n2)
    static BinaryTreeNode lowestCommonAncestor(List<List<BinaryTreeNode>> binaryTreeNodeListList, BinaryTreeNode p, BinaryTreeNode q) {
        if (binaryTreeNodeListList == null || binaryTreeNodeListList.isEmpty())
            return null;

        for (List<BinaryTreeNode> pL : binaryTreeNodeListList) {

            if (!pL.contains(p)) continue;

            for (List<BinaryTreeNode> qL : binaryTreeNodeListList) {
                if (!qL.contains(q)) continue;

                BinaryTreeNode pBeforeNode = findBeforeNode(pL, p);
                BinaryTreeNode qBeforeNode = findBeforeNode(qL, q);
                if (pBeforeNode.value == qBeforeNode.value) return pBeforeNode;
            }

        }
        return null;
    }


    static BinaryTreeNode findBeforeNode(List<BinaryTreeNode> list, BinaryTreeNode binaryTreeNode) {
        BinaryTreeNode beforeNode = null;
        for (BinaryTreeNode node : list) {
            if (node == binaryTreeNode) return beforeNode;
            beforeNode = node;
        }
        return beforeNode;

    }



    //辅助空间 0(n)
    static BinaryTreeNode getCommonParent(BinaryTreeNode pRoot, BinaryTreeNode p, BinaryTreeNode q) {
        if (pRoot == null || p == null || q == null || ((pRoot == p) && (pRoot == q)) ) return null;

        List<BinaryTreeNode> pPath = new ArrayList<>();
        boolean pFound = getNodePath(pRoot, p, pPath);

        List<BinaryTreeNode> qPath = new ArrayList<>();
        boolean qFound = getNodePath(pRoot, q, qPath);

        if (pFound & qFound) {
            BinaryTreeNode commontNode = getCommonNode(pPath, qPath);
            return commontNode;
        }else {
            return null;
        }
    }

    private static BinaryTreeNode getCommonNode(List<BinaryTreeNode> pPath, List<BinaryTreeNode> qPath) {
        if (pPath == null || pPath.isEmpty() || qPath == null || qPath.isEmpty()) return null;
        BinaryTreeNode commonTreeNode = null;

        int i = 0;
        while (i < pPath.size() && i < qPath.size()) {
            if (pPath.get(i) == qPath.get(i)) {
                    commonTreeNode = pPath.get(i);
            }
            i++;
        }
        return commonTreeNode;
    }

    private static boolean getNodePath(BinaryTreeNode pRoot, BinaryTreeNode p, List<BinaryTreeNode> pPath) {
        if ( pRoot == p )return true;

        pPath.add(pRoot);
        boolean found = false;
        if (pRoot.left != null && !found) {
            found = getNodePath(pRoot.left, p, pPath);
        }

        if (pRoot.right != null && !found) {
            found = getNodePath(pRoot.right, p, pPath);
        }

        if (!found){
            pPath.remove(pPath.size()-1);
        }
     return  found;
    }


}
