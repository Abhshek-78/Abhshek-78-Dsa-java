class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        return solve(n, arr);
    }
    public int solve(int n, int[] arr) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (arr[n] != -1) {
            return arr[n];
        }

        int l = solve(n - 1, arr);
        int m = solve(n - 2, arr);

        arr[n] = l + m;
        return arr[n];
  
}
}