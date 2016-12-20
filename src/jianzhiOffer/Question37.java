package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/20.
 */
public class Question37 {

    public static void main(String[] args) {


        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.next = node2;
        node2.next = node3;
        node3.next =  node6;
        node6.next =  node7;


        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Node commomNode = findFirstCommonNode(node1,node4);

        System.out.println(commomNode.value);

    }





    static Node findFirstCommonNode(Node pHead1,Node pHead2){
        if (pHead1 == null || pHead2 == null)return null;

        int pLen1 = getNodeListLength(pHead1);
        int pLen2 = getNodeListLength(pHead2);

        int differ = Math.abs(pLen1-pLen2);

        if (pLen1 > pLen2){
           pHead1 = getNode(pHead1,differ);
        }else{
            pHead2 = getNode(pHead2,differ);
        }

        while(pHead1!= null && pHead2 != null && (pHead1 !=pHead2)){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }


        return  pHead1;
    }

    static  Node getNode(Node pHead,int differ){
        for (int i = 1 ; i <= differ; i++){
            pHead = pHead.next;
        }
        return  pHead;
    }

    static  private int getNodeListLength(Node pHead) {
        int len = 0;
        while( pHead != null){
            len ++;

            pHead = pHead.next;
        }
        return len;
    }


}
