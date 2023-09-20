package Day5;

import java.util.Stack;

/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 1.左括号必须用相同类型的右括号闭合。
 * 2.左括号必须以正确的顺序闭合。
 * 3.每个右括号都有一个对应的相同类型的左括号。
 * 输入：s = "()"
 * 输出：true
 * 输入：s = "(]"
 * 输出：false
 * */
public class LeetCode20 {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		if (s.length() % 2 == 1) {
			return false;
		}
		char charArray[] = s.toCharArray();
		int n = s.length();

		for (int i = 0; i < n; i++) {
			if (charArray[i] == '{' || charArray[i] == '[' || charArray[i] == '(') {
				stack.push(charArray[i]);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char c = stack.peek();
				if ((c == '[' && charArray[i] == ']') || (c == '(' && charArray[i] == ')')
						|| (c == '{' && charArray[i] == '}')) {
					stack.pop();
				}else{
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
}
