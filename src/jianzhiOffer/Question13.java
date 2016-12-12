package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/12.
 */
public class Question13 {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        deleteNodeO1(node1,node4);

        Node.printFromHead(node1);
        //Node.printFromHead(node2);

    }

    static  void deleteNodeO1(Node head, Node tobeDelete){
        if (head == tobeDelete){
            Node headNext = head.next;
            head.next = null;
            head = headNext;
        }else if (tobeDelete.next == null){
            Node node = head;
            while(node.next != tobeDelete){
                node = node.next;
            }
            node.next = null;
        }else{
            tobeDelete.value = tobeDelete.next.value;
            Node tobeDeletNext = tobeDelete.next;
            tobeDelete.next = tobeDeletNext.next;
            tobeDelete.next = null;
        }


    }
}
