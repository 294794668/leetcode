package algorithm.basic;

import java.util.Arrays;

/**
 * @author pengfei.cheng
 * 冒泡排序算法
 * @since 2019/10/18 下午5:39
 */
public class ArraySort {

    /**
     * 冒泡排序
     * (1)比较前后相邻的二个数据，如果前面数据大于后面的数据，就将这二个数据交换。
     * (2)这样对数组的第 0 个数据到 N-1 个数据进行一次遍历后，最大的一个数据就“沉”到数组第 N-1 个位置。
     * (3)N=N-1，如果 N 不为 0 就重复前面二步，否则排序完成。
     */
    public static void bubbleSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int e = array[j];
                    array[j] = array[i];
                    array[i] = e;
                }
            }
        }
    }

    /**
     * 插入排序
     * 通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应的位置并插入。
     */
    public static void insertionSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int insertVal = array[i];
            int j = i - 1;
            while (j >= 0 && insertVal < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = insertVal;
        }
    }

    /**
     * 快速排序
     * 选择一个关键值作为基准值。比基准值小的都在左边序列(一般是无序的)，
     * 比基准值大的都在右边(一般是无序的)。一般选择序列的第一个元素。
     */
    public static void quickSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        quickSort(array, 0, array.length - 1);

    }

    public static void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int m = low, n = high, basic = array[m], index = m;
        boolean flag = true;
        while (m < n) {
            if (flag) {
                if (array[n] < basic) {
                    flag = false;
                    array[index] = array[n];
                    index = n;
                }
                n--;
            } else {
                if (array[m] > basic) {
                    flag = true;
                    array[index] = array[m];
                    index = m;
                }
                m++;
            }

        }
        array[index] = basic;
        quickSort(array, low, index - 1);
        quickSort(array, index + 1, high);
    }


    //快速排序
    public static void quick_sort(int s[], int l, int r) {
        if (l < r) {
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j)
                    s[i++] = s[j];

                while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 9, 7, 6, 5, 5, 5, 4, 3, 2, 1, 5, 0};
        System.out.println(Arrays.toString(array));
        ArraySort.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
