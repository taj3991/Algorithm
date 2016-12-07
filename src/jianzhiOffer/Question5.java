package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/7.
 */
public class Question5 {


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

      /*  ListNode head = reverseNode(node1);
        while (head != null){
            System.out.println(head.value);
            head = head.next;
        }*/

      printReversedNodeRecursively(node1);


    }


    /*
       Using recursion  to print the node
     * Print node
     * @param head
     */
    static void printReversedNodeRecursively(ListNode head){
        if (head != null ){
            if (head.next != null){
                printReversedNodeRecursively(head.next);
            }
            System.out.println(head.value);
        }
    }


    //Will update origin data structrue,So you should ask the interviewers can do this.
    static  ListNode reverseNode(ListNode head){
          if (head == null)return head;

        ListNode lastNode = head;
        ListNode curNode = head.next;

        //Remember set head.next to null.
        //After reversing,head node will become tail node.
        head.next = null;
        while( curNode != null){
            ListNode tmpNode = curNode.next;
            curNode.next = lastNode;
            lastNode = curNode;
            curNode = tmpNode;
        }
        return lastNode;

    }

    static class ListNode{
        int value;
        ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}
