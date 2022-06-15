package top.lconcise.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * @author: liusj
 * @date: 2022/5/27
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int[] ints = twoNum02(nums, 6);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    /**
     * 暴力枚举
     *
     * 时间复杂度：O(N2),其中N为数组中元素数量，最坏情况数组中任意两个元素都要被匹配一次。
     * 空间复杂度：O(1)
     *
     */
    public static int[] twoNum(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    ++n;
                }
            }
        }
        return new int[0];
    }

    /**
     * 哈希表
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     */
    public static int[] twoNum02(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }

}
