package Day6;

import java.util.Scanner;
import java.util.Stack;

/*给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。
 * 注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef
 * */
public class LeetCode394 {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		decodeString(str);
	}
	/*逐位读取  设置一个数字栈和字符栈
	 * 四种情况
	 * 1.读到的是数字：注意数字的位数
	 * 2.读到的是字符
	 * 3.读到的是[：将数字和字符都分别入栈
	 * 4.读到的是]：将内层解码的结果拼接后再次入字符栈
	 * */
	public static String decodeString(String s) {
    	Stack<Integer> numstack = new Stack<Integer>();
    	Stack<String> strstack = new Stack<String>();
    	int n = s.length();
    	int dit = 0; //dit用来记录数字
    	String str = "";//str用来记录字符
    	for(int i = 0 ;i<n;i++ ){
    		char now = s.charAt(i);
    		if('0'<=now&&now<='9'){//当读取到的是数字时
    			int num = now - '0';
    			dit = dit*10+num;
    		}else if('a'<=now&&now<='z'){//当读取到的是字符时
    			str = str + now;
    		}else if(now == '['){//读取到的是左括号
    			numstack.push(dit);
    			strstack.push(str);
    			dit = 0;
    			str = "";
    		}else if(now == ']'){//读取到的是右括号
    			int count = numstack.pop();
    			String newstr = strstack.pop();
    			for(int j = 0;j<count;j++){
    				newstr+=str;
    			}
    			str = newstr;
    		}   		
    		
    	}
    	return str;
    }
}
