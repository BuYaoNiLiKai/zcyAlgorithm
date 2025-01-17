package class06_violent_recursion;

import java.util.Stack;

public class Code05_ReverseStack {
	/*
	 * 逆序一个栈
	 * 分两步：
	 * 1、 把栈底元素拿出来 并且不破坏相应次序
	 * 2、 逆序剩余的栈
	 * 3、 放回栈底
	 */
	public static void reverseStack(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return ;
		}
		int i = f(stack);
		reverseStack(stack);
		stack.push(i);
	}
	public static int f(Stack<Integer> stack) {
		int result = stack.pop();
		if(stack.isEmpty()) {
			return result;
		}else {
			int last = f(stack);
			stack.push(result);
			return last;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer> ();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		for(int v:stack) {
			System.out.println(v);
		}
		reverseStack(stack);
//		while(!stack.isEmpty()){
//			System.out.println(stack.pop());
//		
//		}
		for(int v:stack) {
			System.out.println(v);
		}
	}

}
