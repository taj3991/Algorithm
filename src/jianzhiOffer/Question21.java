package jianzhiOffer;

import java.util.Stack;

/**
 * Created by tangjian on 2016/12/16.
 */
public class Question21 {

    static Stack<Integer> stack = new Stack();
    static  Stack<Integer> minStack = new Stack();

    public static void main(String[] args) {


        push(2);
        push(3);
        push(1);



        System.out.println(min());
        System.out.println(pop());
        System.out.println(min());
        System.out.println(pop());
        System.out.println(pop());
    }

    static  void push(int value){

         boolean empty = minStack.empty();
        if(empty || minStack.peek() > value){
            minStack.push(value);
        }else{
            minStack.push(minStack.peek());
        }

         stack.push(value);
    }



    static  int min(){
        return  minStack.peek();
    }

    static int pop(){
        minStack.pop();
        return stack.pop();
    }




}
