package Recursion;
import java.util.List;
import java.util.ArrayList;

public class GenerateAllBinaryStrings {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(generateBinaryStringsHelper(n,0,""));
    }
    private static List<String> generateBinaryStringsHelper(int n,int len,String p) {
        // code here
        if(len == n){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> ans = new ArrayList<>();

        if(p.isEmpty() || p.charAt(len-1) != '1'){
            ans.addAll(generateBinaryStringsHelper(n,len+1,p+'0'));
            ans.addAll(generateBinaryStringsHelper(n,len+1,p+'1'));

        }
        else{
            ans.addAll(generateBinaryStringsHelper(n,len+1,p+'0'));
        }
        return ans;
    }
}
