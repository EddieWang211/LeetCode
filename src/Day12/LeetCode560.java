package Day12;

import java.util.HashMap;

/**
 * ClassName: LeetCode560
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-15 - 13:36
 * @Version: v1.0
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [1,2,3], k = 3
 * 输出：
 */
public class LeetCode560 {
    public int subarraySum(int[] nums, int k) {
        int presum = 0;
        int answer = 0;
        HashMap<Integer,Integer>map = new HashMap<>();
        //利用哈希表来查询更快
        map.put(0,1);
        //哈希表中存放的是前缀和以及这个前缀和出现的次数
        for (int i = 0; i < nums.length; i++) {
            //一位位计算前缀和
            presum+=nums[i];
            //如果表中包含了presum - k，说明现在遍历到的这个前缀和减去之前存在的那个前缀和差为k，即中间存在一个子数组差为k
            if (map.containsKey(presum - k)){
                answer += map.get(presum-k);
            }
            //将现在遍历到的前缀和以及这个前缀和出现的次数存放到哈希表里
            map.put(presum, map.getOrDefault(presum,0)+1);
        }
        return answer;
    }

    //双层for循环会TLE
//    public int subarraySum1(int[] nums, int k) {
//        int prearr [] = new int[nums.length+1];
//        prearr[0] = 0;
//        int answer = 0;
//        for (int i = 0; i < nums.length; i++) {
//            prearr[i+1] = prearr[i]+nums[i];
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 1; j <=nums.length ; j++) {
//                if(i+j-1<nums.length){
//                    if (prearr[i+j]-prearr[i] == k){
//                        answer++;
//                    }
//                }
//            }
//        }
//        return answer;
//    }
}

