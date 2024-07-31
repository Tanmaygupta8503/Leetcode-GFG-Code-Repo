class Solution {
    int shelfWidth;
    Map<String , Integer> map;
    public int minHeightShelves(int[][] books, int shelfWidth) {
        this.shelfWidth = shelfWidth;
        map = new HashMap<>();
        return solve(books , 0 , 0 , 0);
    }
    public int solve(int [][]books , int i , int width , int maxHeight){
        if(i >= books.length) {
            return maxHeight;
        }
        String key = i + "" + maxHeight + "" + width;
        if(map.containsKey(key)) return map.get(key);
        int op1 = 0 , op2 = 0;
        // option1 put in this shelf if can be put
        if(width + books[i][0] <= shelfWidth){
            //put in this shelf 
            op1 = solve(books , i + 1 , width + books[i][0] , Math.max(books[i][1] , maxHeight)) ;
            // in next shelf
            op2 = maxHeight + solve(books , i + 1 , books[i][0] , books[i][1]);
            map.put(key , Math.min(op1 , op2));
            return Math.min(op1 , op2);
        }
        else {
            // option2 put it in next shelf it is not possible in previous shelf
            int option = maxHeight + solve(books , i + 1 , books[i][0] , books[i][1]);
            map.put(key , option);
            return map.get(key);
        }
    }
}