class Solution {
    public int rob(int[] nums) {
        
        int prev1 = 0;
        int prev2 = 0; 

        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(num + prev2, prev1);
            prev2 = temp;
        }

        return prev1;

    }
}