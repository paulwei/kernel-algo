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
输出：岛屿数量：3 最大面积 4
*
* 思路：1)深度递归遍历
*
* */
public class 岛屿最大面积 {
    public static int maxAreaIsland(int[][] grid) {
        int max = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    max =Math.max(max,dfs(grid,i,j));
                }
            }
        }
        return max;
    }

    public static int dfs(int[][] grid,int i,int j){
       if(i<0 || j<0 || i>=grid.length || j>grid.length || grid[i][j]==0){
            return 0;
       }
       int sum = 1;
       grid[i][j]=0;
       sum += dfs(grid,i+1,j);
       sum += dfs(grid,i-1,j);
       sum += dfs(grid,i,j+1);
       sum += dfs(grid,i,j-1);
       return sum;
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
        int ans = maxAreaIsland(grid);
        System.out.println(ans);
    }

}
