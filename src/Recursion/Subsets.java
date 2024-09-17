package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        List<Integer> up = new ArrayList<>();
        for(int num : nums){
            up.add(num);
        }

        List<List<Integer>> ans = subsets(new ArrayList<>(),up);
        for(List<Integer> ls : ans){
            System.out.println(ls);
        }
    }
    private static List<List<Integer>> subsets(List<Integer> p , List<Integer> up){
        if(up.isEmpty()){
            List<List<Integer>> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> newP = new ArrayList<>(p);
        List<Integer> newUp = new ArrayList<>(up);
        newP.add(newUp.remove(0));

        ans.addAll(subsets(p,newUp));
        ans.addAll(subsets(newP,newUp));

        return ans;
    }
}
