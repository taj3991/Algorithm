package jianzhiOffer;

import java.util.Stack;

/**
 * Created by tangjian on 2016/12/8.
 */
public class Question7 {
    static Stack stack1 = new Stack();
    static Stack stack2 = new Stack();

    public static void main(String[] args) {
        appendTail(1);
        appendTail(2);
        appendTail(3);
        Object value = deleteHead();
        appendTail(4);
        value = deleteHead();
        while(value != null){
            System.out.println(value+"\t");
            value = deleteHead();
        }

    }

    static void appendTail(Object item) {
        stack1.push(item);
    }

    static Object deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) return null;
        return stack2.pop();
    }


}
