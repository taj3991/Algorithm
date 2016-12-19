package jianzhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangjian on 2016/12/17.
 */
public class Question26 {


    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.next = node2;
        node1.nextSlibingNode = node2;

        node3.next = node4;
        node3.nextSlibingNode = node4;

        node2.next = node3;
        node2.nextSlibingNode = node3;

        node4.next = node5;
        node4.nextSlibingNode = node5;

        node5.next = node6;
        node5.nextSlibingNode = node6;


        cloneNodes(node1);
        //Node.printFromHead(node1);
        connectSlibingNode(node1);

        Node cloneHead = reconnectNode(node1);

        System.out.println(cloneHead == node1);

        Node.printFromHead(cloneHead);





    /*    Node root = cloneNodesUseExtraSpace(node1);
        Node.printFromHead(root);

        System.out.println(root.nextSlibingNode.value);

        System.out.println(root == node1);*/

    }



    static  Node cloneNodesUseExtraSpace(Node root){
        if (root == null ) return null;
        if (root.next == null ) {
                return  new Node();
        }

        Map<Node,Node> map = new HashMap<>();
        Node pNode = root;

        //复制节点
        while(pNode != null ){
            Node node = new Node(root.value);
            map.put(pNode,node);
            pNode = pNode.next;
        }


         pNode = root;
        //增加引用关系
        while(pNode != null ){
            Node node = map.get(pNode);
            node.next = pNode.next;
            node.nextSlibingNode = pNode.nextSlibingNode;
            pNode = pNode.next;
        }

        return map.get(root);

    }



    static  void  cloneNodes(Node head){
        Node pNode = head;
        //复制节点
        while(pNode != null ){
            Node cloneNode = new Node(pNode.value);
            cloneNode.next = pNode.next;
            pNode.next = cloneNode;
            pNode = cloneNode.next;
        }
    }

    static  void connectSlibingNode(Node head){
        Node pNode = head;
        //复制节点
        while(pNode != null ){
            Node cloneNode = pNode.next;
            if ( pNode.nextSlibingNode != null)
            cloneNode.nextSlibingNode = pNode.nextSlibingNode.next;
            pNode = pNode.next;
        }

    }


    static  Node reconnectNode(Node head){
        if(head == null) return null;

        Node pNode = head;
        Node cloneNodeHead = pNode.next;

        while(pNode != null) {
            Node cloneNode = pNode.next;
            pNode.next = cloneNode.next;
            pNode = pNode.next;

            if (pNode == null ){
                cloneNode .next = null;
                break;
            }
            cloneNode.next = pNode.next;
        }

        return  cloneNodeHead;
    }










}
