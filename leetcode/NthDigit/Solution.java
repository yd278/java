public class Solution {
    public int findNthDigit(int n) {
        long base = 9L;
        long order = 1L;
        long nn = (long)n;
        while(nn>base*order){
            nn -= base * order;
            base *= 10L;
            order++;
        }
        long number = ((nn - 1L) / order) + (long)Math.pow(10L,order - 1);
        Long mNumber = new Long(number);
        String sNumber = mNumber.toString();
        int digit =  (int)((nn - 1L) % order);
      
        int ans = sNumber.charAt(digit) - '0';
        return ans;
    }
}