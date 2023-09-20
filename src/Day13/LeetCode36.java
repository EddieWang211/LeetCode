package Day13;

/**
 * ClassName: LeetCode36
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-17 - 11:11
 * @Version: v1.0【
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 */
public class LeetCode36 {
    public boolean isValidSudoku(char[][] board) {
    int [][] rows = new int[9][9];
    int [][] columns = new int[9][9];
    int [][][]subboard = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c!='.'){
                    int num = c - '0' - 1;
                    rows[i][num]++;
                    columns[j][num]++;
                    subboard[i/3][j/3][num]++;
                    if (rows[i][num]>1||columns[j][num]>1||subboard[i/3][j/3][num]>1){
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
