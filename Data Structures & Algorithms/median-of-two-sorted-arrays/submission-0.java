class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] smaller = nums1.length > nums2.length ? nums2 : nums1;
        int[] larger = nums1.length > nums2.length ? nums1 : nums2;
        int totalLength = smaller.length + larger.length;
        int low = 0, high = smaller.length;

        while(low <= high){
            int partationX = (low + high)/2;
            int partationY = (totalLength + 1) /2 - partationX;

            int l1 = partationX == 0 ? Integer.MIN_VALUE : smaller[partationX - 1];
            int r1 = partationX == smaller.length ? Integer.MAX_VALUE : smaller[partationX];

            int l2 = partationY == 0 ? Integer.MIN_VALUE : larger[partationY - 1];;
            int r2 = partationY == larger.length ? Integer.MAX_VALUE : larger[partationY];

            if(l1 <= r2 && l2 <=r1){
                if(totalLength%2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }else{
                    return Math.max(l1,l2);
                }
            }
            if(l1>r2) high = partationX-1;
            else   low = partationX+1;
        }
        return 0 ;
    }
}
