class Solution {
    static class Edge {
        int u;
        int v;
        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph, int[][] conditions) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] condition : conditions) {
            int u = condition[0];
            int v = condition[1];
            graph[u].add(new Edge(u, v));
        }
    }
    public static boolean topologicalSort(ArrayList<Edge>[] graph, boolean[] visited, boolean[] recStack, int curr, ArrayList<Integer> list) {
        if (recStack[curr]) {
            return false; 
        }
        if (visited[curr]) {
            return true;
        }
        visited[curr] = true;
        recStack[curr] = true;
        for (Edge edge : graph[curr]) {
            if (!topologicalSort(graph, visited, recStack, edge.v, list)) {
                return false;
            }
        }
        recStack[curr] = false;
        list.add(0, curr); 
        return true;
    }
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int rowMax = k;
        int colMax = k;
        ArrayList<Edge>[] rowGraph = new ArrayList[rowMax + 1];
        ArrayList<Edge>[] colGraph = new ArrayList[colMax + 1];
        createGraph(rowGraph, rowConditions);
        createGraph(colGraph, colConditions);
        ArrayList<Integer> rowSort = new ArrayList<>();
        ArrayList<Integer> colSort = new ArrayList<>();
        boolean[] visited = new boolean[rowMax + 1];
        boolean[] recStack = new boolean[rowMax + 1];
        for (int i = 1; i <= rowMax; i++) {
            if (!visited[i]) {
                if (!topologicalSort(rowGraph, visited, recStack, i, rowSort)) 
                {
                    return new int[0][0]; 
                }
            }
        }
        visited = new boolean[rowMax + 1];
        recStack = new boolean[rowMax + 1];
        for (int i = 1; i <= colMax; i++) {
            if (!visited[i]) {
                if (!topologicalSort(colGraph, visited, recStack, i, colSort)) {
                    return new int[0][0];  
                }
            }
        }
        if (rowSort.size() != k || colSort.size() != k) {
            return new int[0][0];  
        }
        int[][] matrix = new int[k][k];
        HashMap<Integer, Integer> colPositionMap = new HashMap<>();
        for (int i = 0; i < colSort.size(); i++) {
            colPositionMap.put(colSort.get(i), i);
        }
        for (int i = 0; i < rowSort.size(); i++) {
            int element = rowSort.get(i);
            if (colPositionMap.containsKey(element)) {
                int colIndex = colPositionMap.get(element);
                matrix[i][colIndex] = element;
            } else {
                return new int[0][0];  
            }
        }
        return matrix;
    }
}