package Day7;

import java.util.Stack;

/**
 * ClassName: LeetCode42
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-07 - 18:37
 * @Version: v1.0
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * */
public class LeetCode42 {
    public int trap(int[] height) {
        int answer = 0;
        // 只有两根柱子，必然无法形成一个凹槽，那么水的面积就是 0
        if(height.length<=2){
            return answer;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i<height.length;i++){
            // 如果栈为空，那么直接把当前索引加入到栈中
            if(stack.isEmpty()){
                stack.push(i);
                // 情况一：此时的元素小于栈顶元素，凹槽的右侧不存在，无法形成凹槽
                // 情况二：此时的元素等于栈顶元素，也是无法形成凹槽
            }else if(height[stack.peek()]>=height[i]){
                stack.push(i);
            }else{
                // 情况三：此时的的元素大于栈顶元素，有可能形成凹槽
                // 注意是有可能形成，因为比如栈中的元素是 2 、2 ，此时的元素是 3，那么是无法形成凹槽的
                // 由于栈中有可能存在多个元素，移除栈顶元素之后，剩下的元素和此时的元素也有可能形成凹槽
                // 因此，我们需要不断的比较此时的元素和栈顶元素
                // 此时的元素依旧大于栈顶元素时，我们去计算此时的凹槽面积
                // 借助 while 循环来实现这个操作
                while (!stack.isEmpty() && height[stack.peek()]<height[i]){
                    int bottom = height[stack.pop()];
                    if (!stack.isEmpty()){
                        int h = Math.min(height[stack.peek()],height[i])-bottom;
                        int w = i-stack.peek()-1;
                        answer += h*w;
                    }
                }
                stack.push(i);
            }
        }

        return answer;
    }

}
