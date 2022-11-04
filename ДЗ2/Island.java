public class Island {
    static int[][] grid = new int[][] {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
    };

    public static void main(String[] args) {

        System.out.println(maxArreaOfIsland(grid));

    }
    public static int maxArreaOfIsland(int[][] grid){
        int square = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1) {
                    int countArea = calculatedArea(i, j, grid);
                    if (square < countArea) {
                        square = countArea;
                    }
                }
            }
        }
        return square;
    }
    public static int calculatedArea(int i, int j, int[][] grid){
        if (i < 0 || j < 0 || i>= grid.length || j >= grid[0].length || grid [i][j] ==0) return 0;
        grid[i][j] = 0;
        return 1 + calculatedArea(i - 1, j, grid) +calculatedArea(i, j-1, grid) + calculatedArea(i + 1, j, grid) + calculatedArea(i, j + 1, grid);
    }
}
