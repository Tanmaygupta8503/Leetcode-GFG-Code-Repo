class RandomizedSet {
Map<Integer , Integer> set = new HashMap<>();
List<Integer> list = new ArrayList<>();
Random random = new Random();
    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if(set.containsKey(val)) {
            return false;
        }
        set.put(val , list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!set.containsKey(val)) {
            return false;
        }
        int idx = set.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(idx , lastElement);
        list.remove(list.size() - 1);
        set.put(lastElement , idx);
        set.remove(val);
        return true;
    }
    
    public int getRandom() {
        // System.out.println(list);
        int randomIdx = random.nextInt(list.size());
        return list.get(randomIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */