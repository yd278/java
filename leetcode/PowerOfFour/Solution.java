public class Solution {
    public int hammingWeight(int n) {
        n = (n & 0x55555555) + ((n >> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >> 8) & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >> 16) & 0x0000ffff);
        return n;
    }
    public boolean isPowerOfFour(int num) {
        int num2 = num & 0x55555555;
        if(hammingWeight(num)==1 && hammingWeight(num2)==1) return true;
        return false;
        
    }
}