
// in-place
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int index = m+n-1;
        while(i>=0&&j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[index] = nums1[i];
                i--;
            }else{
                nums1[index] = nums2[j];
                j--;
            }
            index--;
        }
        while(i>=0){
            nums1[index] = nums1[i];
            i--;
            index--;
        }
        while(j>=0){
            nums1[index] = nums2[j];
            j--;
            index--;
        }
    }
}

// additional space
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null && nums2 == null){
            return;
        }
        int[] answer = new int[m + n];
        int i = 0, j = 0, k = 0;
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                answer[k] = nums1[i];
                i++;
            }else{
                answer[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i < m){
            answer[k] = nums1[i];
            i++;
            k++;
        }
        while(j < n){
            answer[k] = nums2[j];
            j++;
            k++;
        }
        
        for(int l = 0; l < answer.length; l++){
            nums1[l] = answer[l];
        }
        return;
    }
}
