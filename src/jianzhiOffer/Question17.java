package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/14.
 */
public class Question17 {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.next = node3;
        node3.next = node5;

        node2.next = node4;
        node4.next = node6;



        Node.printFromHead(mergeNodeList(node1,node2));
    }

    static  Node mergeNodeList(Node node1Head,Node node2Head){
        if (node1Head == null) return node2Head;
        else if (node2Head == null) return node1Head;

        Node mergeNodeListHead  = null;

        if (node1Head.value < node2Head.value) {
            mergeNodeListHead = node1Head;
            mergeNodeListHead.next = mergeNodeList(node1Head.next,node2Head);
        }
        else {
            mergeNodeListHead  = node2Head;
            mergeNodeListHead.next = mergeNodeList(node1Head,node2Head.next);

        }

        return  mergeNodeListHead;

    }
}
