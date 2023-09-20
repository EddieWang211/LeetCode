package Day8;

import java.util.Stack;

/**
 * ClassName: LeetCode232
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-08 - 0:17
 * @Version: v1.0
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 *
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可
 */
public class LeetCode232 {

}
class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public  MyQueue() {
        //模拟进队列
         stack1 = new Stack<>();
        //模拟出队列
        stack2 = new Stack<>();

    }

    public void push(int x) {
        //将元素放入队列1中即可
        stack1.push(x);
    }

    public int pop() {
        //如果队列2是空的，就将队列1中的元素全部倒进来，再调用队列2的pop（）方法
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
