package top.lconcise.leetcode;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * @author: liusj
 * @date: 2022/6/20
 */
public class Search {

    public static void main(String[] args) {
//        System.out.println(7 / 2);
        int[] nums = {2, 2};
        int[] nums02 = {1,2,3,3,3,4,5,6};

        System.out.println(search03(nums, 3));
        System.out.println(search03(nums02, 3));
    }

    /**
     * 暴力破解.
     */
    public int search(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                ++count;
            }
        }
        return count;
    }

    /**
     * 二分查找
     */
    public static int search02(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (nums[right] != target)
                    right--;
                else if (nums[left] != target)
                    left++;
                else
                    break;
            }
        }
        return right - left + 1;
    }

    public static int search03(int[] nums, int target) {
        int left = findLeft(nums, target);
        if(left == -1) return 0;
        int right = findRight(nums,target);
        return right-left +1;
    }

    public static int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if(target > nums[mid]){
                left = mid + 1;
            }else if(target < nums[mid]){
                right = mid -1;
            }else {
                right = mid;
            }
        }
        if(nums[left] == target){
            return left;
        }

        return -1;
    }

    public static int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right-left+1)/2;
            if(target >= nums[mid]){
                left = mid;
            }else if(target < nums[mid]){
                right = mid -1;
            }
        }
        if(nums[right] == target){
            return right;
        }

        return -1;
    }
}
