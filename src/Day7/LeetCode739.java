package Day7;
/*给定一个整数数组temperatures，表示每天的温度，返回一个数组 answer ，
 * 其中answer[i]是指对于第 i 天，
 * 下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * */
import java.util.*;
public class LeetCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
    	int n = temperatures.length;
    	Stack<Integer> stack = new Stack<>();
    	int[] answer = new int [n];
    	for(int i = n-1;i>=0;i--){
    		while(!stack.isEmpty()){
    			if(temperatures[stack.peek()]<=temperatures[i]){
    				stack.pop();
    			}else{
    				answer[i]=stack.peek()-i;
    				break;
    			}
    		}
    		stack.push(i);
    	}
    	return answer;
    }
}
