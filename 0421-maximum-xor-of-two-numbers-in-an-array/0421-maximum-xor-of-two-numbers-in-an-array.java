class Solution {
    class BitTrie{
        BitTrie left, right;
    }
    public int findMaximumXOR(int[] nums) {
        BitTrie root = new BitTrie();
        for(int i : nums) {
            insert(root , i);
        }
        int maxResult = 0;
        for(int i : nums) {
            int temp = findMaxXor(root , i);
            maxResult = Math.max(maxResult , temp);
        }
        return maxResult;
    }
    void insert(BitTrie root , int nums) {
        BitTrie crawl = root;
        for(int i = 31 ; i >= 0 ; i --) {
            int ithBit = (nums >> i) & 1;
            if(ithBit == 0) {
                if(crawl.left == null) {
                    crawl.left = new BitTrie();
                    crawl = crawl.left;
                }else{
                    crawl = crawl.left;
                }
            }else{
                if(crawl.right == null) {
                    crawl.right = new BitTrie();
                    crawl = crawl.right;
                }else{
                    crawl = crawl.right;
                }
            }
        }
    }
    int findMaxXor(BitTrie root , int num) {
        int maxXor = 0;
        BitTrie crawl = root;
        for(int i = 31 ; i >= 0 ; i --) {
            int ithBit = (num >> i) & 1;
            if(ithBit == 1) {
                if(crawl.left != null) {
                    maxXor += Math.pow(2 , i);
                    crawl = crawl.left;
                }else{
                    crawl = crawl.right;
                }
            }else{
                if(crawl.right != null) {
                    maxXor += Math.pow(2 , i);
                    crawl = crawl.right;
                }else{
                    crawl = crawl.left;
                }
            }
        }
        return maxXor;
    }
}