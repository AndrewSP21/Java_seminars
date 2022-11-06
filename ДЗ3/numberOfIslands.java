import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class numberOfIslands {
    static char [][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
    };
    static Integer [][] gridI;
    static public ArrayList <Integer> islandsSize = new ArrayList<Integer>();

    public static void main(String[] args) {
        gridI = new Integer[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                gridI[i][j] = Integer.parseInt(String.valueOf(grid[i][j]));
            }
        }
        System.out.println( maxArreaOfIsland(gridI));
    }
    public static int maxArreaOfIsland(Integer[][] grid){
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1) {
                    int countArea = calculatedArea(i, j, grid);
                    islandsSize.add(countArea);
                }
            }
        }
        return islandsSize.size();
    }
    public static int calculatedArea(int i, int j, Integer[][] grid){
        if (i < 0 || j < 0 || i>= grid.length || j >= grid[0].length || grid [i][j] ==0) return 0;
        grid[i][j] = 0;
        return 1 + calculatedArea(i - 1, j, grid) +calculatedArea(i, j-1, grid) + calculatedArea(i + 1, j, grid) + calculatedArea(i, j + 1, grid);
    }
}
