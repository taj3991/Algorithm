package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/13.
 */
public class Question15 {


    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node node = findKthToTail(node1, 4);

        if (node != null)
            System.out.println(node.value);

        //Node.printFromHead(node2);

    }


    static Node findKthToTail(Node head, int k) {
        if ( head == null  || k <=0 )return  null;

        Node pNode = head;
        int i = 2;
        while (i <= k) {
            pNode = pNode.next;
            i++;
            if (pNode == null) {
                return null;
            }
        }

        while (pNode.next != null) {
            pNode = pNode.next;
            head = head.next;
        }
        return head;
    }

}
