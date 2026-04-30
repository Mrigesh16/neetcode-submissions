class Solution {
    public int numIslands(char[][] grid) {
        int totalIslands = 0;
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        for(int i = 0; i<r;i++){
            for(int j = 0; j<c; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(grid,r,c,visited,i,j);
                    totalIslands++;
                }
            }
        }
        return totalIslands;
        
    }
    void dfs(char[][] grid, int r, int c, boolean[][]visited, int i, int j){
        if(i<0 || j<0 || i>=r || j >=c || visited[i][j] || grid[i][j] == '0')
            return;
        visited[i][j] = true;
        dfs(grid,r,c,visited,i,j-1);
        dfs(grid,r,c,visited,i,j+1);
        dfs(grid,r,c,visited,i+1,j);
        dfs(grid,r,c,visited,i-1,j);
    }
}