package Arrays;

import java.util.Arrays;

import static Arrays.RotatingAnArray.reverse;

public class NextPermutation {
    public static void main(String[] args){
        int[] arr = { 2, 4, 1, 7, 5, 0 };
        int n = arr.length;
        int pivot = -1;

        System.out.println("Current Number"+Arrays.toString(arr));

        // find pivot by searching in rev
        for(int i = n-2; i > 0 ; i--) {
            if(arr[i] < arr[i+1]){
                pivot = i;
                break;
            }
        }

        if(pivot == -1){ // If there is no pivot then it is the last Permutation so rev the num to make the first sequence
            reverse(arr,0,n-1);
        }else{ // Find the num larger than pivot in the reverse
            for(int i = n-1 ; i > pivot; i--) {
                if(arr[i] > arr[pivot]){
                    swap(arr, pivot, i); // Swap them
                    break;
                }
            }
            reverse(arr, pivot+1, n-1); // Then reverse the Entire array to make the next permutation
        }
        System.out.println("Next Permutation"+Arrays.toString(arr));
    }
    public static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}

