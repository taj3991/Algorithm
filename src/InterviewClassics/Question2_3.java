package InterviewClassics;

import jianzhiOffer.Node;

/**
 * Created by tangjian on 2017/1/9.
 */
public class Question2_3 {


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

        deleteMiddleNode(_3);
        Node.printFromHead(_1);
    }
    static  void deleteMiddleNode(Node middleNode){
        if (middleNode == null)return;
        if (middleNode.next == null)return;

        Node mNext = middleNode.next;
        middleNode.value = mNext.value;
        middleNode.next = mNext.next;
    }
}
