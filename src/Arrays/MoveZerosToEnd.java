package Arrays;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};

//        method1(arr); //Creating a temp array
//        method2(arr); //Moving non-Zero ele to front and add zeros to end
        method3(arr); //Shifting ele to the front(best)

        System.out.println(Arrays.toString(arr));
    }

    static void method1(int[] arr) {
        int[] temp = new int[arr.length];
        int pointer = 0;
        for (int j : arr) {
            if (j != 0) {
                temp[pointer++] = j;
            }
        }
        while (pointer > arr.length) {
            temp[pointer++] = 0;
        }
        System.arraycopy(temp, 0, arr, 0, arr.length);
    }

    static void method2(int[] arr){
        int pointer = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                arr[pointer++] = arr[i];
            }
        }
        while(pointer < arr.length){
            arr[pointer++] = 0;
        }
    }

    static void method3(int[] arr) {
        int pointer = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                int temp = arr[i];
                arr[i] = arr[pointer];
                arr[pointer++] = temp;
            }
        }
    }
}
