package InterviewClassics;

import jianzhiOffer.Node;

/**
 * Created by tangjian on 2017/1/9.
 */
public class Question2_4 {

    public static void main(String[] args) {

        Node _1  = new Node(1);
        Node _2  = new Node(1);
        Node _3  = new Node(2);
        Node _4  = new Node(3);
        Node _5  = new Node(2);

        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;


        Node node = findLastKThNode(_1,5);
        System.out.println(node.value);
    }
    static  Node findLastKThNode(Node head, int k){
        if (head == null)return null;

        int i = 0 ;
        Node p2 = head;
        while(i < k && p2 !=null){
            p2 = p2.next;
            i++;
        }

        if (i != k){
            return null;
        }

        Node p1 = head;
        while(p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return  p1;
    }
}
