class Solution {
    public long dividePlayers(int[] skill) {
        Long sum = 0L;
        Arrays.sort(skill);
        int i = 0;
        int j = skill.length - 1;
        int k = skill[0] + skill[skill.length - 1];
        while(i <= j){
            if(k!=(skill[i]+skill[j]))
                return -1;
            sum += skill[i ++] * skill[j --];
        }
        return sum;
    }
}