package Arrays.Easy;
// https://leetcode.com/problems/missing-number/description/

/*
BRUTE FORCE : Make a set , add all the elements to set and simultaneously find the max in the array.
              after that check from 0 to max if set contains the number if no return number, else return max+1
              TC : O(N)
              SC : O(N)

 OPTIMAL SOL : Bit manipulation!!
               Observe the pattern
               a        XOR form 0 to a
               0        0^0 = 0
               1        0^1 = 1
               2        1^2 = 3
               3        3^3 = 0
               4        0^4 = 4
               5        4^5 = 1
               6        1^6 = 7
               7        7^7 = 0
               8        0^8 = 8

        observation :
                      a = 0 , a = 4 , a = 8     (a % 4) == 0 => gives 'a' itself
                      a = 1 , a = 5             (a % 4) == 1 => gives 1
                      a = 2,  a= 6              (a % 4) == 2 => gives a+1
                      a = 3, a = 7              (a % 4) == 3 => gives 0

 */
public class MissingNumber {
    public static void main(String[] args) {
        int [] nums = {9,6,4,2,3,5,7,0,1};
        int ans = findMissingNumber(nums);
        System.out.println(ans);
    }
    private static int findMissingNumber(int [] nums){
        int arrXOR = 0;
        for(int num : nums){
            arrXOR ^= num;
        }
        int numXOR = findXOR(nums.length);
//        System.out.println(arrXOR);
//        System.out.println(numXOR);
//        System.out.println(arrXOR^numXOR);
        return (arrXOR^numXOR);
    }
    private static int findXOR(int n){
        if(n % 4 == 0){
            return n;
        }
        if(n % 4 == 1){
            return 1;
        }
        if(n % 4 == 2){
            return n+1;
        }
        return 0;
    }
}
