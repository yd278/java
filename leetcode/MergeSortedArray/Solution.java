public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int res = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while((i >= 0) && (j >= 0)){
            nums1[res--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while(j >= 0) nums1[res--] = nums2[j--];
    }
}