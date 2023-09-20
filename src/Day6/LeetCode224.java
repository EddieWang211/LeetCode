package Day6;

import java.util.*;

/*给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
 * '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
 * 输入中不存在两个连续的操作符
 * 每个数字和运行的计算将适合于一个有符号的 32位 整数
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * */
public class LeetCode224 {
	 public int calculate(String s) {
	    	int left = 0;
	    	int right = 0;
	    	int sign = 1;
	    	int n = s.length();
	    	Stack<Integer> numstack = new Stack<>();
	    	Stack<Integer>  signstack = new Stack<>();
	    	for(int i = 0;i<n;i++){
	    		char now = s.charAt(i);
	    		if(now<='9'&&now>='0'){
	    			right = now - '0';
	    			while(i+1<n&&s.charAt(i+1)<='9'&&s.charAt(i+1)>='0'){
	    			i++;
	    			right = right*10+s.charAt(i)-'0';
	    			}
	    			left = left + right*sign;
	    		}else if(now=='+'){
	    			sign = 1;	
	    		}else if(now == '-'){
	    			sign = -1;
	    		}else if (now == '('){
	    			numstack.push(left);
	    			signstack.push(sign);
	    			sign = 1;
	    			left = 0;
	    		}else if(now == ')'){
	    			right = numstack.pop();
	    			sign = signstack.pop();
	    			left = right + left*sign;
	    		}else{
	                continue;
	            }
	    	}
	    	return left;
	    }
}
