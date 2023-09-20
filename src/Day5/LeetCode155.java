package Day5;

import java.util.Stack;

/*设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素
 * */

/*由于需要在常数时间内找到最小的元素，那么说明肯定是不能使用遍历，因为遍历是 O(n) 级别的时间，那么只能使用辅助空间进行存储，这是一种空间换时间的思想。
这里我们设置两个栈：普通栈和辅助栈。
1、push 操作
普通栈：直接添加 push 进来的值
辅助栈：每次 push 一个新元素的时候，将普通栈中最小的元素 push 进辅助栈中
2、pop 操作
普通栈：直接移除普通栈中的栈顶元素
辅助栈：判断普通栈中刚刚移除的栈顶元素值是否和此时辅助栈中的栈顶元素相同，
如果是则将辅助栈中的栈顶元素移除，否则不执行操作，这样的目的是为了让辅助栈中的栈顶元素始终是普通栈中的最小值。
3、top 操作
普通栈：返回普通栈的栈顶元素
辅助栈：不执行操作
4、getMin 操作
普通栈：不执行操作
辅助栈：返回辅助栈的栈顶元素
 * */
public class LeetCode155 {
	
}
class MinStack {
	Stack<Integer> minstack;
	Stack<Integer> stack;
    public MinStack() {
    	minstack = new Stack<Integer>();
    	stack = new Stack<Integer>();
    }
    
    public void push(int val) {
    	stack.push(val);
    	if(minstack.isEmpty()){
    		minstack.push(val);
    	}else{
    		if(val<=minstack.peek()){
    			minstack.push(val);
    		}
    	}
    }
    
    public void pop() {
    	if(stack.pop().equals(minstack.peek())){
    		minstack.pop();
    	}
    }

    
    public int top() {
    	return stack.peek();
    }
    
    public int getMin() {
    	return minstack.peek();
    }
}
