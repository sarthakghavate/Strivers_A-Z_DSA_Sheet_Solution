package Arrays.Easy;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int [] nums = {1,0,1,1,0,1};
        int ans = findMaxConsecutiveOnes(nums);
        System.out.println(ans);
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int j = 0;
        int count = 0;
        int max = 0;
        while(i < nums.length && j < nums.length){
            if(nums[i] == 1 && nums[j] == 1){
                count++;
                j++;
            }
            if(nums[i] == 0 && nums[j] == 0){
                count = 0;
                i++;
                j++;
            }
            else{
                max = Math.max(max,count);
                i++;
                j = i;
            }
        }
        return max;
    }
}
