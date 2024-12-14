package Arrays;

public class StockBuyAndSellMultipleTrans {
    public static void main(String[] args){
        int[] prices = {100, 180, 260, 310, 40, 535, 695};

//        System.out.println(method1(prices)); // Find Dip and Peak then find result
        System.out.println(method2(prices)); // Find res for every day
    }

    static int method1(int[] arr){
        int res = 0;
        int min = arr[0];
        int max = arr[0];
        int i = 0;
        int n = arr.length;

        while(i < n - 1){

            while ( (i < n - 1) && arr[i] > arr[i+1]){ i++; }
            min = arr[i];

            while ( (i < n - 1) && arr[i] <= arr[i+1]) { i++; }
            max = arr[i];

            res += max - min;
        }

        return res;
    }

    static int method2(int[] arr){
        int res = 0;
        int n = arr.length;

        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[i-1]){
                res += arr[i] - arr[i-1];
            }
        }

        return res;
    }
}
