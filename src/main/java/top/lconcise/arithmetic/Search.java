package top.lconcise.arithmetic;

/**
 * 二分查找。
 *
 * @author: liusj
 * @date: 2022/5/11
 */
public class Search {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 2, 2, 2, 3, 4, 5, 6, 7, 9};

        System.out.println(bSearch02(array, 2));
    }

    // 二分查找，有序且存在重复元素，查找第一个出现的元素
    public static int bSearch02(int[] array, int val) {
        return bSearchInternally02(array, 0, array.length - 1, val);
    }

    private static int bSearchInternally02(int[] array, int low, int high, int val) {
        if (low > high) return -1;

        int mid = (low + high) / 2;

        if (val > array[mid]) {
            low = mid + 1;
            return bSearchInternally02(array, low, high, val);
        } else if (val < array[mid]) {
            high = mid - 1;
            return bSearchInternally02(array, low, high, val);
        } else if (val == array[mid]) {
            if (0 == mid || array[mid - 1] != val) {
                return mid;
            } else {
                high = mid - 1;
                return bSearchInternally02(array, low, high, val);
            }
        }
        return -1;
    }

    // 二分查找，适用于有序且不重复的数组
    public static int bSearch(int[] a, int val) {
        return bSearchInternally(a, 0, a.length - 1, val);
    }

    private static int bSearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] > value) {
            high = mid - 1;
            return bSearchInternally(a, low, high, value);
        } else {
            low = mid + 1;
            return bSearchInternally(a, low, high, value);
        }
    }
}
