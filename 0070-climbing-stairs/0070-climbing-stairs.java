class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        return solve(n, arr);
    }
    public int solve(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int l = solve(n - 1, dp);
        int m = solve(n - 2, dp);

        dp[n] = l + m;
        return dp[n];
  
}
}