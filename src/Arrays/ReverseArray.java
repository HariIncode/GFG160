package Arrays;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args){
        int[] arr = { 1, 4, 3, 2, 6, 5 };

//        method1(arr); //Creating a temp array
//        method2(arr); //By using swap method
        method3(arr); //Using for loop and iterating only half

        System.out.println(Arrays.toString(arr));
    }

    static void method1(int[] arr){
        int[] temp = new int[arr.length];

        //copy the original array in reverse order
        for(int i = 0; i < arr.length; i++) {
            temp[i] = arr[arr.length -i -1];
        }

        //copy the temp array to the original array
        System.arraycopy(temp, 0, arr, 0, arr.length);

    }

    static void method2(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while (start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void method3(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n/2; i++) {
            int temp = arr[i];
            arr[i] = arr[n -i -1];
            arr[n -i -1] = temp;
        }
    }
}
