package JianZhiOffer;

import java.util.Stack;

public class QueueWithTwoStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty() && stack1.isEmpty()){
            return -1;
        }else if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                 stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else{
            return stack2.pop();
        }

    }
}
