package com.whl.algo.算法分类.深度遍历;

/*
* 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3
*
* 思路：1)深度递归遍历
*
* */
public class 岛屿数量 {
    public static int countIsland(int[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] grid,int i,int j){
       if(i<0 || j<0 || i>=grid.length || j>grid.length || grid[i][j]==0){
            return;
       }
       grid[i][j]=0;
       dfs(grid,i+1,j);
       dfs(grid,i-1,j);
       dfs(grid,i,j+1);
       dfs(grid,i,j-1);
    }

    public static void main(String[] args) {
        int[][] grid = new int[4][5];
        grid[0][0]=1;
        grid[0][1]=1;
        grid[1][0]=1;
        grid[1][1]=1;
        grid[2][2]=1;
        grid[3][3]=1;
        grid[3][4]=1;
        int ans = countIsland(grid);
        System.out.println(ans);
    }

}
