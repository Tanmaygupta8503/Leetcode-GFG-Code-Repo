class Solution {
public:
    int passThePillow(int n, int time) {
        int count = time / (n - 1); // complete round
        int extra = time % (n - 1); // extra time left after the time
        if(count % 2) { //odd
            return  n - extra;
        }else{
            return extra + 1;
        }
    }
};