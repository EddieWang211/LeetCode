package Day17;

/**
 * ClassName: LeetCode860
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-20 - 10:15
 * @Version: v1.0
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 * 示例 1：
 *
 * 输入：bills = [5,5,5,10,20]
 * 输出：true
 */
public class LeetCode860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i]==5){
                five++;
            }else if (bills[i]==10){
                if (five>0){
                    five--;
                    ten++;
                }else {
                    return false;
                }
            }else {
                if (five>0&&ten>0){
                    five--;
                    ten--;
                }else if (five>3){
                    five-=3;
                }else {
                    return false;
                }

            }
        }
        return true;
    }
}
