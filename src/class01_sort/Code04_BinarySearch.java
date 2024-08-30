package class01_sort;

public class Code04_BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        // 在一个有序数组中 找定target的下标 若不存在 返回-1
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; //防止溢出
            if (arr[mid] < target) {
                left = mid + 1;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            }
            if (arr[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    public static int findLeftValue(int[] arr, int target) {
        //在一个有序数组中，找>=某个数最左侧的位置
        // 例如 1 1 2 2 3 3 3 4 4 4 5 5 5 5 5 target=3 返回4
        if (arr == null || arr.length == 0 || arr[arr.length - 1] < target) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int findRightValue(int[] arr, int target) {
        //在一个有序数组中，找<=某个数最右侧的位置
        // 例如 1 1 2 2 3 3 3 4 4 4 5 5 5 5 5 target=3 返回6
        if (arr == null || arr.length == 0 || arr[0] > target) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static int findLocalMin(int[] arr) {
        // 给定array为无序数组，且任意相邻的两个数不相等 给出局部最小值
        if (arr == null || arr.length < 2) {
            return -1;
        }
        // 检查开头和结尾
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        // 开头和结尾均不符合 则中间必存在局部最小值 结合函数图像来看 两头向下凹
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) >> 1;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] > arr[mid - 1]) {
                right = mid;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr1 = {1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5};
        System.out.println(binarySearch(arr, 10));
        System.out.println(findLeftValue(arr1, 4));
        System.out.println(findRightValue(arr1, 4));
    }
}
