package top.lconcise.leetcode;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 *
 * @author: liusj
 * @date: 2022/6/15
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
        System.out.println(reverseLeftWords02("abcdefg", 2));
    }

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public static String reverseLeftWords(String s, int n) {
        if (n == 0) return s;
        char[] chars = s.toCharArray();
        char[] temp = new char[n];
        for (int i = 0; i < n; i++) {
            temp[i] = chars[i];
        }
        int i = n, j = 0;
        for (; i < chars.length; i++, j++) {
            chars[j] = chars[i];
        }
        for (int k = 0; j < chars.length; j++, k++) {
            chars[j] = temp[k];
        }

        return new String(chars);
    }
    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public static String reverseLeftWords02(String s, int n) {
        return (s + s).substring(n, s.length() + n);
    }
}
