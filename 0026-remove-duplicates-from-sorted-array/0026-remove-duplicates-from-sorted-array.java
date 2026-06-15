class Solution {
    public int removeDuplicates(int[] nums) {
        int upper=0;
        int res=1;
        int lower=1;
        int n=nums.length;
        while(lower < n){
            if(nums[lower]==nums[lower-1]){
                lower++;
                continue;
            }
            nums[upper+1]=nums[lower];
            upper++;
            res++;
            lower++;
        }
        return res;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna