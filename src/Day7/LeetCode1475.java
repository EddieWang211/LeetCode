package Day7;
/*给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
 * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，
 * 其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，
 * 如果没有满足条件的 j ，你将没有任何折扣。
 * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
 * 输入：prices = [8,4,6,2,3]
 * 输出：[4,2,4,2,3]
 * 解释：
 * 商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
 * 商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
 * 商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
 * 商品 3 和 4 都没有折扣
 * */
/*单调栈，将prices从后向前遍历，如果栈里有元素比当前遍历到的元素小，就能够得到折扣，
 * 否则弹出栈顶元素，继续观察
 * */
import java.util.*;
public class LeetCode1475 {
    public int[] finalPrices(int[] prices) {
    	int n = prices.length;
    	int answer [] = new int [n];
    	Stack<Integer> stack = new Stack<>();
    	for(int i = n-1;i>=0;i--){
    		if(!stack.empty()){
    			while(!stack.empty()){
    				if(stack.peek()<=prices[i]){
    					answer[i]=prices[i]-stack.peek();
    					break;
    				}else{
    					stack.pop();
    				}
    			}
    		}
    		if(stack.isEmpty()){
    			answer[i]=prices[i];
    		}
    		stack.push(prices[i]);
    	}
    	return answer;
    }
}
