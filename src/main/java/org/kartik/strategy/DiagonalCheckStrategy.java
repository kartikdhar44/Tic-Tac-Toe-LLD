package org.kartik.strategy;

public class DiagonalCheckStrategy implements IBoardCheckStrategy{
    @Override
    public char check(char[][] grid) {
        char symbol=grid[0][0];
        int i=1;
        for(;i<grid.length;i++){
            if(grid[i][i]!=symbol) break;
        }
        if(i==grid.length) return symbol;
        i=grid.length-1;
        int j=0;
        symbol=grid[i][j];
        while(i>=0 && j<grid[0].length){
            if(grid[i][j]!=symbol) break;
            i--;
            j++;
        }
        if(i==-1 || j==grid[0].length){
            return symbol;
        }
        return 'E';
    }
}
