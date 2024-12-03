package Arrays;

import static Arrays.RotatingAnArray.reverse;

public class NextPermutation {
    public static void main(String[] args){
        int[] arr = { 2, 4, 1, 7, 5, 0 };
        int n = arr.length;
        int pivot = -1;

        for(int i = n-2; i > 0 ; i--) {
            if(arr[i] < arr[i+1]){
                pivot = i;
                break;
            }
        }

        if(pivot == -1){
            reverse(arr,0,n-1);
        }else{
            for(int i = n-1 ; i > pivot; i--) {
                if(arr[i] > arr[pivot]){

                }
            }
        }
    }

}

