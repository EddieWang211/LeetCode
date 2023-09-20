package Day13;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * ClassName: LeetCode496
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-16 - 22:52
 * @Version: v1.0
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 *
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 *
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 *
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 *
 * 示例 1：
 *
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1
 */
public class LeetCode496 {
    //单调栈和哈希表的综合。哈希表用来记录每个数字以及右边第一个比他大的数字

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer>map = new HashMap<>();
        int[]curnumber = new int [nums2.length];
        Stack<Integer>stack = new Stack<>();
        for (int i = nums2.length-1; i >=0; i--) {
            //栈中元素从上到下依次增大
            while (stack.isEmpty()||stack.peek()>=nums2[i]){
                stack.pop();
            }
            map.put(nums2[i],stack.isEmpty()?-1:stack.peek());
            stack.push(nums2[i]);
        }
        int answer [] =new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            answer[i]= map.get(nums1[i]);
        }
        return answer;
    }
}
