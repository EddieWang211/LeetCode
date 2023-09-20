package Day12;

import java.util.HashMap;

/**
 * ClassName: LeetCode1248
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-15 - 18:14
 * @Version: v1.0
 * 给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中 「优美子数组」 的数目。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1
 */
public class LeetCode1248 {
    //和同天的LeetCode560一个思路
    public int numberOfSubarrays(int[] nums, int k) {
        int number = 0;
        int answer = 0;
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,1);
        for (int i = 0;i<nums.length;i++){
            if (nums[i]%2 == 1){
                number++;
            }
            if (map.containsKey(number-k)){
                answer+=map.get(number-k);
            }
            map.put(number,map.getOrDefault(number,0)+1);
        }
        return answer;
    }
}
