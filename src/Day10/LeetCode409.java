package Day10;

/**
 * ClassName: LeetCode409
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-19 - 18:00
 * @Version: v1.0
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 *
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 *
 * 示例 1:
 *
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 示例 2:
 *
 * 输入:s = "a"
 * 输出:1
 * 示例 3：
 *
 * 输入:s = "aaaaaccc"
 * 输出:7
 */
public class LeetCode409 {
    public int longestPalindrome(String s) {
        int []array = new int[58];
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i)-'A']++;
        }
        for (int i = 0; i < 58; i++) {
            answer +=array[i] - (array[i]&1);
        }
        return answer<s.length()? answer+1:answer;
    }
}
