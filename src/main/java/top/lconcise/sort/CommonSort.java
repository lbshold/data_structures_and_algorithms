package top.lconcise.sort;

/**
 * @author: liusj
 * @date: 2022/4/13
 */
public class CommonSort {

    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};
        selectionSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * 冒泡排序。两两比较，大得往后放。
     * <p>
     * 时间复杂度：o(n2)
     * 空间复杂度：o(1)
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        if (array.length <= 1) return;

        for (int i = 0; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            // 没有数据交换，提前退出
            if (flag) return;
        }
    }

    /**
     * 插入排序。
     * <p>
     * 时间复杂度：o(n2)
     * 空间复杂度：o(1)
     *
     * @param array
     */
    public static void insertionSort(int[] array) {
        if (array.length <= 1) return;

        for (int i = 1; i < array.length; i++) {
            int val = array[i];
            int j = i - 1;
            // 查找要插入的位置并移动数据
            for (; j >= 0; j--) {
                if (array[j] > val) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = val;
        }
    }

    /**
     * 选择排序.
     * <p>
     * 时间复杂度：O(n2)
     * 空间复杂度：0(1)
     *
     * @param array
     */
    public static void selectionSort(int[] array) {
        if (array.length <= 1) return;

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            int j = i + 1;
            // 寻找最小值
            for (; j < array.length; j++) {
                if (array[minIndex] < array[j]) {
                    minIndex = j;
                }
            }
            // 交换
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }
}
