class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(restaurants, (a, b) -> a[1] == b[1]? b[0] - a[0] : b[1] - a[1]);

        for(int [] arr : restaurants) {
            if(veganFriendly == 1) {
                if(arr[2] == 1 && arr[3] <= maxPrice && arr[4] <= maxDistance) {
                    list.add(arr[0]);
                }
            }
            else{
                if(arr[3] <= maxPrice && arr[4] <= maxDistance){
                    list.add(arr[0]);
                }
            }
        }
        return list;
    }
}