package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/12.
 */
public class Node {

    int value;
    Node next;

    public Node(){

    }

    public Node( int value){
      this.value = value;
    }


    public static  void printFromHead(Node head){
        while(head != null){
            Node nextNode = head.next;
            if (nextNode!=null){
                System.out.println(head.value+" -> "+nextNode.value);
            }else{
                System.out.println(head.value+" -> null");
            }
            head = nextNode;
        }

    }
}
