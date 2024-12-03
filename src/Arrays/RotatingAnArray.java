package Arrays;

import java.util.Arrays;

public class RotatingAnArray {
    public static void main(String[] args){
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int d = 2;

//        method1(arr,d); //Running for loop d-times and swapping the first ele to last
//        method2(arr,d); //Creating a temp array and copying in single pass
        method3(arr,d); //By using Reversal Algorithm
        System.out.println(Arrays.toString(arr));
    }

    static void method1(int[] arr, int d){
        int n = arr.length;

        for(int i = 0; i < d; i++) {

            int first = arr[0]; //Taking the first ele of the array
            for(int j = 0; j < n-1; j++) {
                arr[j] = arr[j+1];
            }
            arr[n-1] = first;
        }
    }

    static void method2(int[] arr, int d){
        int n = arr.length;
        int[] temp = new int[n];
        //handle where d>n
        d %= n;

        for(int i = 0; i < n-d; i++) {
            temp[i] = arr[i+d];
        }

        for(int i = 0; i < d; i++) {
            temp[n -d +i] = arr[i];
        }

        System.arraycopy(temp,0,arr,0,n);
    }

    static void method3(int[] arr, int d){
        int n = arr.length;
        d %= n;

        // Reverse the first d elements
        reverse(arr,0,d-1);

        // Reverse the remaining n-d elements
        reverse(arr,d,n-1);

        //Reverse the entire array
        reverse(arr,0,n-1);
    }

    static void reverse(int[] arr,int start,int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
