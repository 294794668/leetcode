package algorithm.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author pengfei.cheng
 * 冒泡排序算法
 * @since 2019/10/18 下午5:39
 */
public class ArraySort {

    /**
     * 1.冒泡排序
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
     * 2.选择排序
     */
    public static void selectionSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int exchange = i;
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    exchange = j;
                }
            }
            if (exchange != i) {
                array[exchange] = array[i];
                array[i] = min;
            }
        }
    }

    /**
     * 3.插入排序
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
     * 4.快速排序
     * 选择一个关键值作为基准值。比基准值小的都在左边序列(一般是无序的)，
     * 比基准值大的都在右边(一般是无序的)。一般选择序列的第一个元素。
     */
    public static void quickSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        quickSort(array, 0, array.length - 1);

    }

    /**
     * 4.快速排序
     */
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

    /**
     * 4.快速排序
     */
    public static void quickSort1(int[] s, int l, int r) {
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
            quickSort1(s, l, i - 1); // 递归调用
            quickSort1(s, i + 1, r);
        }
    }

    /**
     * 5.希尔排序
     * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列
     * 中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
     */
    public static void shellSort(int[] array) {
        int n = array.length >>> 1;
        for (int i = n; i >= 1; i >>>= 1) {
            //间隔为i的插入排序
            for (int k = i; k < array.length; k++) {
                int insertVal = array[k];
                int l = k - i;
                while (l >= 0 && insertVal < array[l]) {
                    array[l + i] = array[l];
                    l -= i;
                }
                array[l + i] = insertVal;
            }
        }
    }

    /**
     * 6.归并排序
     * 将两个(或两个以上)有序表合并成一个新的有序表，即把待排序序列
     * 分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
     */
    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * 6.归并排序-拆分
     */
    public static void mergeSort(int[] array, int a, int b) {
        if (b - a > 1) {
            int split = (b + a) / 2;
            //超过3个元素 拆分
            mergeSort(array, a, split, split + 1, b);
        } else {
            //2个元素 排序
            if (array[b] < array[a]) {
                int i = array[a];
                array[a] = array[b];
                array[b] = i;
            }
        }
    }

    /**
     * 6.归并排序-排序
     */
    public static void mergeSort(int[] array, int a1, int a2, int b1, int b2) {
        mergeSort(array, a1, a2);
        mergeSort(array, b1, b2);
        int[] tmpArray = new int[b2 - a1 + 1];
        int i = 0;
        int l = a1;//左最小值
        int r = b1;//右最小值
        //最小值放入临时数组 直到末尾元素较小的数组放完
        while (l <= a2 && r <= b2) {
            if (array[l] > array[r]) {
                tmpArray[i++] = array[r++];
            } else {
                tmpArray[i++] = array[l++];
            }
        }
        //放完元素较大的末尾数组元素
        while (l <= a2) {
            tmpArray[i++] = array[l++];
        }
        while (r <= b2) {
            tmpArray[i++] = array[r++];
        }
        System.arraycopy(tmpArray, 0, array, a1, tmpArray.length);
    }

    /**
     * 7.桶排序
     * 把数组 arr 划分为 n 个大小相同子区间(桶)，每个子区间各自排序，最后合并。
     * 计数排序是桶排序的一种特殊情况，可以把计数排序当成每个桶里只有一个元素的情况。
     * a.找出待排序数组中的最大值 max、最小值 min
     * b.我们使用 动态数组 ArrayList 作为桶，桶里放的元素也用 ArrayList 存储。桶的数量为(max- min)/arr.length+1
     * c.遍历数组 arr，计算每个元素 arr[i] 放的桶
     * b.每个桶各自排序
     */
    public static void bucketSort(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int value : array) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        }
        //减去min 所以+1
        int length = (max - min) / array.length + 1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int value : array) {
            buckets.get((value - min) / array.length).add(value);
        }
        int i = 0;
        for (ArrayList<Integer> bucket : buckets) {
            //桶内元素排序——省略了
            Collections.sort(bucket);
            for (Integer integer : bucket) {
                array[i++] = integer;
            }
        }
    }

    /**
     * 8.基数排序
     * 将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
     * 然后，从最低位开始，依次进行一次排序。
     * 这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
     */
    public static void radixSort(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            max = Math.max(max, i);
        }
        int length = String.valueOf(max).length();
        for (int i = 0; i < length; i++) {
            ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>(10);
            for (int j = 0; j < 10; j++) {
                arrayLists.add(new ArrayList<>());
            }
            for (int value : array) {
                int key = value % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                arrayLists.get(key).add(value);
            }
            int count = 0;
            for (ArrayList<Integer> arrayList : arrayLists) {
                for (Integer integer : arrayList) {
                    array[count++] = integer;
                }
            }
        }

    }

    /**
     * 9.计数排序
     */
    public static void countingSort(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int value : array) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        }
        //1.根据待排序集合中最大元素和最小元素的差值范围，申请额外空间；
        int length = max - min + 1;
        int[] tmpArray = new int[length];
        //2.遍历待排序集合，将每一个元素出现的次数记录到元素值对应的额外空间内；
        for (int val : array) {
            //3.对额外空间内数据进行计算，得出每一个元素的正确位置；
            int key = val - min;
            tmpArray[key] = tmpArray[key] + 1;
        }
        int count = 0;
        //4.将待排序集合每一个元素移动到计算得出的正确位置上。
        for (int i = 0; i < tmpArray.length; i++) {
            int integer = tmpArray[i];
            while (integer-- != 0) {
                array[count++] = i + min;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 9, 7, 6, 5, 5, 5, 4, 3, 2, 1, 5, 0, 99};
        System.out.println(Arrays.toString(array));
        ArraySort.countingSort(array);
        System.out.println(Arrays.toString(array));
    }
}
