package Day16;

/**
 * ClassName: LeetCode125
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-19 - 18:50
 * @Version: v1.0
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串
 */
public class LeetCode125 {
    public boolean isPalindrome(String s) {
    int n = s.length();
    int low = 0;
    int high = n-1;
    s=s.toLowerCase();
        while (low<high){
            while (low<high&&!Character.isLetterOrDigit(s.charAt(low))){
                low++;
            }
            while (low<high&&!Character.isLetterOrDigit(s.charAt(high))){
                high--;
            }
            if (low < high){
            if (s.charAt(low)!=s.charAt(high)){
                return false;
            }
            }
            low++;
            high--;

        }
        return true;
    }
}
