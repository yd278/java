public class Solution {
    public int check(int[] nums, long mid)
    {
        int sum = 0;
        int cnt = 0;
        for(int num : nums)
        {
            if(sum + num > mid)
            {
                cnt++;
                sum = 0;
            }
            sum += num;
        }
        return cnt + 1;
    }
    public int splitArray(int[] nums, int m) {
        long left = 0;
        long right = 0;
        for(int num : nums)
        {
            if(num > left) left = num;
            right = right + (long) num;
        }
        long mid = (left + right) >> 1;
        while(right > left)
        {
            if(check(nums, mid) > m) left = mid + 1;
            else                     right = mid;
            mid = (left + right) >> 1;
        }
        return (int)mid;
    }
}