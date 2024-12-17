package Arrays;

public class CircularSubArray {
    public static void main(String[] args){
        int[] arr = {8, -8, 9, -9, 10, -11, 12};

//        System.out.println(method1(arr)); // Brute force
//        System.out.println(method2(arr)); // Prefix sum
        System.out.println(method3(arr)); // Subtracting Minimum SubArray
    }
    static int method1(int[] arr){
        int res = arr[0];
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            int currSum = 0;

            for(int j = 0; j < n; j++) {
                int ind = (i + j) % n; // Circular index

                currSum = currSum + arr[ind];
                res = Math.max(res, currSum);
            }
        }

        return  res;
    }
    static int method2(int[] arr){
        /*
         In a circular array, the maximum SubArray sum can be either the maximum normal sum,
         which is the highest sum of a non-circular array, or the maximum circular sum,
         which includes elements from both the start and the end of the array.
         The normal sum can be efficiently calculated using Kadane's algorithm.
         And, the circular sum is calculated by combining prefix sum and suffix sum
         */

        int n = arr.length;
        int suffixSum = arr[n - 1];

        // maxSuffix array to store the value of
        // maximum suffix occurred so far.
        int[] maxSuffix = new int[n + 1];
        maxSuffix[n - 1] = arr[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            suffixSum = suffixSum + arr[i];
            maxSuffix[i] = Math.max(maxSuffix[i + 1], suffixSum);
        }

        // circularSum is Maximum sum of circular SubArray
        int circularSum = arr[0];

        // normalSum is Maximum sum SubArray considering
        // the array is non-circular
        int normalSum = arr[0];

        int currSum = 0;
        int prefix = 0;

        for(int i = 0; i < n; i++) {

            // Kadane's algorithm
            currSum = Math.max(currSum + arr[i], arr[i]);
            normalSum = Math.max(normalSum, currSum);

            // Calculating maximum Circular Sum
            prefix = prefix + arr[i];
            circularSum = Math.max(circularSum, prefix + maxSuffix[i + 1]);
        }

        return Math.max(circularSum, normalSum);
    }
    static int method3(int[] arr){
        int n = arr.length;
        int currMinSum = 0;
        int currMaxSum = 0;
        int maxSum = arr[0];
        int minSum = arr[0];
        int totalSum = 0;
        int res = 0;

        for (int i : arr) {
            currMaxSum = Math.max(currMaxSum + i, i);
            maxSum = Math.max(maxSum, currMaxSum);

            currMinSum = Math.min(currMinSum + i, i);
            minSum = Math.min(currMinSum, minSum);

            totalSum += i;
        }

        int normalSum = maxSum;
        int circularSum = totalSum - minSum;

        if(minSum == totalSum) return normalSum;

        return  Math.max(circularSum, normalSum);
    }
}
