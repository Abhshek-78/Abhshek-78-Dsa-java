class Solution {
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) != 0) {
                    return -1;
                }
            }
        }

        int rowSum = 0;
        int colSum = 0;
        int rowMis0 = 0; 
        int colMis0 = 0;

        for (int i = 0; i < n; i++) {
            rowSum += board[0][i];
            colSum += board[i][0];

            if (board[0][i] != (i % 2)) {
                rowMis0++;
            }
            if (board[i][0] != (i % 2)) {
                colMis0++;
            }
        }

        int half = n / 2;
        int ceilHalf = (n + 1) / 2;

  
        if (rowSum != half && rowSum != ceilHalf) return -1;
        if (colSum != half && colSum != ceilHalf) return -1;

        int rowSwaps;
        int colSwaps;

        if (n % 2 == 1) {
          
            if (rowSum * 2 > n) {
              
                rowSwaps = (n - rowMis0) / 2;
            } else {
             
                rowSwaps = rowMis0 / 2;
            }

            if (colSum * 2 > n) {
                colSwaps = (n - colMis0) / 2;
            } else {
                colSwaps = colMis0 / 2;
            }
        } else {
         
            rowSwaps = Math.min(rowMis0, n - rowMis0) / 2;
            colSwaps = Math.min(colMis0, n - colMis0) / 2;
        }

        return rowSwaps + colSwaps;
    }
    
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna