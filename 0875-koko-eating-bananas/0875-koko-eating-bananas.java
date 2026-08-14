class Solution {
    public static boolean canFinish(int[] piles, int h, int speed) {

        long hours = 0;

        for (int pile : piles) {

            hours += (pile + speed - 1) / speed;

        }

        return hours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int pile:piles){
            high=Math.max(high,pile);
        }
        while(low <= high){
            int mid=low+(high-low)/2;
            if(canFinish(piles,h,mid)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna