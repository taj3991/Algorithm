package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/29.
 */
public class Question56 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next  = node6;
        node6.next = node3;

        Node meetingNode = findMeetingNode(node1);
        System.out.println(meetingNode.value);

        Node circleNode = findCircleEntranceNode(node1);
        System.out.println(circleNode.value);

    }

    static Node findCircleEntranceNode(Node head) {
        Node meetingNode = findMeetingNode(head);
        if (meetingNode == null) return null;

        int circleNodeNumber = 1;
        Node tempNode = meetingNode.next;

        while (tempNode != meetingNode) {
            tempNode = tempNode.next;
            circleNodeNumber++;
        }

        Node p1 = head;
        Node p2 = head;
        int i = 0;
        while (i < circleNodeNumber) {
            p2 = p2.next;
            i++;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }


    static Node findMeetingNode(Node head) {
        if (head == null) return null;
        Node p1 = head;
        if (p1.next == null) return null;

        Node p2 = p1.next;
        while (p1 != null && p2 != null) {
            if (p1 == p2.next) return p2;
            p1 = p1.next;

            p2 = p2.next;
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        return null;
    }

}
