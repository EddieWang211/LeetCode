package Day9;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: LeetCode349
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-12 - 13:45
 * @Version: v1.0
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的w
 */
public class LeetCode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int [] answer = new int[nums1.length> nums2.length ? nums2.length : nums1.length];
        int cur = 0;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if(!set1.contains(nums1[i])){
                set1.add(nums1[i]);
            }
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if(set1.contains(nums2[i])&& !set3.contains(nums2[i])){
                set3.add(nums2[i]);
                answer[cur++]=nums2[i];
            }
        }
        int []answer2 = new int [cur];
        for (int i = 0; i < cur; i++) {
            answer2[i] = answer[i];
        }
        return answer2;
    }
}
