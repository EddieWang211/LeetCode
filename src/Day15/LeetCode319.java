package Day15;

/**
 * ClassName: LeetCode319
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-18 - 18:20
 * @Version: v1.0
 * 初始时有 n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。接下来的第二轮，你将会每两个灯泡关闭第二个。
 *
 * 第三轮，你每三个灯泡就切换第三个灯泡的开关（即，打开变关闭，关闭变打开）。第 i 轮，你每 i 个灯泡就切换第 i 个灯泡的开关。直到第 n 轮，你只需要切换最后一个灯泡的开关。
 *
 * 找出并返回 n 轮后有多少个亮着的灯泡。
 */
public class LeetCode319 {
    //没什么意思的数学归纳法，用数学归纳法证明第n轮后有floor(sqrt(n))个灯泡亮着

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
