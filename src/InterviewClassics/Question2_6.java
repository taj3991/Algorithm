package InterviewClassics;

import jianzhiOffer.Node;

/**
 * Created by tangjian on 2017/1/10.
 */
public class Question2_6 {

    public static void main(String[] args) {

        Node _1  = new Node(1);
        Node _2  = new Node(2);
        Node _3  = new Node(3);
        Node _5  = new Node(5);
        Node _6  = new Node(6);

        _1.next = _2;
        _2.next = _3;        Node _4  = new Node(4);

        _3.next = _4;
        _4.next = _5;
        _5.next = _6;
        _6.next = _4;

        Node node = findBegining(_1);
        System.out.println(node.value);

    }

    static Node findBegining(Node head){
        if (head == null)return null;

        Node fast = head;
        Node slow = head;

        while(fast != null && slow != null){
            fast  = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        if (fast == null ) return  null;

        slow = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return  fast;
    }
}
