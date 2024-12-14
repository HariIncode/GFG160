package Arrays;

public class StockBuyAndSellSingleTrans {
    public static void main(String[] args){
        int[] prices = {7, 10, 1, 3, 6, 9, 2};

//        System.out.println(method1(prices)); // Brute Force
        System.out.println(method2(prices)); // Keeping a min and finding res for arr trans
    }

    static int method1(int[] arr){
        int res = 0;

        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                res = Math.max(res, arr[j] - arr[i]);
            }
        }
        return res;
    }
    
    static int method2(int[] arr){
        int res = 0;
        int minSoFar = arr[0];

        for(int i = 0; i < arr.length; i++) {
            minSoFar = Math.min(minSoFar, arr[i]);

            res = Math.max(res, arr[i] - minSoFar);
        }

        return res;
    }
}
