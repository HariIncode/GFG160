package Arrays;

import java.util.Arrays;

public class SecondLargestElement {

    public static void main(String[] args) {

        int[] arr = {12, 35, 1, 10, 34, 1};

//        System.out.println(method1(arr)); //Using Sort function
//        System.out.println(method2(arr)); //Using two pass
        System.out.println(method3(arr)); //Using Single pass
    }

    static int method1(int[] arr) {
        Arrays.sort(arr);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != arr[arr.length - 1]) return arr[i];
        }

        return -1;
    }

    static int method2(int[] arr) {
        int largest = -1;
        for (int j : arr) {
            if (j > largest) largest = j;
        }

        int secondLargest = -1;
        for (int j : arr) {
            if (j > secondLargest && j != largest) secondLargest = j;
        }

        return secondLargest;
    }

    static int method3(int[] arr) {
        int largest = -1;
        int secondLargest = -1;

        for (int j : arr) {
            if (j > largest) {
                secondLargest = largest;
                largest = j;
            } else if (j < largest && j > secondLargest) {
                secondLargest = j;
            }
        }
        return secondLargest;
    }
}
