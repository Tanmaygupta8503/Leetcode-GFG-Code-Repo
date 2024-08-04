class neighborSum {
    int [][] grid;
    int[][] adjacent = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] diagonal = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

    public neighborSum(int[][] grid) {
        this.grid = grid;
    }

    public boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    public int adjacentSum(int value) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == value) {
                    int x = i;
                    int y = j;
                    for (int[] pt : adjacent) {
                        if (isValid(x + pt[0], y + pt[1])) {
                            sum += grid[x + pt[0]][y + pt[1]];
                        }
                    }
                    return sum;
                }
            }
        }
        return 0;
    }

    public int diagonalSum(int value) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == value) {
                    int x = i;
                    int y = j;
                    for (int[] pt : diagonal) {
                        if (isValid(x + pt[0], y + pt[1])) {
                            sum += grid[x + pt[0]][y + pt[1]];
                        }
                    }
                    return sum;
                }
            }
        }
        return 0;
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */