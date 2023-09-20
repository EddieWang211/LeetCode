package Day14;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LeetCode1124
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-20 - 12:03
 * @Version: v1.0
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 *
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 *
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 *
 * 请你返回「表现良好时间段」的最大长度。
 *
 * 示例 1：
 *
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 * 示例 2：
 *
 * 输入：hours = [6,6,6]
 * 输出：0
 */
public class LeetCode1124 {
    public int longestWPI(int[] hours) {
        int max = 0;
        Map<Integer,Integer>map = new HashMap<>();
        int presum = 0;
        for (int i = 0; i < hours.length; i++) {
            presum +=hours[i]>8?1:-1;
            if (presum>0){
                max = i+1;
            }else {
                map.putIfAbsent(presum, i);
                if (map.containsKey(presum-1)){
                    int j = map.get(presum-1);
                    int inter = i -j;
                    max = Math.max(inter,max);
                }

            }

        }
        return max;
    }
}
