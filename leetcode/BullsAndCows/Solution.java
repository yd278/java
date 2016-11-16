public class Solution {
    public String getHint(String secret, String guess) {
        int[] gCnt = new int[10];
        int[] sCnt = new int[10];
        int length = secret.length();
        int a = 0;
        int b = 0;
        for(int i = 0; i < length; i++){
            if(secret.charAt(i) == guess.charAt(i)) a++;
            else{
                sCnt[secret.charAt(i) - '0']++;
                gCnt[ guess.charAt(i) - '0']++;
            }
        }
        for(int i = 0; i < 10; i++){
            b += Math.min(sCnt[i], gCnt[i]);
        }
        String ans = a+"A"+b+"B";
        return ans;
    }
}