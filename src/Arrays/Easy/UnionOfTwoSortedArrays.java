package Arrays.Easy;

import java.util.ArrayList;
public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int n = 2;
        int m = 3;
        int [] arr1 = {-7,8};
        int [] arr2 = {-8,-3,8};
        ArrayList<Integer> ans = findUnion(arr1,arr2,n,m);
        System.out.println(ans);
    }
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n && j < m){

           if(arr1[i] > arr2[j]){
                if(list.isEmpty() || list.get(list.size()-1) != arr2[j]){
                    list.add(arr2[j]);
                }
                j++;
            }
            else{
               if(list.isEmpty() || list.get(list.size()-1) != arr1[i]){
                   list.add(arr1[i]);
               }
                i++;
            }
        }

        while(i < n){
            if(list.isEmpty() || list.get(list.size()-1) != arr1[i]){
                list.add(arr1[i]);
            }
            i++;
        }
        while(j < m){
            if(list.isEmpty() || list.get(list.size()-1) != arr2[j]){
                list.add(arr2[j]);
            }
            j++;
        }

        return list;
    }

}
