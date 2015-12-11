public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return 0;
        }
        int len = nums1.length + nums2.length;
        if(len % 2 == 0){
            
            return (findKthNumber(nums1, 0, nums2, 0, len / 2) + findKthNumber(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        }else{
            return findKthNumber(nums1, 0, nums2, 0, len / 2 + 1); 
        }
    }
    
    public double findKthNumber(int[] nums1, int index1, int[] nums2, int index2, int k){
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(index1 >= len1){
            return nums2[index2 + k - 1];
        }
        if(index2 >= len2){
            return nums1[index1 + k - 1];
        }
        // base case
        if(k == 1){
            return Math.min(nums1[index1],nums2[index2]);
        }
       // int kNew = k - k/2;
        int nums1Key = (index1 + k / 2 - 1 >= len1) ? Integer.MAX_VALUE : nums1[index1 + k / 2 - 1];
        int nums2Key = (index2 + k / 2 - 1 >= len2) ? Integer.MAX_VALUE : nums2[index2 + k / 2 - 1];
        if(nums1Key < nums2Key){
            return findKthNumber(nums1, index1 + k / 2, nums2, index2, k - k / 2);
        }else{
            return findKthNumber(nums1, index1, nums2, index2 + k / 2, k - k / 2);
        }
    }
}
