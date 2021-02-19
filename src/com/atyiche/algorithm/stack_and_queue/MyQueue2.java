package com.atyiche.algorithm.stack_and_queue;

import java.util.Stack;

/**
 * @author liangyt
 * @create 2021-02-19 18:22
 */
public class MyQueue2 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //入队方法
    public void push(int x) {
        stack1.push(x);
    }

    //出队方法
    public int pop(){
        //1.判断stack2是否为空，如果为空，就要将stack1中的所有元素弹出，然后压入
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        //弹出stack2的栈顶元素
        return stack2.pop();
    }
    //弹出栈顶元素
    public int peek(){
        //1.判断stack2是否为空，如果为空，就要将stack1中的所有元素弹出，然后压入
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        //弹出stack2的栈顶元素
        return stack2.peek();
    }
    //判空
    public boolean empty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue2 myQueue = new MyQueue2();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }
}
