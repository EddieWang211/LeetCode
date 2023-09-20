package Day7;

import java.util.Stack;

/**
 * ClassName: LeetCode84
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-06 - 18:39
 * @Version: v1.0
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 */
public class LeetCode84 {
    public static void main(String[] args) {
       int a = largestRectangleArea(new int[]{2,1,5,6,2,3,4,5});
        System.out.println(a);
    }

    public static int largestRectangleArea(int[] heights) {

        // 初始化最终结果为0
        int answer = 0;

        int n = heights.length;

        // 将给定的原数组左右各添加一个元素0，方便处理
        int newheights [] = new int[n+2];
        newheights[0] = 0;
        newheights[n+1] = 0;
        // 使用单调栈
        Stack<Integer> stack = new Stack<>();
        for(int i = 1;i<n+1;i++){
            newheights [i] = heights[i-1];
        }
        // 整体思路：
        // 对于一个高度，如果能得到向左和向右的边界
        // 那么就能对每个高度求一次面积
        // 遍历所有高度，即可得出最大面积
        for (int i = 0;i<n+2;i++){
            // 如果栈不为空且当前考察的元素值小于栈顶元素值，
            // 则表示以栈顶元素值为高的矩形面积可以确定
            while (!stack.isEmpty() && newheights[stack.peek()]>newheights[i] ){
                int cur = stack.pop();
                int high = newheights[cur];
                int weight = i-stack.peek()-1;
                int area = high * weight;
                answer = Math.max(answer,area);

            }
            stack.push(i);
        }

        return answer;
    }

}