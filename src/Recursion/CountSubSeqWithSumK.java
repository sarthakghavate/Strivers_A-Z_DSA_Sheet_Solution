package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CountSubSeqWithSumK {
    public static void main(String[] args) {
        int n = 6;
        int [] arr = {5, 2, 3, 10, 6, 8};
        int sum = 10;
        List<Integer> up = new ArrayList<>();
        for(int num: arr){
            up.add(num);
        }

        System.out.println(countSubSeqWithSumEqualsK(0,sum,up));
    }

    private static int countSubSeqWithSumEqualsK(int currSum , int sum , List<Integer> up) {
        // base case
        if(up.isEmpty()){
            // when up is finished and sum of subsequence is equal to sum then return 1 (count it in answer).
            if(currSum == sum){
                return 1;
            }
            // else do not count it in answer so return 0
            return 0;
        }

        int count = 0;
        List<Integer> newUp = new ArrayList<>(up);
        newUp.remove(0);
        count += countSubSeqWithSumEqualsK(currSum,sum,newUp);
        count += countSubSeqWithSumEqualsK(currSum + up.get(0),sum,newUp);

        return count;
    }
}
