class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        
        int rows = board.length;
        int cols = board[0].length;
        
        // 1. Traverse border cells to find all 'O's connected to the boundary
        for (int r = 0; r < rows; r++) {
            dfs(board, r, 0);          // Left border
            dfs(board, r, cols - 1);    // Right border
        }
        for (int c = 0; c < cols; c++) {
            dfs(board, 0, c);          // Top border
            dfs(board, rows - 1, c);    // Bottom border
        }
        
        // 2. Process board:
        // 'T' (temporary safe 'O') -> 'O'
        // Remaining 'O' (surrounded) -> 'X'
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int r, int c) {
        int rows = board.length;
        int cols = board[0].length;
        
        // Boundary check and condition check
        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != 'O') {
            return;
        }
        
        // Mark as visited/safe using a temporary character
        board[r][c] = 'T';
        
        // Traverse all 4 adjacent directions
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}