package top.lconcise.arithmetic;

/**
 * 二分查找
 *
 * @author: liusj
 * @date: 2022/5/11
 */
public class Search {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 9};

        System.out.println(bSearch(array, 2));
    }

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
