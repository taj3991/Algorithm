package InterviewClassics;
import jianzhiOffer.Node;

/**
 * Created by tangjian on 2017/1/10.
 */
public class Question2_5 {

    public static void main(String[] args) {


        Node _1  = new Node(1);
        Node _2  = new Node(2);
        Node _3  = new Node(3);
        Node _4  = new Node(4);
        Node _5  = new Node(5);
        Node _6  = new Node(6);
        Node _7  = new Node(7);
        Node _8  = new Node(8);
        Node _9  = new Node(9);

        _7.next = _1;
        _1.next = _6;

        _5.next = _9;
        _9.next = _2;



        Node node = sum(_7,_5);
        Node.printFromHead(node);
    }

    static  Node sum(Node head1,Node head2){
        int carryNumber = 0;
        Node p1 = head1;
        Node p2 = head2;
        Node currentNode = null;
        Node headNode = null;
        while(p1!=null || p2 !=null){
            Node node = new Node();
            int i = 0;
            int j = 0;
            int value= 0;
            if (p1!=null){
              i = p1.value;
                p1 = p1.next;
            }
            if (p2 != null){
                j = p2.value;
                p2 = p2.next;
            }
            value = i+j+carryNumber;
            if (value>=10){
                carryNumber = 1;
                value = value-10;
            }else{
                carryNumber = 0;
            }
            node.value = value;

            if (currentNode == null){
                currentNode = node;
                headNode = node;
            }else{
                currentNode.next = node;
                currentNode = node;
            }


        }

        if (carryNumber > 0){

            Node node = new Node();
            node.value = carryNumber;
            currentNode.next  = node;
        }

        return headNode;
    }
}
