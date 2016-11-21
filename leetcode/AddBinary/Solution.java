public class Solution {
    public String addBinary(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        String ans = "";
        if(lengthA > lengthB){
            String tmp = a;
            a = b;
            b = tmp;
        }
        int carry = 0;
        for(int i = 0; i < a.length(); i++){
            int aa = a.charAt(a.length() - i - 1) - '0';
            int bb = b.charAt(b.length() - i - 1) - '0';
            int sum = aa + bb + carry;
            if(sum == 0){
                ans = "0"+ ans;
                carry = 0;
            }else if(sum == 1){
                ans = "1" + ans;
                carry = 0;
            }else if(sum == 2){
                ans = "0" + ans;
                carry = 1;
            }else if(sum == 3){
                ans = "1" + ans;
                carry = 1;
            }
        }
        int pnt = b.length() - a.length() - 1;
        if(carry == 1){
            if(pnt >= 0){
                while (b.charAt(pnt) == '1'){
                    ans = "0" + ans;
                    pnt --;
                    if(pnt < 0) break;
                }
            }
            ans = "1" + ans;
            pnt--;
        }
        if(pnt >= 0){
            ans = b.substring(0,pnt + 1) + ans;
        }
        return ans;
    }
}