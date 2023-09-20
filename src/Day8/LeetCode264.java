package Day8;

import java.util.*;

/**
 * ClassName: LeetCode264
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-09 - 18:15
 * @Version: v1.0
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 */
public class LeetCode264 {
    public int nthUglyNumber(int n) {


        PriorityQueue<Long> queue = new PriorityQueue<>();
        int factors[] = {2, 3, 5};
        Set<Long> set = new HashSet<>();
        set.add(1L);
        queue.offer(1L);
        int ugly = 1;
        for (int i = 0; i < n; i++) {
            long cur = queue.peek();
            ugly = (int)cur;
            for (int j = 0;j<3;j++){
                long next = factors[j]*cur;
                if(set.add(next)){
                    queue.offer(next);
                }
            }
        }
        return ugly;
    }
}
