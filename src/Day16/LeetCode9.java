package Day16;

/**
 * ClassName: LeetCode9
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-19 - 18:02
 * @Version: v1.0
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数
 */
public class LeetCode9 {
    public boolean isPalindrome(int x) {
        boolean answer = true;
        String s = x+"";
        int n = s.length();
        for (int i = 0; i < n/2; i++) {
            if (s.charAt(i)!=s.charAt(n-1-i)){
                answer =false;
            }
        }
        return answer;
    }
}
