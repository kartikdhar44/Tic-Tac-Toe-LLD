package org.kartik.strategy;

public class HorizontalCheckStrategy implements IBoardCheckStrategy{
    @Override
    public char check(char[][] grid) {
        for(int i=0;i<grid.length;i++){
            char symbol=grid[i][0];
            if(symbol=='E') continue;
            int j=1;
            for(;j<grid[0].length;j++){
                if(symbol!=grid[i][j]) break;
            }
            if(j==grid[0].length){
                return symbol;
            }
        }
        return 'E';
    }
}
