package Sorting;

import java.util.Arrays;

import static Arrays.NextPermutation.swap;

public class Sort012 {
    public static void main(String[] args){
        int[] arr = {0, 2, 1, 0, 0, 1, 1, 1, 2, 1, 0, 0, 2, 2};

        sort012(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort012(int[] arr) {
        int low = 0, mid = 0, high = arr.length -1;

        while(mid<=high){
            switch (arr[mid]) {
                case 0 -> {
                    swap(arr, low, mid);
                    mid++;
                    low++;
                }
                case 1 -> mid++;
                case 2 -> {
                    swap(arr, mid, high);
                    high--;
                }
            }
        }
    }
}
