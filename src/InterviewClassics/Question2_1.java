package InterviewClassics;

import jianzhiOffer.Node;

import java.util.Hashtable;

/**
 * Created by tangjian on 2017/1/9.
 */
public class Question2_1 {


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

        removeRepeatNode(_1);

        Node.printFromHead(_1);
    }

    //Use extra space
    static void removeRepeatNodeUseExtraSpace(Node head){
        if (head == null)return;
        Hashtable<Integer,Boolean> hashtable = new Hashtable<>();
        Node previos = null;
        Node p = head;
        while ( p!= null){
            if (hashtable.get(p.value) != null){
                previos.next = p.next;
                Node temp = p.next;
                p = temp;
                temp.next = null;
            }else {
                hashtable.put(p.value,true);
                previos = p;
                p = p.next;
            }

        }
    }



    static void removeRepeatNode(Node head) {
        if (head == null)return;
        Node current = head;
        while (current!= null){
            Node runner = current;
            while(runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    }
