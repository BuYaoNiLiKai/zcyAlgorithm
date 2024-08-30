package class01_sort;


public class Code07_SmallSum {
    public static int smallSum(int[] arr) {
        /* 小和问题 例如array 1 3 4 2 5
         * res: 0+1+(1+3)+1+(1+3+4+2) = 16 or
         * res: 1*4 + 3*2 +4*1 +2*1 +5*0 = 16
         * 能否设计出优于O(N^2)的 算法 O(N*logN)
         * */
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        return process(arr, left, mid)
                + process(arr, mid + 1, right)
                + merge(arr, left, mid, right);
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int[] helpArray = new int[right - left + 1];
        int leftIndex = left;
        int rightIndex = mid + 1;
        int index = 0;
        int sum = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            if (arr[leftIndex] < arr[rightIndex]) {
                sum += arr[leftIndex] * (right - rightIndex + 1);
                helpArray[index++] = arr[leftIndex++];
            } else {
                helpArray[index++] = arr[rightIndex++];
            }
        }
        while (leftIndex <= mid) {

            helpArray[index++] = arr[leftIndex++];
        }
        while (rightIndex <= right) {
            helpArray[index++] = arr[rightIndex++];
        }
        for (int i = 0; i < helpArray.length; i++) {
            arr[left + i] = helpArray[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr1 = {1, 3, 4, 2, 5};
        int res = smallSum(arr1);
        System.out.print(res);
    }

}
