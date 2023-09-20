package Day6;

/*给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * */
import java.util.*;

public class LeetCode32 {
	public int longestValidParentheses(String s) {
		int start = 0;
		int n = s.length();
		int answer = 0;
		int length = 0;
		Stack<Integer> str = new Stack<>();
		for (int i = 0; i < n; i++) {
			char now = s.charAt(i);
			if (now == '(') {
				str.push(i);
			} else {
				if (str.isEmpty() == true) {
					start = i + 1;
				} else {
					str.pop();
					if (str.isEmpty()) {
						length = i - start+1;
					} else {
						length = i - str.peek();
					}

				}
			}
			if(length > answer){
				answer = length;
			}
		}
		return answer;
	}
}
