package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/29.
 */
public class Question57 {


    static Node deleteRepeateNode(Node head) {
        if (head == null) return null;
        Node pPreNode = null;
        Node pNode = head;
        while (pNode != null) {

            boolean needToBeDelete = false;
            Node pNodeNext = pNode.next;
            if (pNodeNext != null && pNode.value == pNodeNext.value) {
                needToBeDelete = true;
            }
            if (!needToBeDelete) {
                pPreNode = pNode;
                pNode = pNodeNext;
            } else {
                Node tobeDeleteNode = pNode;
                int value = pNode.value;
                while (tobeDeleteNode != null && tobeDeleteNode.value == value) {

                    pNodeNext = tobeDeleteNode.next;

                    tobeDeleteNode.next = null;
                    tobeDeleteNode = null;
                    tobeDeleteNode = pNodeNext;
                }
                if (pPreNode == null) {
                    head = pNodeNext;
                } else {
                    pPreNode.next = pNodeNext;
                }
                pNode = pNodeNext;

            }

        }
        return head;
    }

}
