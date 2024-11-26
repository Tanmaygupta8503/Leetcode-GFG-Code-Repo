class Solution {
    int[] dx = {0, 1, 0, -1}; // right, down, left, up
    int[] dy = {1, 0, -1, 0};
    Map<String, Integer> memo = new HashMap<>();
    int minSteps = Integer.MAX_VALUE;

    public int slidingPuzzle(int[][] board) {
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start.append(board[i][j]);
            }
        }

        String startConfig = start.toString();
        String target = "123450";

        // If the initial board is already solved
        if (startConfig.equals(target)) {
            return 0;
        }

        // Find the position of '0'
        int zeroIndex = startConfig.indexOf('0');
        int zeroX = zeroIndex / 3, zeroY = zeroIndex % 3;

        // Start DFS
        int steps = dfs(board, zeroX, zeroY, startConfig, target, 0);

        return steps == Integer.MAX_VALUE ? -1 : steps;
    }

    int dfs(int[][] board, int i, int j, String config, String target, int steps) {
        // Base case: If solved, return the number of steps
        if (config.equals(target)) {
            return steps;
        }

        // Pruning: If already visited with fewer steps, skip
        if (memo.containsKey(config) && memo.get(config) <= steps) {
            return Integer.MAX_VALUE;
        }
        memo.put(config, steps);

        // Explore all possible moves
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < 2 && y >= 0 && y < 3) {
                // Convert the config string to a mutable StringBuilder
                StringBuilder nextConfig = new StringBuilder(config);
                int zeroIndex = i * 3 + j;
                int swapIndex = x * 3 + y;

                // Swap '0' with the new position
                nextConfig.setCharAt(zeroIndex, nextConfig.charAt(swapIndex));
                nextConfig.setCharAt(swapIndex, '0');

                // Recursive call
                int result = dfs(board, x, y, nextConfig.toString(), target, steps + 1);
                min = Math.min(min, result);
            }
        }

        return min;
    }
}

class Solution1 {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    Set<String> vis = new HashSet<>();  

    public int slidingPuzzle(int[][] board) {
        StringBuilder start = toString(board);
        String target = "123450"; 

        if (start.toString().equals(target)) return 0;
        Queue<StringBuilder> queue = new LinkedList<>();
        queue.add(start);
        vis.add(start.toString());
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                StringBuilder curr = queue.poll();
                int zeroIndex = curr.indexOf("0");
                int x = zeroIndex / 3;
                int y = zeroIndex % 3;
                if (curr.toString().equals(target)) {
                    return steps;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < 2 && ny >= 0 && ny < 3) {
                        int newIndex = nx * 3 + ny;
                        StringBuilder nextConfig = new StringBuilder(curr.toString());
                        swap(nextConfig, zeroIndex, newIndex);
                        if (!vis.contains(nextConfig.toString())) {
                            queue.add(nextConfig);
                            vis.add(nextConfig.toString());
                        }
                    }
                }
            }
            steps++; 
        }
        return -1;
    }

    void swap(StringBuilder s, int i, int j) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }

    StringBuilder toString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
        }
        return sb;
    }
}
