package InterviewClassics;

import jianzhiOffer.Node;

import java.util.Stack;

/**
 * Created by tangjian on 2017/1/9.  vv
 */
public class Question2_7 {


    public static void main(String[] args) {

        Node _1  = new Node(1);
        Node _2  = new Node(2);
        Node _3  = new Node(3);
        Node _4  = new Node(3);
        Node _5  = new Node(2);
        Node _6  = new Node(12);

        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;
        _5.next = _6;

        System.out.println(isPalindrome(_1,6).result);
        System.out.println(isPalindrome(_1));
        Node.printFromHead(reverseNode(_1));

    }
    static  Result isPalindrome(Node head,int length){

        if (head == null || length == 0){
            return new Result(null,true);
        }else if(length == 1){
            return new Result(head.next,true);
        }else if (length == 2){
            return  new Result(head.next.next,head.value == head.next.value);
        }
        Result res = isPalindrome(head.next,length-2);

        if (!res.result || res.node == null){
            return  res;
        }else{
            res.result = head.value == res.node.value;
            res.node = res.node.next;
            return res;
        }

    }

    static class  Result{
        Node node;
        boolean result;
        public Result(Node node,boolean result){
            this.node = node;
            this.result = result;
        }
    }


   static boolean isPalindrome(Node head){

       Node p1 = head;
       Node p2 = head;
       Stack<Integer> stack  = new Stack<>();
       while(p2!=null && p2.next!=null){
           stack.push(p1.value);
           p1 = p1.next;
           p2 = p2.next.next;   if (head == null) return false;
       }
       if (p2 != null){
           p1 = p1.next;
       }
       while(p1 != null){
           if (stack.pop() != p1.value)return false;
           p1 = p1.next;
       }
       return true;
   }

   static Node reverseNode(Node head){
       if (head == null) return null;

       Node pre = null;
       Node cur = head;

       while(cur != null){
           Node temp = cur.next;
           cur.next = pre;
           pre = cur;
           cur = temp;
       }
       return pre;
   }



}
