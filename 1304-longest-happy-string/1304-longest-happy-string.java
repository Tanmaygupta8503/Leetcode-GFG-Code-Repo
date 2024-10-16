class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(y[1], x[1]));
        if (a > 0) pq.add(new int[]{'a', a});
        if (b > 0) pq.add(new int[]{'b', b});
        if (c > 0) pq.add(new int[]{'c', c});
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int len = sb.length();
            if (len >= 2 && sb.charAt(len - 1) == node[0] && sb.charAt(len - 2) == node[0]) {
                if (pq.isEmpty()) break;
                int[] temp = pq.poll();
                sb.append((char) temp[0]);
                temp[1]--;
                if (temp[1] > 0) pq.add(temp);
                pq.add(node); 
            } else {
                sb.append((char) node[0]);
                node[1]--;
                if (node[1] > 0) pq.add(node); 
            }
        }
        return sb.toString();
    }
}

class Solution1 {
    String ans;
    Map<String, Boolean> map = new HashMap<>();

    public String longestDiverseString(int a, int b, int c) {
        ans = "";
        solve(a, b, c, 0, 0, 0, "");
        return ans;
    }

    public void solve(int a, int b, int c, int i, int j, int k, String s) {
        String key = a + " " + b + " " + c + " " + i + " " + j + " " + k;

        if (map.containsKey(key)) return;
        if (s.length() > ans.length()) {
            ans = s;
        }
        map.put(key, true);
        if (i < 2 && a > 0) {
            solve(a - 1, b, c, i + 1, 0, 0, s + 'a');
        }
        if (j < 2 && b > 0) {
            solve(a, b - 1, c, 0, j + 1, 0, s + 'b');
        }
        if (k < 2 && c > 0) {
            solve(a, b, c - 1, 0, 0, k + 1, s + 'c');
        }
    }
}
