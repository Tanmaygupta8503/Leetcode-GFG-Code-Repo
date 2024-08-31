class RandomizedCollection {
    private Map<Integer, Set<Integer>> map;
    private List<Integer> list;
    private Random random;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean alreadyExists = map.containsKey(val);
        Set<Integer> set = map.getOrDefault(val, new HashSet<>());
        set.add(list.size());
        list.add(val);
        map.put(val, set);
        return !alreadyExists; // Return true if it was not present already
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false; // If val is not present in the collection, return false
        }
        Set<Integer> set = map.get(val);
        int removeIdx = set.iterator().next(); // Get an index of the element to remove
        set.remove(removeIdx); // Remove the index from the set  
        // If the set becomes empty after removal, remove the entry from the map
        if (set.isEmpty()) {
            map.remove(val);
        }
        // If we're removing the last element in the list, just remove it
        if (removeIdx == list.size() - 1) {
            list.remove(list.size() - 1);
        } else {
            // Otherwise, swap the last element in the list with the element at removeIdx
            int lastElement = list.get(list.size() - 1);
            list.set(removeIdx, lastElement); // Replace the element at removeIdx with the last element
            list.remove(list.size() - 1); // Remove the last element
            // Update the index set of the last element in the map
            Set<Integer> lastElementSet = map.get(lastElement);
            lastElementSet.remove(list.size()); // Remove the old index of the last element
            lastElementSet.add(removeIdx); // Add the new index of the last element
        }
        return true;
    }

    public int getRandom() {
        int randomIdx = random.nextInt(list.size());
        return list.get(randomIdx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
