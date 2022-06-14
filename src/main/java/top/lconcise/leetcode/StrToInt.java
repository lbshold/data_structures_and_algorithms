package top.lconcise.leetcode;

/**
 * 剑指 Offer 67. 把字符串转换成整数
 *
 * @author: liusj
 * @date: 2022/6/13
 */
public class StrToInt {

    public static void main(String[] args) {
        String str = "-1";
        char[] chars = str.toCharArray();
        System.out.println(chars[0] == '-');
    }

    /**
     * 复杂度分析：
     *  时间复杂度：O(N), 其中N为字符串长度，线性遍历字符串占用0(N)时间。
     *  空间复杂度：O(N), 删除首位空格后需要建立新的字符串，最差情况占用O(N)额外空间。
     */
    public static int strToInt(String str) {
        // 空格、符号位、非数字字符/数字字符
        // 1. 去前后空格
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) return 0;
        // 记录第一个是否符合负数
        int sign = 1;
        // 开始遍历位置
        int i = 1;
        // 2. 符号位
        if (chars[0] == '-') {
            sign = -1;
        } else if (chars[0] != '+') {
            i = 0;
        }
        int number = Integer.MAX_VALUE / 10;
        // 3. 结果
        int res = 0;
        for (int j = i; j < chars.length; j++) {
            if (chars[j] > '9' || chars[j] < '0') break;

            // 判断是否越界
            if (res > number || (res == number && chars[j] > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (chars[j] - '0');
        }

        return res * sign;
    }
}
