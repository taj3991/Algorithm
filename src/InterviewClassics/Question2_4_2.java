package InterviewClassics;

import jianzhiOffer.Node;
/**
 * Created by tangjian on 2017/1/10.
 */
public class Question2_4_2 {


    public static void main(String[] args) {
        Node _1  = new Node(1);
        Node _2  = new Node(3);
        Node _3  = new Node(4);
        Node _4  = new Node(6);
        Node _5  = new Node(2);
        Node _6  = new Node(7);

        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;
        _5.next = _6;
        Node node = partition(_1,4);
        Node.printFromHead(node);

    }

    static Node partition(Node head,int k){

        Node beforeStart  = null;
        Node beforeEnd  = null;

        Node afterStart  = null;
        Node afterEnd  = null;

        Node p = head;
        while(p != null){
           if (p.value < k){
               if (beforeStart == null){
                   beforeEnd = beforeStart = p;
               }else{
                   beforeEnd.next = p;
                   beforeEnd = p;
               }

           }else{
               if (afterStart == null){
                   afterStart = afterEnd = p;
               }else{
                   afterEnd.next = p;
                   afterEnd = p;
               }

           }

            p = p.next;
        }

        if (beforeStart == null){
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;

    }




}
