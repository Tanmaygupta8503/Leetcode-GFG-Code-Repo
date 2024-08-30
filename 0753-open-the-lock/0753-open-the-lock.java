class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set_of_deadends = new HashSet<>();
        for(String s : deadends) {
            set_of_deadends.add(s);
        }
        if(set_of_deadends.contains("0000")) return -1;
        Map<Character , List<Character>> map = new HashMap(){
            {
                put('0' , List.of('1' , '9'));
                put('1' , List.of('0' , '2'));
                put('2' , List.of('1' , '3'));
                put('3' , List.of('2' , '4'));
                put('4' , List.of('3' , '5'));
                put('5' , List.of('4' , '6'));
                put('6' , List.of('5' , '7'));
                put('7' , List.of('6' , '8'));
                put('8' , List.of('7' , '9'));
                put('9' , List.of('8' , '0'));
            }
        };
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        set_of_deadends.add("0000");
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i ++){
                String node = queue.poll();
                if(node.equals(target)) {
                    return level;
                }
                char node_array[] = node.toCharArray();
                for(int j = 0 ; j < 4 ; j ++) {
                    char currNumber = node_array[j];
                    for(char nextNum : map.get(currNumber)){
                        node_array[j] = nextNum;
                        String nextStateOfLock = new String(node_array);
                        if(!set_of_deadends.contains(nextStateOfLock)){
                            queue.add(nextStateOfLock);
                            set_of_deadends.add(nextStateOfLock);
                        }
                    }
                    node_array[j] = currNumber;
                }
            }
            level ++;
        }
        return -1;
    }
}