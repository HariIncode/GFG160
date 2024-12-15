package Arrays;

public class MaximumSubArraySum {
    public static void main(String[] args){
        int[] arr = {2, 3, -8, 7, -1, 2, 3};

//        System.out.println(method1(arr)); // Brute Force
        System.out.println(method2(arr)); // Kadane Algo
    }

    static int method1(int[] arr){
        int res = 0;

        for(int i = 0; i < arr.length; i++) {
            int currSum = 0;

            for(int j = i; j < arr.length; j++) {
                currSum += arr[j];

                res = Math.max(res, currSum);
            }
        }
        return res;
    }

    static int method2(int[] arr){
        int res = 0;
        int maxEnd = arr[0];

        for(int i = 1; i < arr.length; i++) {
            maxEnd = Math.max(arr[i], maxEnd + arr[i]);

            res = Math.max(res,maxEnd);
        }

        return res;
    }
}
