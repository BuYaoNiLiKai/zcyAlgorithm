package class01_sort;

public class Code05_EventTimesOddTimes {
    public static void printOddTimesNum1(int[] arr) {
        // 数组中只有一个数出现奇数次 其他都是偶数次 找出此数
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    public static void printOddTimesNum2(int[] arr) {
        // 数组中只有两种数出现奇数次 其他都是偶数次 找出这两个数
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        // eor = a^b
        int rightOne = eor & (~eor + 1); // 找出最右侧的1 其他位全为0
        int eor1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((rightOne & arr[i]) == 0) {
                //(rightOne &arr[i])==rightOne
                eor1 ^= arr[i];
            }
        }
        System.out.println(eor1 + " " + (eor ^ eor1));
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5};
        printOddTimesNum2(arr);
    }
}
