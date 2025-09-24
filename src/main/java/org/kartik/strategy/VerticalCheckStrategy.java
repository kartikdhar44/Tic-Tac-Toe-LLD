package org.kartik.strategy;

public class VerticalCheckStrategy implements IBoardCheckStrategy{

    @Override
    public char check(char[][] grid) {
        for(int i=0;i<grid[0].length;i++){
            char symbol=grid[0][i];
            if(symbol=='E') continue;
            int j=1;
            for(;j<grid.length;j++){
                if(symbol!=grid[j][i]) break;
            }
            if(j==grid.length){
                return symbol;
            }
        }
        return 'E';
    }
}
