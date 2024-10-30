package labw1d1.assignment_1_1;

// https://leetcode.com/problems/implement-stack-using-queues/description/

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue1;
	Queue<Integer> queue2;
	Queue<Integer> queueIn;
	Queue<Integer> queueOut;
	
	public MyStack() {
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
		queueIn = queue1;
		queueOut = queue2;
	}
	
	public void push(int x) {
		queueIn.add(x);
	}
	
	public int pop() {
		int num = queueIn.size() - 1;
		for (int i = 0; i < num; i++) {
			queueOut.add(queueIn.poll());
		}
		Queue<Integer> tmp = queueOut;
		queueOut = queueIn;
		queueIn = tmp;
		return queueOut.poll().intValue();
	}
	
	public int top() {
		int value = pop();
		queueIn.add(value);
		return value;
	}
	
	public boolean empty() {
		return queueIn.isEmpty();
	}
	
	public static void main(String[] args) {
		MyStack stack = new MyStack();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.pop());
		
	}
}
