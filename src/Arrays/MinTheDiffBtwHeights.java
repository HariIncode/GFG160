package Arrays;

import java.util.Arrays;

public class MinTheDiffBtwHeights {
    public static void main(String[] args){
        int k = 6;
        int[] arr = {12, 6, 4, 15, 17, 10};
        int n = arr.length;

        Arrays.sort(arr);
        int res = arr[n - 1] - arr[0];

        for(int i = 1; i < n; i++) {

            if (arr[i] - k < 0) continue;

            // Minimum height after modification
            int minH = Math.min(arr[0] + k, arr[i] - k);

            // Maximum height after modification
            int maxH = Math.max(arr[i - 1] + k, arr[n - 1] - k);

            // Store the minimum difference as result
            res = Math.min(res, maxH - minH);
        }
        System.out.println(res);
    }
}
