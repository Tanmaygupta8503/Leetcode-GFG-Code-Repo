class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++) {
            arr.add(i + 1);
        }
        if(arr.size() == 1) return arr.get(0);
        int ptr = -1+k;
        // System.out.println(arr.get(ptr));
        arr.remove(ptr--);//4
        while(arr.size() > 1) {
            int count = k;
            while(count -- > 0) {//4
                ptr = (ptr + 1) % arr.size();//
            }
            // System.out.println(arr.get(ptr));
            arr.remove(ptr--);
        }
        return arr.get(0);
    }
}