class TreeAncestor {
    private int[][] up;
    private int maxPower;
    public TreeAncestor(int n, int[] parent) {
        this.maxPower = 16;
        this.up = new int[n][maxPower];
        for (int i = 0; i < n; i++) {
            up[i][0] = parent[i];
        }

        for (int j = 1; j < maxPower; j++) {
            for (int i = 0; i < n; i++) {
                int intermediate = up[i][j - 1];
                if (intermediate == -1) {
                    up[i][j] = -1;
                } else {
                    up[i][j] = up[intermediate][j - 1];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < maxPower; j++) {
            if (((k >> j) & 1) == 1) {
                node = up[node][j];
                if (node == -1) {
                    return -1;
                }
            }
        }
        return node;
    }
    
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna