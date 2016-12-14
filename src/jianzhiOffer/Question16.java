package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/14.
 */
public class Question16 {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        reverseList(node1);

        Node.printFromHead(node4);
    }


    static Node reverseList(Node head) {
        Node reverseHead = null;
        Node pre = null;
        Node pCur = head;
        Node pNext = null;
        while (pCur != null) {
            pNext = pCur.next;
            if (pNext == null) {
                reverseHead = pCur;
            }
            pCur.next = pre;

            pre = pCur;
            pCur = pNext;
        }

        return reverseHead;

    }


}
