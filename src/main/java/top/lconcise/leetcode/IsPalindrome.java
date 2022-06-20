package top.lconcise.leetcode;

/**
 * 剑指 Offer II 018. 有效的回文
 *
 * @author: liusj
 * @date: 2022/6/20
 */
public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome02("race a car"));
    }

    /**
     * 使用字符串反转。
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public static boolean isPalindrome(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char charStr = s.charAt(i);
            if (Character.isLetterOrDigit(charStr)) {
                result.append(Character.toLowerCase(charStr));
            }
        }

        StringBuilder resultReverse = new StringBuilder(result).reverse();
        return result.toString().equals(resultReverse.toString());
    }

    /**
     * 双指针
     *
     * 时间复杂度：O(N)
     * 空间复杂度：0(N)
     */
    public static boolean isPalindrome02(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char charStr = s.charAt(i);
            if (Character.isLetterOrDigit(charStr)) {
                result.append(Character.toLowerCase(charStr));
            }
        }
        char[] chars = result.toString().toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
