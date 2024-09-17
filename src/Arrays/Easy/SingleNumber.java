package Arrays.Easy;

public class SingleNumber {
    public static void main(String[] args) {
        int [] nums =  {4,1,2,1,2};
        int ans = singleNumber(nums);
        System.out.println(ans);
    }
    public static int singleNumber(int[] nums) {
        int xor = 0;
        for(int el : nums){
            xor ^= el;
        }
        return xor;
    }
}
