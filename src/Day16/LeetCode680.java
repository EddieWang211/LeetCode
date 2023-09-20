package Day16;

/**
 * ClassName: LeetCode680
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-19 - 19:33
 * @Version: v1.0
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：s = "aba"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "abca"
 * 输出：true
 * 解释：你可以删除字符 'c' 。
 * 示例 3：
 *
 * 输入：s = "abc"
 * 输出：false
 */
public class LeetCode680 {
    //先跑一遍不用删除的 再用递归的方式算一遍需要删除一个元素的
    public boolean validPalindrome(String s) {
        boolean answer1 =true;
        int n = s.length();
        int low = 0;
        int high = n-1;

        while (low < high){
            if (s.charAt(low)==s.charAt(high)){
                low++;
                high--;
            }else {
                return method2(s,low+1,high)||method2(s,low,high-1);
            }
        }
        return true;

    }
    public boolean method2(String s,int low,int high){

        while (low<high){
            if (s.charAt(low)==s.charAt(high)){
                low++;
                high--;
            }else {
                return false;
            }
        }
        return true;

    }
}
