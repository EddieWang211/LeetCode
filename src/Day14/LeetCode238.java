package Day14;

/**
 * ClassName: LeetCode238
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-18 - 0:39
 * @Version: v1.0
 *
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
 *
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 *
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 */
public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
    //offer66的进阶版本 使用O（1）的时间复杂度解决问题
        int [] answer = new int[nums.length];
        answer[0] = 1;
        for (int i = 1;i<answer.length;i++){
            answer[i] = answer[i-1]*nums[i-1];
        }
        int right = 1;
        for (int i = answer.length-1; i >=0 ; i--) {
            answer[i] *=right;
            right*=nums[i];
        }
        return answer;
    }
}
