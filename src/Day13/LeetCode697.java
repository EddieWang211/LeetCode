package Day13;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LeetCode697
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-16 - 18:21
 * @Version: v1.0
 * 给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,3,1]
 * 输出：2
 * 解释：
 * 输入数组的度是 2 ，因为元素 1 和 2 的出现频数最大，均为 2 。
 * 连续子数组里面拥有相同度的有如下所示：
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组 [2, 2] 的长度为 2 ，所以返回 2
 */
public class LeetCode697 {
    public int findShortestSubArray(int[] nums) {
        //用一个长度为3的数组记录出现过的每个数字的相关信息
        //[0]:用来记录数字出现的次数 [1]：用来记录数字最开始出现的位置 [2]用来记录数字最后一次出现的位置
        Map<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }else{
                map.put(nums[i],new int[]{1,i,i});
            }
        }
        int maxnum = 0;
        int minlenth = 0;
        //将map逐位遍历，判断最大的出现频数和最短长度
        for(Map.Entry<Integer,int[]> entry: map.entrySet()){
            int []temp = entry.getValue();
            if(temp[0]>maxnum){
                maxnum = temp[0];
                minlenth = temp[2]-temp[1]+1;
            }else if (temp[0] == maxnum){
                minlenth = ((temp[2]-temp[1]+1)>minlenth)?minlenth:(temp[2]-temp[1]+1);
            }
        }
        return minlenth;
    }
}
