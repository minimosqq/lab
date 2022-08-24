package com.fish.lab.leetcode;

public class Island {
    public int numIslands(char[][] grid) {
        if (grid == null || grid[0] == null) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    //染色
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if(i < 0 || i >= n || j < 0 || j >= m) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
