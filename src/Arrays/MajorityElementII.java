package Arrays;

import java.util.*;

public class MajorityElementII {
    public static void main(String[] args){
        int[] arr = {2, 2, 3, 1, 3, 2, 1, 1};

//        System.out.println(method1(arr)); // Using Two-pointer
//        System.out.println(method2(arr)); // Using hashmap
        System.out.println(method3(arr)); // Moore's Voting algorithm
    }

    static List<Integer> method1(int[] arr){
        int n = arr.length;
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int count = 0;

            for(int j = i; j < n; j++) {
                if(arr[j] == arr[i]) count++;
            }

            if(count > (n/3)){
                if(res.isEmpty() || arr[i] != res.getFirst()){
                    res.add(arr[i]);
                }
            }

            if(res.size() == 2){
                if (res.getFirst() > res.get(1)){
                    Collections.swap(res,0,1);
                    break;
                }
            }
        }

        return res;
    }

    static List<Integer> method2(int[] arr){
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int num: arr){
            freq.put( num, freq.getOrDefault( num, 0) + 1 );
        }

        for(Map.Entry<Integer,Integer> entry: freq.entrySet()){
            int ele = entry.getKey();
            int val = entry.getValue();

            if(val > (n/3)) res.add(ele);
        }

        res.sort(null);
        return res;
    }

    static List<Integer> method3(int[] arr){
        int n = arr.length;
        int ele1 = -1, ele2 = -1;
        int cnt1 = 0, cnt2 = 0;

        for(int ele: arr){
            if(ele1 == ele) cnt1++;
            else if(ele2 == ele) cnt2++;
            else if(cnt1 == 0) { ele1 = ele; cnt1++;}
            else if(cnt2 == 0) { ele2 = ele; cnt2++;}
            else {cnt1--; cnt2--;}
        }

        List<Integer> res = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;

        for(int ele :arr){
            if(ele1 == ele) cnt1++;
            if(ele2 == ele) cnt2++;
        }

        if(cnt1 > n/3) res.add(ele1);
        if(cnt2 > n/3) res.add(ele2);

        if(res.size() == 2 && res.getFirst() > res.getLast()){
            int temp = res.getFirst();
            res.set(0, res.getLast());
            res.set(1,temp);
        }

        return res;
    }
}
