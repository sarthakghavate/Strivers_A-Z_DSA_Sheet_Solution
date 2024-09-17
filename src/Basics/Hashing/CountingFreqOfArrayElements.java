package Basics.Hashing;
// https://www.geeksforgeeks.org/problems/frequency-of-array-elements-1587115620/0
import java.util.Arrays;
import java.util.HashMap;

public class CountingFreqOfArrayElements {
    public static void main(String[] args) {
        int [] arr = {2, 3, 2, 3, 5};
        int N = 5;
        int P = 5;
        frequencyCount(arr,N,P);
        System.out.println(Arrays.toString(arr));
    }
    public static void frequencyCount(int arr[], int N, int P)
    {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 1; i <= N; i++){
            map.put(i,0);
        }
        /*
                map

            key     val
            1       0
            2       0

            8 9

        */

        for(int element : arr){
            if((map.containsKey(element))){
                map.put(element,map.get(element)+1);
            }
        }

        for(int i = 1; i <= N; i++){
            arr[i-1] = map.get(i);
        }

    }
}
