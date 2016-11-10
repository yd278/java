public class Solution {

    public String removeKdigits(String num, int k) {
        int length = num.length();
        int digit = length - k;
        if (digit == 0) return "0";
        int[][] index = new int[10][10002];
        int[] top = new int[10];
        int[] head = new int[10];
        
        for(int i = 0; i < length; i++)
        {
            int ic = num.charAt(i) - '0';
            index[ic][top[ic]] = i;
            top[ic]++;
        }
        String ans = new String();
        int tail = 0;
        for(; digit > 0; digit--)
        {
            for(int j = 0; j < 10; j++)
            {
                if(head[j]>=top[j] )continue;
                if(index[j][head[j]] <= length - digit)
                {
                    int ic = num.charAt(index[j][head[j]]) - '0';
                    if((ic > 0)||(ans.length()> 0)) ans = ans + num.charAt(index[j][head[j]]);
                    tail = index[j][head[j]];
                    for(int kk = 0; kk < 10; kk++)
                    {
                        while((index[kk][head[kk]]<=tail)&&(head[kk]<=top[kk])) head[kk]++; 
                    }
                    break;
                }
            }
        }
        if(ans.length()==0)ans = "0";
        return ans;

    }
}